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
 * Maltese VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class MT extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a Maltese VAT number.

		int total = 0;
		int[] multipliers = { 3, 4, 6, 7, 8, 9 };

		// Extract the next digit and multiply by the counter.
		for (int i = 0; i < 6; i++)
			total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];

		// Establish check digits by getting modulus 37.
		total = 37 - total % 37;

		// Compare it with the last two digits of the VAT number. If it's the
		// same, then it's valid.
		return total == Integer.parseInt(vatNumber.substring(6, 8));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^([1-9]\\d{7})$"};
	}

}
