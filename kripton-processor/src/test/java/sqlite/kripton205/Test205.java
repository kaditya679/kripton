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
package sqlite.kripton205;

import java.io.IOException;

import org.junit.Test;

import com.abubusoft.kripton.processor.exceptions.SQLPrimaryKeyNotFoundException;

import sqlite.AbstractBindSQLiteProcessorTest;

// TODO: Auto-generated Javadoc
/**
 * The Class Test205.
 *
 * @author xcesco
 */
public class Test205 extends AbstractBindSQLiteProcessorTest {

	/**
	 * Test compile.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	@Test
	public void testCompile() throws IOException, InstantiationException, IllegalAccessException {
		this.expectedException(SQLPrimaryKeyNotFoundException.class);
		buildDataSourceProcessorTest(Bean96DataSource.class, Bean205Dao.class, Bean205.class);
	}

}
