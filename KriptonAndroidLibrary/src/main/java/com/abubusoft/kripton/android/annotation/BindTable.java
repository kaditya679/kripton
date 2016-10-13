package com.abubusoft.kripton.android.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BindTable {
	/**
	 * Name of the table, in java style. It will be converted during creation of
	 * table. If null, the name of the table will be transformed class name.
	 * 
	 * @return
	 * 		defined name of the table in java style
	 */
	String value() default "";
	
	boolean allFields() default true;
}
