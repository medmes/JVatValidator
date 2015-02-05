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
 * Danish VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class DK extends AbstractVatFormalValidator {

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a Danish VAT number.

		int total = 0;
		int[] multipliers = { 2, 7, 6, 5, 4, 3, 2, 1 };

		// Extract the next digit and multiply by the counter.
		for (int i = 0; i < 8; i++) {
			total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
		}
		// Establish check digit.
		total = total % 11;

		// The remainder should be 0 for it to be valid..
		return total == 0;
	}

	@Override
	public String[] getRegexArray() {
		return  new String[]{"^(\\d{8})$"};
	}

}
