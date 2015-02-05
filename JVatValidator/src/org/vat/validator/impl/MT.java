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
 * Maltese VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class MT extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a Maltese VAT number.

		int total = 0;
		int[] multipliers = { 3, 4, 6, 7, 8, 9 };

		// Extract the next digit and multiply by the counter.
		for (int i = 0; i < 6; i++)
			total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];

		// Establish check digits by getting modulus 37.
		total = 37 - total % 37;

		// Compare it with the last two digits of the VAT number. If it's the
		// same, then it's valid.
		return total == Integer.parseInt(vatNumber.substring(6, 8));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^([1-9]\\d{7})$"};
	}

}
