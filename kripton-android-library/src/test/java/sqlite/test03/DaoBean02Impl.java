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
package sqlite.test03;

import android.database.sqlite.SQLiteStatement;
import com.abubusoft.kripton.android.Logger;
import com.abubusoft.kripton.android.sqlite.Dao;
import com.abubusoft.kripton.android.sqlite.KriptonContentValues;
import com.abubusoft.kripton.android.sqlite.KriptonDatabaseWrapper;
import com.abubusoft.kripton.android.sqlite.SQLContext;
import com.abubusoft.kripton.common.StringUtils;
import com.abubusoft.kripton.common.Triple;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * DAO implementation for entity <code>Bean01</code>, based on interface <code>DaoBean02</code>
 * </p>.
 *
 * @see Bean01
 * @see DaoBean02
 * @see Bean01Table
 */
public class DaoBean02Impl extends Dao implements DaoBean02 {
  
  /** The insert prepared statement 0. */
  private static SQLiteStatement insertPreparedStatement0;

  /** The insert prepared statement 1. */
  private static SQLiteStatement insertPreparedStatement1;

  /** The delete prepared statement 2. */
  private static SQLiteStatement deletePreparedStatement2;

  /** The delete prepared statement 3. */
  private static SQLiteStatement deletePreparedStatement3;

  /** The update prepared statement 4. */
  private static SQLiteStatement updatePreparedStatement4;

  /** The update prepared statement 5. */
  private static SQLiteStatement updatePreparedStatement5;

  /**
   * Instantiates a new dao bean 02 impl.
   *
   * @param context the context
   */
  public DaoBean02Impl(SQLContext context) {
    super(context);
  }

