/*******************************************************************************
 * Copyright 2015, 2017 Francesco Benincasa (info@abubusoft.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package sqlite.feature.indexes;

import java.util.Date;
import java.util.List;

import com.abubusoft.kripton.android.annotation.BindDao;
import com.abubusoft.kripton.android.annotation.BindSqlInsert;
import com.abubusoft.kripton.android.annotation.BindSqlDynamicOrderBy;
import com.abubusoft.kripton.android.annotation.BindSqlParam;
import com.abubusoft.kripton.android.annotation.BindSqlSelect;
import com.abubusoft.kripton.android.sqlite.OnReadBeanListener;
import com.abubusoft.kripton.android.annotation.BindSqlDynamicWhere;

// TODO: Auto-generated Javadoc
/**
 * The Interface Err1PersonDAO.
 */
@BindDao(Err1Person.class)
public interface Err1PersonDAO {
	
	/**
	 * Insert one.
	 *
	 * @param name the name
	 * @param surname the surname
	 * @param birthCity the birth city
	 * @param birthDay the birth day
	 */
	@BindSqlInsert
	void insertOne(String name, String surname, String birthCity, Date birthDay);

	/**
	 * Select all.
	 *
	 * @return the list
	 */
	@BindSqlSelect(orderBy="name")
	List<Err1Person> selectAll();
	
	/**
	 * Select one.
	 *
	 * @param nameValue the name value
	 * @param where the where
	 * @param orderBy the order by
	 * @return the list
	 */
	@BindSqlSelect(where="name like ${nameTemp} || '%'")
	List<Err1Person> selectOne(@BindSqlParam("nameTemp") String nameValue, @BindSqlDynamicWhere String where, @BindSqlDynamicOrderBy String orderBy);
	
	/**
	 * Select bean listener.
	 *
	 * @param beanListener the bean listener
	 * @param orderBy the order by
	 */
	@BindSqlSelect(orderBy="name")
	void selectBeanListener(OnReadBeanListener<Err1Person> beanListener, @BindSqlDynamicOrderBy String orderBy);
	
//	@BindSqlSelect(orderBy="typeName")
//	void selectCursorListener(OnReadCursorListener cursorListener);
}