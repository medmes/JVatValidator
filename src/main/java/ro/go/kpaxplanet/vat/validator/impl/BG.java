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
package ro.go.kpaxplanet.vat.validator.impl;


/**
 * Bulgarian VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class BG extends AbstractVatFormalValidator {

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a Bulgarian VAT number.

		if (vatNumber.length() == 9) {

			// Check the check digit of 9 digit Bulgarian VAT numbers.

			// First try to calculate the check digit using the first
			// multipliers
			int temp = 0;
			for (int i = 0; i < 8; i++) {
				temp += Integer.parseInt(vatNumber.substring(i, i + 1)) * (i + 1);
			}

			// See if we have a check digit yet
			int total = temp % 11;
			if (total != 10) {
				return total == Integer.parseInt(vatNumber.substring(8));
			}

			// We got a modulus of 10 before so we have to keep going. Calculate
			// the new check digit using
			// the different multipliers
			temp = 0;
			for (int i = 0; i < 8; i++) {
				temp += Integer.parseInt(vatNumber.substring(i, i + 1)) * (i + 3);
			}

			// See if we have a check digit yet. If we still have a modulus of
			// 10, set it to 0.
			total = temp % 11;
			if (total == 10) {
				total = 0;
			}

			return total == Integer.parseInt(vatNumber.substring(8));
		}

		// 10 digit VAT code - see if it relates to a standard physical person
		if (vatNumber.matches("^\\d\\d[0-5]\\d[0-3]\\d\\d{4}$")) {
			// Check month
			int month = Integer.parseInt(vatNumber.substring(2, 4));
			if ((month > 0 && month < 13) || (month > 20 & month < 33)) {

				// Extract the next digit and multiply by the counter.
				int[] multipliers = { 2, 4, 8, 5, 10, 9, 7, 3, 6 };
				int total = 0;
				for (int i = 0; i < 9; i++) {
					total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
				}

				// Establish check digit.
				total = total % 11;
				if (total == 10) {
					total = 0;
				}
				// Check to see if the check digit given is correct, If not, try
				// next type of person
				if (total == Integer.parseInt(vatNumber.substring(9, 10))) {
					return true;
				}
			}
		}

		// It doesn't relate to a standard physical person - see if it relates
		// to a foreigner.

		// Extract the next digit and multiply by the counter.
		int[] multipliers = { 21, 19, 17, 13, 11, 9, 7, 3, 1 };
		int total = 0;
		for (int i = 0; i < 9; i++) {
			total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
		}

		// Check to see if the check digit given is correct, If not, try next
		// type of person
		if (total % 10 == Integer.parseInt(vatNumber.substring(9, 10))) {
			return true;
		}
		// Finally, if not yet identified, see if it conforms to a miscellaneous
		// VAT number

		// Extract the next digit and multiply by the counter.
		multipliers = new int[] { 4, 3, 2, 7, 6, 5, 4, 3, 2 };
		total = 0;
		for (int i = 0; i < 9; i++) {
			total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
		}
		// Establish check digit.
		total = 11 - total % 11;
		if (total == 10) {
			return false;
		}
		if (total == 11) {
			total = 0;
		}
		// Check to see if the check digit given is correct, If not, we have an
		// error with the VAT number
		return total == Integer.parseInt(vatNumber.substring(9, 10));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{9,10})$"};
	}

}
