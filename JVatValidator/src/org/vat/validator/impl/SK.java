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
package org.vat.validator.impl;


/**
 * Slovakian VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class SK extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {
		// Checks the check digits of a Slovakian VAT number.

		// Check that the modulus of the whole VAT number is 0 - else error
		return Long.parseLong(vatNumber) % 11 == 0;
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^([1-9]\\d[(2-4)|(6-9)]\\d{7})$"};
	}

}
