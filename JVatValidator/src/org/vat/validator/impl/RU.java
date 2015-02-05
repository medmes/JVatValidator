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
 * Russian VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class RU extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {
		// Checks the check digits of a Russian INN number
		// See http://russianpartner.biz/test_inn.html for algorithm

		// 10 digit INN numbers
		if (vatNumber.length() == 10) {
			int total = 0;
			int[] multipliers = { 2, 4, 10, 3, 5, 9, 4, 6, 8, 0 };
			for (int i = 0; i < 10; i++) {
				total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
			}
			total = total % 11;
			if (total > 9) {
				total = total % 10;
			}

			// Compare it with the last character of the VAT number. If it is
			// the same, then it's valid
			return total == Integer.parseInt(vatNumber.substring(9, 10));

			// 12 digit INN numbers
		} else if (vatNumber.length() == 12) {
			int total1 = 0;
			int[] multipliers1 = { 7, 2, 4, 10, 3, 5, 9, 4, 6, 8, 0 };
			int total2 = 0;
			int[] multipliers2 = { 3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8, 0 };

			for (int i = 0; i < 11; i++)
				total1 += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers1[i];
			total1 = total1 % 11;
			if (total1 > 9) {
				total1 = total1 % 10;
			}

			for (int i = 0; i < 11; i++)
				total2 += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers2[i];
			total2 = total2 % 11;
			if (total2 > 9) {
				total2 = total2 % 10;
			}

			// Compare the first check with the 11th character and the second
			// check with the 12th and last
			// character of the VAT number. If they're both the same, then it's
			// valid
			return (total1 == Integer.parseInt(vatNumber.substring(10, 11)))
					&& (total2 == Integer.parseInt(vatNumber.substring(11, 12)));
		}
		return false;
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{10}|\\d{12})$"};
	}

}
