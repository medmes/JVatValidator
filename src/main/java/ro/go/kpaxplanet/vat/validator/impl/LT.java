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
 * Lithuanian VAT number validator.
 *
 * @author eugen covaci
 *
 */
public class LT extends AbstractVatFormalValidator  {
	private static final Pattern TYPE_ONE_PATTERN = Pattern.compile("^\\d{7}1");
	private static final Pattern TYPE_TWO_PATTERN = Pattern.compile("^\\d{10}1");

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a Lithuanian VAT number.

		// 9 character VAT numbers are for legal persons
		if (vatNumber.length() == 9) {

			// 8th character must be one
			if (!TYPE_ONE_PATTERN.matcher(vatNumber).find())
				return false;

			// Extract the next digit and multiply by the counter+1.
			int total = 0;
			for (int i = 0; i < 8; i++)
				total += Integer.parseInt(vatNumber.substring(i, i + 1)) * (i + 1);

			// Can have a double check digit calculation!
			if (total % 11 == 10) {
				int[] multipliers = { 3, 4, 5, 6, 7, 8, 9, 1 };
				total = 0;
				for (int i = 0; i < 8; i++)
					total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
			}

			// Establish check digit.
			total = total % 11;
			if (total == 10) {
				total = 0;
			}

            // Compare it with the last character of the VAT number. If it's the
            // same, then it's valid.
            return total == Integer.parseInt(vatNumber.substring(8, 9));
        }

		// 12 character VAT numbers are for temporarily registered taxpayers
		else {

			// 11th character must be one
			if (!TYPE_TWO_PATTERN.matcher(vatNumber).find())
				return false;

			// Extract the next digit and multiply by the counter+1.
			int total = 0;
			int[] multipliers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2 };
			for (int i = 0; i < 11; i++)
				total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];

			// Can have a double check digit calculation!
			if (total % 11 == 10) {
				multipliers = new int[] { 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4 };
				total = 0;
				for (int i = 0; i < 11; i++)
					total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
			}

			// Establish check digit.
			total = total % 11;
			if (total == 10) {
				total = 0;
			}

			// Compare it with the last character of the VAT number. If it's the
			// same, then it's valid.
			return total == Integer.parseInt(vatNumber.substring(11, 12));
		}
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{9}|\\d{12})$"};
	}

}
