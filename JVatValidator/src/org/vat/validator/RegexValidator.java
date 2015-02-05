/*******************************************************************************
 * Copyright 2015 Eugen Covaci
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.vat.validator;

/**
 * 
 * @author Eugen Covaci
 *
 */
public interface RegexValidator {
	
	/**
	 * The regex array to match against.
	 * @return The regex array
	 */
	public abstract String[] getRegexArray();
	
	/**
	 * Regex validate <code>value</code> argument against the array of patterns.
	 * @param value The value to be validated.
	 * @return <code>true</code> if and only if valid when matches at least one pattern of
	 * the array of patterns returned by {@link #getRegexArray()} method.
	 */
	public abstract boolean validateRegex(String value);

}
