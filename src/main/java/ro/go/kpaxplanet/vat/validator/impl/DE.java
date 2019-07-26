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
		int sum;
		for (int i = 0; i < 8; i++) {

			// Extract the next digit and implement peculiar algorithm!.
			sum = (Integer.parseInt(vatNumber.substring(i, i + 1)) + product) % 10;
			if (sum == 0) {
				sum = 10;
			}
			product = (2 * sum) % 11;
		}

		int checkdigit;
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
