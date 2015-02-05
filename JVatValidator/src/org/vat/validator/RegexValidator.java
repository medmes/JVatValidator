/*******************************************************************************
 * Copyright (c) 2014 Eugen Covaci.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Eugen Covaci - initial API and implementation
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
