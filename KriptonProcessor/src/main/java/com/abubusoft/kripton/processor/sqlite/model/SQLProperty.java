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
package com.abubusoft.kripton.processor.sqlite.model;

import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

import org.apache.commons.lang3.StringUtils;

import com.abubusoft.kripton.android.ColumnType;
import com.abubusoft.kripton.android.annotation.BindSqlAdapter;
import com.abubusoft.kripton.android.sqlite.NoForeignKey;
import com.abubusoft.kripton.processor.BaseProcessor;
import com.abubusoft.kripton.processor.core.AnnotationAttributeType;
import com.abubusoft.kripton.processor.core.ManagedModelProperty;
import com.abubusoft.kripton.processor.core.ModelAnnotation;
import com.abubusoft.kripton.processor.core.reflect.TypeUtility;
import com.abubusoft.kripton.processor.exceptions.IncompatibleAnnotationException;
import com.abubusoft.kripton.processor.sqlite.transform.SQLTransform;
import com.abubusoft.kripton.processor.sqlite.transform.SQLTransformer;

public class SQLProperty extends ManagedModelProperty {

	public SQLProperty(SQLEntity entity, Element element, List<ModelAnnotation> modelAnnotations) {
		super(entity, element, modelAnnotations);
			
		// @BindAdapter		
		ModelAnnotation annotationBindAdapter = this.getAnnotation(BindSqlAdapter.class);
		if (annotationBindAdapter != null) {
			typeAdapter.adapterClazz = annotationBindAdapter.getAttributeAsClassName(AnnotationAttributeType.ADAPTER);
			typeAdapter.dataType = annotationBindAdapter.getAttributeAsClassName(AnnotationAttributeType.DATA_TYPE);
			
			TypeElement a = BaseProcessor.elementUtils.getTypeElement(typeAdapter.adapterClazz);
			for (Element i:BaseProcessor.elementUtils.getAllMembers(a)) {
				if (i.getKind()==ElementKind.METHOD &&  "toData".equals(i.getSimpleName())) {
					ExecutableElement  method=(ExecutableElement)i;
					typeAdapter.dataType=TypeUtility.typeName(method.getReturnType()).toString();					
				}
			}

			SQLTransform transform=SQLTransformer.lookup(TypeUtility.typeName(typeAdapter.dataType));
			
			if (!transform.isTypeAdapterAware()) {
				String msg = String.format("In class '%s', property '%s' is of type '%s' and it can not be annotated with @%s", element.asType().toString(),
						getName(), getPropertyType().getTypeName(), BindSqlAdapter.class.getSimpleName());
				throw (new IncompatibleAnnotationException(msg));
			}
		}

	}
	
	/**
	 * typeName of the column
	 */
	public String columnName;

	protected boolean nullable;
		
	
	/**
	 * @param primaryKey the primaryKey to set
	 */
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;		
	}

	/**
	 * @return the nullable
	 */
	public boolean isNullable() {
		return nullable;
	}

	/**
	 * @param nullable the nullable to set
	 */
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	/**
	 * @return the primaryKey
	 */
	public boolean isPrimaryKey() {
		return primaryKey;
	}

	protected boolean primaryKey;
	
	/**
	 * type of column
	 */
	public ColumnType columnType;

	/**
	 * class name of referred table
	 */
	public String foreignClassName;


	public boolean hasForeignKeyClassName() {
		return !StringUtils.isEmpty(foreignClassName) && !NoForeignKey.class.getName().equals(foreignClassName);		
	}


}
