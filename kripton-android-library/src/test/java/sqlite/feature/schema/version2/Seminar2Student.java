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
/**
 * 
 */
package sqlite.feature.schema.version2;

import com.abubusoft.kripton.android.annotation.BindColumn;
import com.abubusoft.kripton.android.annotation.BindTable;
import com.abubusoft.kripton.annotation.BindType;

// TODO: Auto-generated Javadoc
/**
 * The Class Seminar2Student.
 *
 * @author Francesco Benincasa (info@abubusoft.com)
 */
@BindType
@BindTable(name="seminar_2_student", uniqueIndexes={"studentId asc, seminarId desc"})
public class Seminar2Student  {

	/** The id. */
	public long id;
	
	/** The student id. */
	@BindColumn(foreignKey=Student.class)
	public long studentId;
	
	/** The seminar id. */
	@BindColumn(foreignKey=Seminar.class)
	public long seminarId;
}
