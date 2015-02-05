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
 * Estonian VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class EE extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of an Estonian VAT number.

		int total = 0;
		int[] multipliers = { 3, 7, 1, 3, 7, 1, 3, 7 };

		// Extract the next digit and multiply by the counter.
		for (int i = 0; i < 8; i++) {
			total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
		}
		
		// Establish check digits using modulus 10.
		total = 10 - total % 10;
		if (total == 10)
			total = 0;

		// Compare it with the last digit of the VAT number. If it's the
		// same, then it's valid.
		return total == Integer.parseInt(vatNumber.substring(8, 9));
	}

	@Override
	public String[] getRegexArray() {
		return  new String[]{"^(10\\d{7})$"};
	}

}
