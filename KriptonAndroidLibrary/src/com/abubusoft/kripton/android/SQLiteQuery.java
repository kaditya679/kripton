package com.abubusoft.kripton.android;

import java.util.ArrayList;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.abubusoft.kripton.android.adapter.SqliteAdapter;
import com.abubusoft.kripton.binder.database.DatabaseColumn;
import com.abubusoft.kripton.binder.database.Query;
import com.abubusoft.kripton.binder.database.QueryListener;
import com.abubusoft.kripton.exception.MappingException;

public class SQLiteQuery extends Query {

	SQLiteHandler handler;

	@SuppressWarnings("rawtypes")
	ArrayList<SqliteAdapter> columnAdapter = new ArrayList<>();

	@SuppressWarnings("rawtypes")
	ArrayList<SqliteAdapter> filterAdapter = new ArrayList<>();

	ThreadLocal<Object> cachedBeans = new ThreadLocal<Object>();

	ThreadLocal<String[]> filterValues = new ThreadLocal<String[]>();

	public <E> ArrayList<E> execute(SQLiteDatabase database, Class<E> beanClazz) {
		return execute(database, beanClazz, null);
	}

	public <E> void executeWithListener(SQLiteDatabase database, Class<E> beanClazz, QueryListener<E> listener) {
		executeWithListener(database, beanClazz, null, listener);
	}

	public String[] getFilterValues(Object params) {
		String[] filterValuesArray = null;
		switch (filter.origin) {
		case NONE:
			break;
		case ONE_PARAM:
			filterValuesArray = SQLiteHelper.getFilterValuesFromOneParam(filter, filterValues, params, filter.inputClazz);
			break;
		case PARAMS:
			filterValuesArray = SQLiteHelper.getFilterValuesFromParams(filter, filterValues, params, filter.inputClazz);
			break;
		case BEAN:
			filterValuesArray = SQLiteHelper.getFilterValuesFromParams(filter, filterValues, params, table.clazz);
			break;
		}

		return filterValuesArray;
	}

	public <E> ArrayList<E> execute(SQLiteDatabase database, Class<E> beanClazz, Object params) {
		// check for supported bean clazz
		if (!beanClazz.isAssignableFrom(table.clazz)) {
			throw (new MappingException("Query '" + this.name + "' is for class " + table.clazz.getName() + ". It can not be used for " + beanClazz.getName()));
		}

		String[] filterValues = getFilterValues(params);

		ArrayList<E> result = new ArrayList<E>();
		try {
			Cursor cursor = database.rawQuery(getSQL(), filterValues);

			if (cursor.getCount() > 0) {
				@SuppressWarnings("unchecked")
				E bean = (E) cachedBeans.get();
				if (bean == null) {
					bean = beanClazz.newInstance();
					cachedBeans.set(bean);
				}

				cursor.moveToFirst();
				do {
					cursor2Bean(cursor, bean);
					result.add(bean);

				} while (cursor.moveToNext());

				cursor.close();
			}

			return result;
		} catch (Exception e) {
			throw (new MappingException(e.getMessage()));
		}
	}

	/**
	 * Execute query for extract one bean. Every query instance new bean
	 * 
	 * @param database
	 * @param beanClazz
	 * @param params
	 * @return
	 */
	public <E> E executeOne(SQLiteDatabase database, Class<E> beanClazz, Object params) {
		return executeOne(database, beanClazz, params, false);
	}

	public <E> int executeCount(SQLiteDatabase database, Class<E> beanClazz, Object params) {
		// check for supported bean clazz
		if (!beanClazz.isAssignableFrom(table.clazz)) {
			throw (new MappingException("Query '" + this.name + "' is for class " + table.clazz.getName() + ". It can not be used for " + beanClazz.getName()));
		}
		
		int count=0;

		String[] filterValues = getFilterValues(params);

		try {
			Cursor cursor = database. rawQuery(buildSQLCount(), filterValues);

			if (cursor.getCount() > 0) {
				cursor.moveToFirst();
				count=cursor.getInt(0);

				cursor.close();
			}

			return count;

		} catch (Exception e) {
			throw (new MappingException(e.getMessage()));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.abubusoft.kripton.database.SQLStatement#buildSQL()
	 */
	protected String buildSQLCount() {
		StringBuilder sb = new StringBuilder();

		sb.append("select count(*) ");
		sb.append(" from " + table.name);

		if (filter.sql != null && filter.sql.length() > 0) {
			sb.append(" where " + filter.sql);
		}

		if (order != null && order.length() > 0) {
			sb.append(" order by " + order);
		}

		return sb.toString();
	}

	/**
	 * Execute query for extract one bean. Extracted bean can ben cached (one
	 * value for thread).
	 * 
	 * @param database
	 * @param beanClazz
	 * @param params
	 * @param cachedValue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <E> E executeOne(SQLiteDatabase database, Class<E> beanClazz, Object params, boolean cachedValue) {
		// check for supported bean clazz
		if (!beanClazz.isAssignableFrom(table.clazz)) {
			throw (new MappingException("Query '" + this.name + "' is for class " + table.clazz.getName() + ". It can not be used for " + beanClazz.getName()));
		}

		String[] filterValues = getFilterValues(params);

		try {
			E bean = null;
			Cursor cursor = database.rawQuery(getSQL(), filterValues);

			if (cursor.getCount() > 0) {
				if (cachedValue) {
					bean = (E) cachedBeans.get();
					if (bean == null) {
						bean = beanClazz.newInstance();
						cachedBeans.set(bean);
					}
				} else {
					bean = beanClazz.newInstance();
				}

				cursor.moveToFirst();
				cursor2Bean(cursor, bean);
				cursor.close();
			}

			return bean;

		} catch (Exception e) {
			throw (new MappingException(e.getMessage()));
		}
	}

	public <E> void executeWithListener(SQLiteDatabase database, Class<E> beanClazz, Object params, QueryListener<E> listener) {
		// check for supported bean clazz
		if (!beanClazz.isAssignableFrom(table.clazz)) {
			throw (new MappingException("Query '" + this.name + "' is for class " + table.clazz.getName() + ". It can not be used for " + beanClazz.getName()));
		}

		String[] filterValues = getFilterValues(params);

		try {
			Cursor cursor = database.rawQuery(getSQL(), filterValues);

			if (cursor.getCount() > 0) {
				int index = 0;
				@SuppressWarnings("unchecked")
				E bean = (E) cachedBeans.get();
				if (bean == null) {
					bean = beanClazz.newInstance();
					cachedBeans.set(bean);
				}

				cursor.moveToFirst();
				do {
					cursor2Bean(cursor, bean);
					listener.onRow(index, bean);
					index++;
				} while (cursor.moveToNext());

				cursor.close();
			}

		} catch (Exception e) {
			throw (new MappingException(e.getMessage()));
		}
	}

	protected void cursor2Bean(Cursor cursor, Object bean) {
		DatabaseColumn col = null;
		SqliteAdapter<?> adapter;

		try {
			for (int i = 0; i < columns.length; i++) {
				col = columns[i];
				adapter = columnAdapter.get(i);

				col.schema.setFieldValue(bean, adapter.readCursor(cursor, i));
			}
		} catch (Exception e) {
			if (col != null)
				throw (new MappingException("Error during mapping column " + col.name + " from bean. Reason " + e.getMessage()));

			throw (new MappingException("Error during mapping columns from bean. Reason " + e.getMessage()));
		}
	}

}
