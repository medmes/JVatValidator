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
 * Croatian VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class HR extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a Croatian VAT number using ISO 7064, MOD
		// 11-10 for check digit.

		int product = 10;
		int sum = 0;

		for (int i = 0; i < 10; i++) {

			// Extract the next digit and implement the algorithm
			sum = (Integer.parseInt(vatNumber.substring(i, i + 1)) + product) % 10;
			if (sum == 0) {
				sum = 10;
			}
			product = (2 * sum) % 11;
		}

		// Now check that we have the right check digit
		return (product + Integer.parseInt(vatNumber.substring(10, 11)) * 1) % 10 == 1;
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{11})$"};
	}

}
