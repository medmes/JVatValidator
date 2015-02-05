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
