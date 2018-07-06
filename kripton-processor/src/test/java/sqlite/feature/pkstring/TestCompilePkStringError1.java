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
package sqlite.feature.pkstring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.abubusoft.kripton.processor.exceptions.InvalidMethodSignException;
import com.abubusoft.kripton.processor.exceptions.SQLPrimaryKeyNotValidTypeException;

import sqlite.AbstractBindSQLiteProcessorTest;
import sqlite.feature.pkstring.err1.Album;
import sqlite.feature.pkstring.err1.AppDataSource;
import sqlite.feature.pkstring.err1.DaoAlbum;
import sqlite.feature.pkstring.err1.DaoBase;


/**
 * The Class TestCompileRX.
 */
@RunWith(JUnit4.class)
public class TestCompilePkStringError1 extends AbstractBindSQLiteProcessorTest {

	/**
	 * Test compile.
	 *
	 * @throws Throwable the throwable
	 */
	@Test
	public void testCompile() throws Throwable {
		this.expectedException(SQLPrimaryKeyNotValidTypeException.class, "Bean 'sqlite.feature.pkstring.err1.Album' have name as primary key but it is not Long or long type field");
		buildDataSourceProcessorTest(Album.class, DaoAlbum.class, DaoBase.class, AppDataSource.class);
	}

}
