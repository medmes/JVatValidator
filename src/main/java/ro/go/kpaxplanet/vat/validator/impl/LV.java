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

import java.util.regex.Pattern;

/**
 * Latvia VAT number validator.
 * @author eugen
 *
 */
public class LV extends AbstractVatFormalValidator {
	private static Pattern TYPE_ONE_PATTERN = Pattern.compile("^[0-3]");
	
	private static Pattern TYPE_TWO_PATTERN = Pattern.compile("^[0-3][0-9][0-1][0-9]");

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a Latvian VAT number.

		// Differentiate between legal entities and natural bodies. For the
		// latter we simply check that
		// the first six digits correspond to valid DDMMYY dates.
		if (TYPE_ONE_PATTERN.matcher(vatNumber).find()) {
			return TYPE_TWO_PATTERN.matcher(vatNumber).find();
		} else {

			int total = 0;
			int[] multipliers = { 9, 1, 4, 8, 3, 10, 2, 5, 7, 6 };

			// Extract the next digit and multiply by the counter.
			for (int i = 0; i < 10; i++) {
				total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
			}
			// Establish check digits by getting modulus 11.
			if (total % 11 == 4 && Integer.parseInt(vatNumber.substring(0, 1)) == 9)
				total = total - 45;
			if (total % 11 == 4)
				total = 4 - total % 11;
			else if (total % 11 > 4)
				total = 14 - total % 11;
			else if (total % 11 < 4)
				total = 3 - total % 11;

			// Compare it with the last character of the VAT number. If it's the
			// same, then it's valid.
			return total == Integer.parseInt(vatNumber.substring(10, 11));
		}

	}

	@Override
	public String[] getRegexArray() {
		return new String[] { "^\\d{11}$" };
	}

}
