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
 * Romanian VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class RO extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {
		// Checks the check digits of a Romanian VAT number.

		int[] multipliers = { 7, 5, 3, 2, 1, 7, 5, 3, 2 };

		int initialLength = vatNumber.length();
		
		for (int i = 0; i < 10 - initialLength; i++) {
			vatNumber = "0" + vatNumber;
		}
		
		int total = 0;
		for (int i = 0; i < vatNumber.length() - 1; i++) {
			total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
		}

		// Establish check digits by getting modulus 11.
		total = (10 * total) % 11;
		if (total == 10)
			total = 0;

		// Compare it with the last character of the VAT number. If it's the
		// same, then it's valid.
		return total == Integer.parseInt(vatNumber.substring(vatNumber.length() - 1));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^([1-9]\\d{1,9})$"};
	}

}
