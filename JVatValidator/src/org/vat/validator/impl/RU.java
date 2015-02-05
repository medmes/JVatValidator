/*******************************************************************************
 * Copyright 2015 Eugen Covaci
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