  /**
   * <p>SQL insert:</p>
   * <pre>INSERT INTO bean01 (lista, message_date, message_text, bean_list, value) VALUES (${bean.lista}, ${bean.messageDate}, ${bean.messageText}, ${bean.beanList}, ${bean.value})</pre>
   *
   * <p><code>bean.id</code> is automatically updated because it is the primary key</p>
   *
   * <p><strong>Inserted columns:</strong></p>
   * <dl>
   * 	<dt>lista</dt><dd>is mapped to <strong>${bean.lista}</strong></dd>
   * 	<dt>message_date</dt><dd>is mapped to <strong>${bean.messageDate}</strong></dd>
   * 	<dt>message_text</dt><dd>is mapped to <strong>${bean.messageText}</strong></dd>
   * 	<dt>bean_list</dt><dd>is mapped to <strong>${bean.beanList}</strong></dd>
   * 	<dt>value</dt><dd>is mapped to <strong>${bean.value}</strong></dd>
   * </dl>
   *
   * @param bean
   * 	is mapped to parameter <strong>bean</strong>
   *
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insert(Bean01 bean) {
    if (insertPreparedStatement0==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean01 (lista, message_date, message_text, bean_list, value) VALUES (?, ?, ?, ?, ?)";
      insertPreparedStatement0 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertPreparedStatement0);
    _contentValues.put("lista", Bean01Table.serializeLista(bean.getLista()));
    _contentValues.put("message_date", bean.getMessageDate());
    _contentValues.put("message_text", bean.getMessageText());
    _contentValues.put("bean_list", Bean01Table.serializeBeanList(bean.getBeanList()));
    _contentValues.put("value", bean.getValue());

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean01 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertPreparedStatement0, _contentValues);
    bean.setId(result);

    return result;
  }

  /**
   * <h2>SQL insert</h2>
   * <pre>INSERT INTO bean01 (value, message_date) VALUES (${value}, ${messageDate})</pre>
   * 
   * <h2>Inserted columns:</strong></h2>
   * <dl>
   * 	<dt>value</dt><dd>is binded to query's parameter <strong>${value}</strong> and method's parameter <strong>value</strong></dd>
   * 	<dt>messageDate</dt><dd>is binded to query's parameter <strong>${messageDate}</strong> and method's parameter <strong>messageDate</strong></dd>
   * </dl>.
   *
   * @param value 	is binded to column value <strong>value</strong>
   * @param messageDate 	is binded to column value <strong>message_date</strong>
   * @return <strong>id</strong> of inserted record
   */
  @Override
  public long insert(long value, long messageDate) {
    if (insertPreparedStatement1==null) {
      // generate static SQL for statement
      String _sql="INSERT INTO bean01 (value, message_date) VALUES (?, ?)";
      insertPreparedStatement1 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(insertPreparedStatement1);

    _contentValues.put("value", value);
    _contentValues.put("message_date", messageDate);

    // log section BEGIN
    if (_context.isLogEnabled()) {
      // log for insert -- BEGIN 
      StringBuffer _columnNameBuffer=new StringBuffer();
      StringBuffer _columnValueBuffer=new StringBuffer();
      String _columnSeparator="";
      for (String columnName:_contentValues.keys()) {
        _columnNameBuffer.append(_columnSeparator+columnName);
        _columnValueBuffer.append(_columnSeparator+":"+columnName);
        _columnSeparator=", ";
      }
      Logger.info("INSERT INTO bean01 (%s) VALUES (%s)", _columnNameBuffer.toString(), _columnValueBuffer.toString());

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END
      // log for insert -- END 


      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    // insert operation
    long result = KriptonDatabaseWrapper.insert(insertPreparedStatement1, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete</h2>
   * <pre>DELETE FROM bean01 WHERE id=${id}</pre>
   * 
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${id}</dt><dd>is mapped to method's parameter <strong>id</strong></dd>
   * </dl>.
   *
   * @param id 	is used as where parameter <strong>${id}</strong>
   * @return number of deleted records
   */
  @Override
  public long delete(long id) {
    if (deletePreparedStatement2==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean01 WHERE id=?";
      deletePreparedStatement2 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deletePreparedStatement2);
    _contentValues.addWhereArgs(String.valueOf(id));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean01 WHERE id=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deletePreparedStatement2, _contentValues);
    return result;
  }

  /**
   * <h2>SQL delete:</h2>
   * <pre>DELETE FROM bean01 WHERE id=${bean.id}</pre>
   *
   * <h2>Parameters used in where conditions:</h2>
   * <dl>
   * 	<dt>${bean.id}</dt><dd>is mapped to method's parameter <strong>bean.id</strong></dd>
   * </dl>
   *
   * @param bean
   * 	is used as ${bean}
   *
   * @return number of deleted records
   */
  @Override
  public long delete(Bean01 bean) {
    if (deletePreparedStatement3==null) {
      // generate static SQL for statement
      String _sql="DELETE FROM bean01 WHERE id=?";
      deletePreparedStatement3 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(deletePreparedStatement3);
    _contentValues.addWhereArgs(String.valueOf(bean.getId()));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("DELETE FROM bean01 WHERE id=?");

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(deletePreparedStatement3, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update</h2>
   * <pre>UPDATE bean01 SET value=:value WHERE id>${id}</pre>
   * 
   * <h2>Updated columns:</h2>
   * <ul>
   * 	<li>value</li>
   * </ul>
   * 
   * <h2>Where parameters:</h2>
   * <dl>
   * 	<dt>${id}</dt><dd>is mapped to method's parameter <strong>id</strong></dd>
   * </dl>.
   *
   * @param value 	is used as updated field <strong>value</strong>
   * @param id 	is used as where parameter <strong>${id}</strong>
   * @return number of updated records
   */
  @Override
  public long update(long value, long id) {
    if (updatePreparedStatement4==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean01 SET value=? WHERE id>?";
      updatePreparedStatement4 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updatePreparedStatement4);
    _contentValues.put("value", value);

    _contentValues.addWhereArgs(String.valueOf(id));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean01 SET value=:value WHERE id>?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updatePreparedStatement4, _contentValues);
    return result;
  }

  /**
   * <h2>SQL update:</h2>
   * <pre>UPDATE bean01 SET lista=:lista, message_date=:messageDate, message_text=:messageText, bean_list=:beanList, value=:value WHERE value=${bean.value}</pre>
   *
   * <h2>Updated columns:</h2>
   * <dl>
   * 	<dt>lista</dt><dd>is mapped to <strong>${bean.lista}</strong></dd>
   * 	<dt>message_date</dt><dd>is mapped to <strong>${bean.messageDate}</strong></dd>
   * 	<dt>message_text</dt><dd>is mapped to <strong>${bean.messageText}</strong></dd>
   * 	<dt>bean_list</dt><dd>is mapped to <strong>${bean.beanList}</strong></dd>
   * 	<dt>value</dt><dd>is mapped to <strong>${bean.value}</strong></dd>
   * </dl>
   *
   * <h2>Parameters used in where conditions:</h2>
   * <dl>
   * 	<dt>${bean.value}</dt><dd>is mapped to method's parameter <strong>bean.value</strong></dd>
   * </dl>
   *
   * @param bean
   * 	is used as ${bean}
   *
   * @return number of updated records
   */
  @Override
  public long update(Bean01 bean) {
    if (updatePreparedStatement5==null) {
      // generate static SQL for statement
      String _sql="UPDATE bean01 SET lista=?, message_date=?, message_text=?, bean_list=?, value=? WHERE value=?";
      updatePreparedStatement5 = KriptonDatabaseWrapper.compile(_context, _sql);
    }
    KriptonContentValues _contentValues=contentValuesForUpdate(updatePreparedStatement5);
    _contentValues.put("lista", Bean01Table.serializeLista(bean.getLista()));
    _contentValues.put("message_date", bean.getMessageDate());
    _contentValues.put("message_text", bean.getMessageText());
    _contentValues.put("bean_list", Bean01Table.serializeBeanList(bean.getBeanList()));
    _contentValues.put("value", bean.getValue());

    _contentValues.addWhereArgs(String.valueOf(bean.getValue()));

    // generation CODE_001 -- BEGIN
    // generation CODE_001 -- END
    // log section BEGIN
    if (_context.isLogEnabled()) {

      // display log
      Logger.info("UPDATE bean01 SET lista=:lista, message_date=:message_date, message_text=:message_text, bean_list=:bean_list, value=:value WHERE value=?");

      // log for content values -- BEGIN
      Triple<String, Object, KriptonContentValues.ParamType> _contentValue;
      for (int i = 0; i < _contentValues.size(); i++) {
        _contentValue = _contentValues.get(i);
        if (_contentValue.value1==null) {
          Logger.info("==> :%s = <null>", _contentValue.value0);
        } else {
          Logger.info("==> :%s = '%s' (%s)", _contentValue.value0, StringUtils.checkSize(_contentValue.value1), _contentValue.value1.getClass().getCanonicalName());
        }
      }
      // log for content values -- END

      // log for where parameters -- BEGIN
      int _whereParamCounter=0;
      for (String _whereParamItem: _contentValues.whereArgs()) {
        Logger.info("==> param%s: '%s'",(_whereParamCounter++), StringUtils.checkSize(_whereParamItem));
      }
      // log for where parameters -- END
    }
    // log section END
    int result = KriptonDatabaseWrapper.updateDelete(updatePreparedStatement5, _contentValues);
    return result;
  }

  /**
   * Clear compiled statements.
   */
  public static void clearCompiledStatements() {
    if (insertPreparedStatement0!=null) {
      insertPreparedStatement0.close();
      insertPreparedStatement0=null;
    }
    if (insertPreparedStatement1!=null) {
      insertPreparedStatement1.close();
      insertPreparedStatement1=null;
    }
    if (deletePreparedStatement2!=null) {
      deletePreparedStatement2.close();
      deletePreparedStatement2=null;
    }
    if (deletePreparedStatement3!=null) {
      deletePreparedStatement3.close();
      deletePreparedStatement3=null;
    }
    if (updatePreparedStatement4!=null) {
      updatePreparedStatement4.close();
      updatePreparedStatement4=null;
    }
    if (updatePreparedStatement5!=null) {
      updatePreparedStatement5.close();
      updatePreparedStatement5=null;
    }
  }
}
