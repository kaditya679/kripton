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
package sqlite.kripton51.entities;

import com.abubusoft.kripton.android.sqlite.SQLiteTable;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * Entity <code>MessageEntity</code> is associated to table <code>message</code>
 * This class represents table associated to entity.
 * </p>
 *  @see MessageEntity
 */
public class MessageEntityTable implements SQLiteTable {
  
  /** Costant represents typeName of table message. */
  public static final String TABLE_NAME = "message";

  /** <p> DDL to create table message </p>  <pre>CREATE TABLE message (id INTEGER PRIMARY KEY AUTOINCREMENT, channel_id INTEGER, owner_type TEXT, uid TEXT, face_uid TEXT, text TEXT, owner_uid TEXT, channel_uid TEXT, update_time INTEGER, type TEXT);</pre>. */
  public static final String CREATE_TABLE_SQL = "CREATE TABLE message (id INTEGER PRIMARY KEY AUTOINCREMENT, channel_id INTEGER, owner_type TEXT, uid TEXT, face_uid TEXT, text TEXT, owner_uid TEXT, channel_uid TEXT, update_time INTEGER, type TEXT);";

  /** <p> DDL to drop table message </p>  <pre>DROP TABLE IF EXISTS message;</pre>. */
  public static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS message;";

  /**
   * Entity's property <code>id</code> is associated to table column <code>id</code>. This costant represents column name.
   *
   *  @see MessageEntity#id
   */
  public static final String COLUMN_ID = "id";

  /**
   * Entity's property <code>channelId</code> is associated to table column <code>channel_id</code>. This costant represents column name.
   *
   *  @see MessageEntity#channelId
   */
  public static final String COLUMN_CHANNEL_ID = "channel_id";

  /**
   * Entity's property <code>ownerType</code> is associated to table column <code>owner_type</code>. This costant represents column name.
   *
   *  @see MessageEntity#ownerType
   */
  public static final String COLUMN_OWNER_TYPE = "owner_type";

  /**
   * Entity's property <code>uid</code> is associated to table column <code>uid</code>. This costant represents column name.
   *
   *  @see MessageEntity#uid
   */
  public static final String COLUMN_UID = "uid";

  /**
   * Entity's property <code>faceUid</code> is associated to table column <code>face_uid</code>. This costant represents column name.
   *
   *  @see MessageEntity#faceUid
   */
  public static final String COLUMN_FACE_UID = "face_uid";

  /**
   * Entity's property <code>text</code> is associated to table column <code>text</code>. This costant represents column name.
   *
   *  @see MessageEntity#text
   */
  public static final String COLUMN_TEXT = "text";

  /**
   * Entity's property <code>ownerUid</code> is associated to table column <code>owner_uid</code>. This costant represents column name.
   *
   *  @see MessageEntity#ownerUid
   */
  public static final String COLUMN_OWNER_UID = "owner_uid";

  /**
   * Entity's property <code>channelUid</code> is associated to table column <code>channel_uid</code>. This costant represents column name.
   *
   *  @see MessageEntity#channelUid
   */
  public static final String COLUMN_CHANNEL_UID = "channel_uid";

  /**
   * Entity's property <code>updateTime</code> is associated to table column <code>update_time</code>. This costant represents column name.
   *
   *  @see MessageEntity#updateTime
   */
  public static final String COLUMN_UPDATE_TIME = "update_time";

  /**
   * Entity's property <code>type</code> is associated to table column <code>type</code>. This costant represents column name.
   *
   *  @see MessageEntity#type
   */
  public static final String COLUMN_TYPE = "type";

  /** Columns array. */
  private static final String[] COLUMNS = {COLUMN_ID, COLUMN_CHANNEL_ID, COLUMN_OWNER_TYPE, COLUMN_UID, COLUMN_FACE_UID, COLUMN_TEXT, COLUMN_OWNER_UID, COLUMN_CHANNEL_UID, COLUMN_UPDATE_TIME, COLUMN_TYPE};

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
