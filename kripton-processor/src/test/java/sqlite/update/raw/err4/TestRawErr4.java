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
package sqlite.update.raw.err4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.abubusoft.kripton.processor.exceptions.UnknownPropertyInJQLException;

import sqlite.AbstractBindSQLiteProcessorTest;

/**
 * The Class TestAdapter01.
 */
@RunWith(JUnit4.class)
public class TestRawErr4 extends AbstractBindSQLiteProcessorTest {

	/**
	 * No @BindType is put in bean definition.
	 *
	 * @throws Throwable the throwable
	 */
	@Test
	public void test01() throws Throwable {
		this.expectedException(UnknownPropertyInJQLException.class);
		buildDataSourceProcessorTest(Example01DataSource.class, PersonDAO.class, Person.class, DateAdapter.class);
	}

}
