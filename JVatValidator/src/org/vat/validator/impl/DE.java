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
 * German VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class DE extends AbstractVatFormalValidator {

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a German VAT number.

		int product = 10;
		int sum = 0;
		int checkdigit = 0;
		for (int i = 0; i < 8; i++) {

			// Extract the next digit and implement peculiar algorithm!.
			sum = (Integer.parseInt(vatNumber.substring(i, i + 1)) + product) % 10;
			if (sum == 0) {
				sum = 10;
			}
			product = (2 * sum) % 11;
		}

		// Establish check digit.
		if (11 - product == 10) {
			checkdigit = 0;
		} else {
			checkdigit = 11 - product;
		}

		// Compare it with the last two characters of the VAT number. If the
		// same, then it is a valid
		// check digit.
		return checkdigit == Integer.parseInt(vatNumber.substring(8, 9));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^([1-9]\\d{8})$"};
	}

}
