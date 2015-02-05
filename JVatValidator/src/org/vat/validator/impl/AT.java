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
 * Austrian VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class AT extends AbstractVatFormalValidator {

	@Override
	public boolean validateDigits(String vatNumber) {
		// Checks the check digits of an Austrian VAT number.
		int total = 0;
		int[] multipliers = { 1, 2, 1, 2, 1, 2, 1 };
		int temp;

		// Extract the next digit and multiply by the appropriate multiplier.
		for (int i = 0; i < 7; i++) {
			temp = Integer.parseInt(vatNumber.substring(i + 1, i + 2)) * multipliers[i];
			if (temp > 9) {
				total += (temp / 10) + temp % 10;
			} else {
				total += temp;
			}
		}

		// Establish check digit.
		total = 10 - (total + 4) % 10;
		if (total == 10) {
			total = 0;
		}
		// Compare it with the last character of the VAT number. If it's the
		// same, then it's valid.
		return total == Integer.parseInt(vatNumber.substring(8, 9));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^U(\\d{8})$"};
	}

}
