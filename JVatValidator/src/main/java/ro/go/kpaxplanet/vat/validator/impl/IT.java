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
 * Italian VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class IT extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of an Italian VAT number.

		int total = 0;
		int[] multipliers = { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2 };
		int temp;

		// The last three digits are the issuing office, and cannot exceed more
		// 201, unless 999 or 888
		if (Integer.parseInt(vatNumber.substring(0, 7)) == 0) {
			return false;
		}
		temp = Integer.parseInt(vatNumber.substring(7, 10));
		if ((temp < 1) || (temp > 201) && temp != 999 && temp != 888)
			return false;

		// Extract the next digit and multiply by the appropriate
		for (int i = 0; i < 10; i++) {
			temp = Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
			if (temp > 9)
				total += (temp / 10) + temp % 10;
			else
				total += temp;
		}

		// Establish check digit.
		total = 10 - total % 10;
		if (total > 9) {
			total = 0;
		}

		// Compare it with the last character of the VAT number. If it's the
		// same, then it's valid.
		return total == Integer.parseInt(vatNumber.substring(10, 11));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{11})$"};
	}

}
