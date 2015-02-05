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
 * Romanian VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class RO extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {
		// Checks the check digits of a Romanian VAT number.

		int[] multipliers = { 7, 5, 3, 2, 1, 7, 5, 3, 2 };

		int initialLength = vatNumber.length();
		
		for (int i = 0; i < 10 - initialLength; i++) {
			vatNumber = "0" + vatNumber;
		}
		
		int total = 0;
		for (int i = 0; i < vatNumber.length() - 1; i++) {
			total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
		}

		// Establish check digits by getting modulus 11.
		total = (10 * total) % 11;
		if (total == 10)
			total = 0;

		// Compare it with the last character of the VAT number. If it's the
		// same, then it's valid.
		return total == Integer.parseInt(vatNumber.substring(vatNumber.length() - 1, vatNumber.length()));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^([1-9]\\d{1,9})$"};
	}

}
