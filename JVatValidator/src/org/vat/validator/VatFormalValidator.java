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
public interface VatFormalValidator {
	
	/**
	 * Formal validate a vat number.
	 * @param vatNumber The vat number to be validated.
	 * @return <code>true</code> if <code>vatNumber</code> is valid.
	 */
	boolean validate (String vatNumber);
}
