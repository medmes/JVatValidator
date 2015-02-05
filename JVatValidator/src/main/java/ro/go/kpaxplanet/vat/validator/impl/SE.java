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
 * 
 * @author eugen covaci
 * 
 */
public class SE extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {
		// Calculate R where R = R1 + R3 + R5 + R7 + R9, and Ri = INT(Ci/5) +
		// (Ci*2) modulo 10
		int R = 0;
		int digit;
		for (int i = 0; i < 9; i = i + 2) {
			digit = Integer.parseInt(vatNumber.substring(i, i + 1));
			R += digit / 5 + ((digit * 2) % 10);
		}

		// Calculate S where S = C2 + C4 + C6 + C8
		int S = 0;
		for (int i = 1; i < 9; i = i + 2)
			S += Integer.parseInt(vatNumber.substring(i, i + 1));

		// Calculate the Check Digit
		int cd = (10 - (R + S) % 10) % 10;

		// Compare it with the last character of the VAT number. If it's the
		// same, then it's valid.
		return cd == Integer.parseInt(vatNumber.substring(9, 10));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{10}01)$"};
	}

}
