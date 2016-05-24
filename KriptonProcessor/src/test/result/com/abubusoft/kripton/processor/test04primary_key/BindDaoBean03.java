package com.abubusoft.kripton.processor.test04primary_key;

import android.database.Cursor;
import com.abubusoft.kripton.android.sqlite.AbstractBindDao;
import java.lang.Override;

/**
 * Generated by Kripton Library.
 *
 *  @since Wed May 25 01:06:01 CEST 2016
 *
 */
public class BindDaoBean03 extends AbstractBindDao implements DaoBean03 {
  /**
   * <p>Select query is:</p>
   * <pre>select id, text from bean03 where id=${id}</pre>
   *
   * <p>Its parameters are:</p>
   *
   * <pre>[id]</pre>
   *
   * <p>Projected column are:</p>
   *
   * <pre>[id, text]</pre>
   *
   * @param id
   *
   * @return selected bean or <code>null</code>.
   */
  @Override
  public Bean03 selectOne(long id) {
    // build where condition
    String[] args={String.valueOf(id)};

    Cursor cursor = database.rawQuery("select id, text from bean03 where id=?", args);

    Bean03 resultBean=null;

    if (cursor.moveToFirst()) {

      int index0=cursor.getColumnIndex("id");
      int index1=cursor.getColumnIndex("text");

      resultBean=new Bean03();

      if (!cursor.isNull(index0)) { resultBean.setId(cursor.getLong(index0)); }
      if (!cursor.isNull(index1)) { resultBean.setText(cursor.getString(index1)); }

    }
    cursor.close();

    return resultBean;
  }

  /**
   * <p>Delete query:</p>
   * <pre>DELETE bean03 WHERE id=${id}</pre>
   *
   * @param id
   * 	used in where condition
   *
   * @return number of deleted records
   */
  @Override
  public long deleteOne(long id) {
    String[] whereConditions={String.valueOf(id)};

    int result = database.delete("bean03", "id=?", whereConditions);
    return result;
  }
}
