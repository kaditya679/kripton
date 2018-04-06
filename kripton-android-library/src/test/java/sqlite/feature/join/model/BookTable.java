/*******************************************************************************
 * Copyright 2018 Francesco Benincasa (info@abubusoft.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package sqlite.feature.join.model;

import com.abubusoft.kripton.android.sqlite.SQLiteTable;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * Entity <code>Book</code> is associated to table <code>book</code>
 * This class represents table associated to entity.
 * </p>
 *  @see Book
 */
public class BookTable implements SQLiteTable {
  
  /** Costant represents typeName of table book. */
  public static final String TABLE_NAME = "book";

  /** <p> DDL to create table book </p>  <pre>CREATE TABLE book (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT);</pre>. */
  public static final String CREATE_TABLE_SQL = "CREATE TABLE book (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT);";

  /** <p> DDL to drop table book </p>  <pre>DROP TABLE IF EXISTS book;</pre>. */
  public static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS book;";

  /**
   * Entity's property <code>id</code> is associated to table column <code>id</code>. This costant represents column name.
   *
   *  @see Book#id
   */
  public static final String COLUMN_ID = "id";

  /**
   * Entity's property <code>title</code> is associated to table column <code>title</code>. This costant represents column name.
   *
   *  @see Book#title
   */
  public static final String COLUMN_TITLE = "title";

  /** Columns array. */
  private static final String[] COLUMNS = {COLUMN_ID, COLUMN_TITLE};

  /**
   * Columns array.
   *
   * @return the string[]
   */
  @Override
  public String[] columns() {
    return COLUMNS;
  }

  /**
   * table name.
   *
   * @return the string
   */
  @Override
  public String name() {
    return TABLE_NAME;
  }
}
