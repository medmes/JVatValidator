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
 * Dutch VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class NL extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {
		// Checks the check digits of a Dutch VAT number.

		int total = 0;
		int[] multipliers = { 9, 8, 7, 6, 5, 4, 3, 2 };

		// Extract the next digit and multiply by the counter.
		for (int i = 0; i < 8; i++)
			total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];

		// Establish check digits by getting modulus 11.
		total = total % 11;
		if (total > 9) {
			total = 0;
		}

		// Compare it with the last character of the VAT number. If it's the
		// same, then it's valid.
		return total == Integer.parseInt(vatNumber.substring(8, 9));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{9})B\\d{2}$"};
	}

}
