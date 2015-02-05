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
 * Belgium VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class BE extends AbstractVatFormalValidator {

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a Belgium VAT number.

		// Nine digit numbers have a 0 inserted at the front.
		if (vatNumber.length() == 9)
			vatNumber = "0" + vatNumber;

		if (Integer.parseInt(vatNumber.substring(1, 2)) == 0) {
			return false;
		}
		// Modulus 97 check on last nine digits
		return (97 - Integer.parseInt(vatNumber.substring(0, 8)) % 97) == Integer.parseInt(vatNumber.substring(8, 10));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(0?\\d{9})$"};
	}

}
