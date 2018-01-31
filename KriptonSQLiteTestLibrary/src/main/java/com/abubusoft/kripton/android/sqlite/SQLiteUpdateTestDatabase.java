package com.abubusoft.kripton.android.sqlite;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.abubusoft.kripton.android.KriptonLibrary;
import com.abubusoft.kripton.android.Logger;
import com.abubusoft.kripton.common.One;
import com.abubusoft.kripton.exception.KriptonRuntimeException;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteUpdateTestDatabase {

	public static Builder builder(int version, InputStream initialSchemaInputStream) {
		return new Builder(version, initialSchemaInputStream);
	}

	public static Builder builder(int version, Context context, int initialSchemaRawResourceId) {
		return new Builder(version, context.getResources().openRawResource(initialSchemaRawResourceId));
	}

	public static class Builder {

		private int version;

		private List<SQLiteUpdateTask> updateTasks;

		private InputStream initialSchemaInputStream;

		private int initialSchemaResourceRawId;

		Builder(int version, InputStream initialSchemaInputStream) {
			this.version = version;
			this.initialSchemaInputStream = initialSchemaInputStream;
			this.updateTasks = new ArrayList<>();
		}

		public Builder addVersionUpdateTask(SQLiteUpdateTask task) {
			updateTasks.add(task);

			return this;
		}

		public Builder addVersionUpdateTask(int currentVersion, InputStream updateSqlInputStream) {
			SQLiteUpdateTaskFromFile task = new SQLiteUpdateTaskFromFile(currentVersion, updateSqlInputStream);
			updateTasks.add(task);

			return this;
		}

		public Builder addVersionUpdateTask(int currentVersion, Context context, int updateSqlRawResourceId) {
			SQLiteUpdateTaskFromFile task = new SQLiteUpdateTaskFromFile(currentVersion,
					context.getResources().openRawResource(updateSqlRawResourceId));
			updateTasks.add(task);

			return this;
		}

		/**
		 * build and create test database
		 * 
		 * @return
		 */
		public SQLiteUpdateTestDatabase build() {
			Collections.sort(updateTasks, new Comparator<SQLiteUpdateTask>() {

				@Override
				public int compare(SQLiteUpdateTask entry0, SQLiteUpdateTask entry1) {
					return (entry0.previousVersion == entry1.previousVersion)
							? (entry0.currentVersion - entry1.currentVersion)
							: (entry0.previousVersion - entry1.previousVersion);
				}
			});

			SQLiteUpdateTestDatabase helper = new SQLiteUpdateTestDatabase(KriptonLibrary.context(), null, version,
					null, initialSchemaInputStream, initialSchemaResourceRawId, updateTasks);

			return helper.create();
		}

	}

	public static final String MIGRATION_TEST = "migration-test.db";

	private SQLiteOpenHelper sqlite;

	private List<SQLiteUpdateTask> updateTasks;

	private CursorFactory factory;

	private DatabaseErrorHandler errorHandler;

	private int version;

	private InputStream firstSchemaDefinitionInputStream;

	private int firstSchemaDefinitionResourceId;

	private Context context;

	SQLiteUpdateTestDatabase(Context context, CursorFactory factory, int version, DatabaseErrorHandler errorHandler,
			InputStream initialSchemaInputStream, int initialSchemaResourceId, List<SQLiteUpdateTask> updateTasks) {
		this.version = version;
		this.factory = factory;
		this.context = context;
		this.errorHandler = errorHandler;
		this.firstSchemaDefinitionInputStream = initialSchemaInputStream;
		this.firstSchemaDefinitionResourceId = initialSchemaResourceId;
		this.updateTasks = updateTasks;
	}

	/**
	 * create database with specified version by builder.
	 * 
	 * @return
	 */
	private SQLiteUpdateTestDatabase create() {
		sqlite = new SQLiteOpenHelper(context, MIGRATION_TEST, factory, version, errorHandler) {

			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
				throw (new KriptonRuntimeException("Unsupported situation"));
			}

			@Override
			public void onCreate(SQLiteDatabase database) {
				if (firstSchemaDefinitionInputStream != null) {
					Logger.info("Load DDL from input stream");
					SQLiteSchemaVerifierHelper.executeSQL(database, firstSchemaDefinitionInputStream);
				} else {
					Logger.info("Load DDL from resourceId");
					SQLiteSchemaVerifierHelper.executeSQL(database, context, firstSchemaDefinitionResourceId);
				}
			}
		};
		sqlite.getWritableDatabase();
		sqlite.close();

		return this;
	}

	/**
	 * Allow to update database version to <i>version</i>. This method allows to
	 * specify the destination version schema and compare it with schema
	 * resulting by version update applied.
	 * 
	 * @param version
	 * @param schemaDefinitionInputStream
	 */
	public void updateAndVerify(int version, final InputStream schemaDefinitionInputStream) {
		sqlite = new SQLiteOpenHelper(context, MIGRATION_TEST, factory, version, errorHandler) {

			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
				List<SQLiteUpdateTask> task = findTask(oldVersion, newVersion);

				for (SQLiteUpdateTask item : task) {
					item.execute(db);
				}
			}

			@Override
			public void onCreate(SQLiteDatabase db) {
				throw (new KriptonRuntimeException("Unsupported situation"));

			}
		};

		SQLiteSchemaVerifierHelper.verifySchema(sqlite.getWritableDatabase(), schemaDefinitionInputStream);
	}

	/**
	 * Allow to update database version to <i>version</i>. This method allows to
	 * specify the destination version schema and compare it with schema
	 * resulting by version update applied.
	 * 
	 * @param version
	 * @param context
	 * @param schemaDefinitionRawResourceId
	 */
	public void updateAndVerify(int version, final Context context, final int schemaDefinitionRawResourceId) {
		updateAndVerify(version, context.getResources().openRawResource(schemaDefinitionRawResourceId));
	}

	List<SQLiteUpdateTask> findTask(int previousVersion, int currentVersion) {
		List<SQLiteUpdateTask> result = new ArrayList<>();
		final One<Integer> ref = new One<>(null);
		for (int i = previousVersion; i < currentVersion; i++) {
			ref.value0 = i;
			SQLiteUpdateTask t = null;
			for (SQLiteUpdateTask item : updateTasks) {
				if (item.previousVersion == ref.value0) {
					t = item;
					break;
				}
			}

			if (t != null) {
				result.add(t);
			}
		}

		return result;

	}

}
