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
 * Cypriot VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class CY extends AbstractVatFormalValidator {

	@Override
	public boolean validateDigits(String vatNumber) {
		// Checks the check digits of a Cypriot VAT number.

		// Not allowed to start with '12'
		if (Integer.parseInt(vatNumber.substring(0, 2)) == 12) {
			return false;
		}
		// Extract the next digit and multiply by the counter.
		int total = 0;
		int temp;
		for (int i = 0; i < 8; i++) {
			temp = Integer.parseInt(vatNumber.substring(i, i + 1));
			if (i % 2 == 0) {
				switch (temp) {
				case 0:
					temp = 1;
					break;
				case 1:
					temp = 0;
					break;
				case 2:
					temp = 5;
					break;
				case 3:
					temp = 7;
					break;
				case 4:
					temp = 9;
					break;
				default:
					temp = temp * 2 + 3;
				}
			}
			total += temp;
		}

		// Establish check digit using modulus 26, and translate to char.
		// equivalent.
		total = total % 26;

		// Check to see if the check digit given is correct
		return (char) (total + 65) == vatNumber.charAt(8);
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^([0-5|9]\\d{7}[A-Z])$"};
	}

}
