/**
 *  Copyright 2016-2018 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.antheminc.oss.nimbus.domain.defn;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;

import com.antheminc.oss.nimbus.domain.defn.Executions.Configs;
 
/**
 * @author Soham Chakravarti
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
@Inherited
public @interface Execution {

	/**
	 * Only the first execution config would have access to supplied payload.
	 *  
	 * @author Soham Chakravarti
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.FIELD})
	@Repeatable(Configs.class)
	@Execution
	public @interface Config {
		
		public static String TRUE = "true";
		public static String COL = StringUtils.EMPTY;
		
		String when() default TRUE;
		
		String url();
		
		String col() default COL;
		
		KeyValue[] kv() default {};
	}
	
	public @interface KeyValue {
		
		String k();
		String v();
	}

}
