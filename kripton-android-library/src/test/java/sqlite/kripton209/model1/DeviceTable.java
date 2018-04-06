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
package sqlite.kripton209.model1;

import com.abubusoft.kripton.android.sqlite.SQLiteTable;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * Entity <code>Device</code> is associated to table <code>device</code>
 * This class represents table associated to entity.
 * </p>
 *  @see Device
 */
public class DeviceTable implements SQLiteTable {
  
  /** Costant represents typeName of table device. */
  public static final String TABLE_NAME = "device";

  /** <p> DDL to create table device </p>  <pre>CREATE TABLE device (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);</pre>. */
  public static final String CREATE_TABLE_SQL = "CREATE TABLE device (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);";

  /** <p> DDL to drop table device </p>  <pre>DROP TABLE IF EXISTS device;</pre>. */
  public static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS device;";

  /**
   * Entity's property <code>id</code> is associated to table column <code>id</code>. This costant represents column name.
   *
   *  @see Device#id
   */
  public static final String COLUMN_ID = "id";

  /**
   * Entity's property <code>name</code> is associated to table column <code>name</code>. This costant represents column name.
   *
   *  @see Device#name
   */
  public static final String COLUMN_NAME = "name";

  /** Columns array. */
  private static final String[] COLUMNS = {COLUMN_ID, COLUMN_NAME};

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
