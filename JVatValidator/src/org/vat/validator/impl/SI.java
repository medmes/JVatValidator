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
 * Slovenian VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class SI extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a Slovenian VAT number.

		int total = 0;
		int[] multipliers = { 8, 7, 6, 5, 4, 3, 2 };

		// Extract the next digit and multiply by the counter.
		for (int i = 0; i < 7; i++) {
			total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
		}
		// Establish check digits using modulus 11
		total = 11 - total % 11;
		if (total == 10) {
			total = 0;
		}

		// Compare the number with the last character of the VAT number. If it
		// is the
		// same, then it's a valid check digit.
		return total != 11 && total == Integer.parseInt(vatNumber.substring(7, 8));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^([1-9]\\d{7})$"};
	}

}
