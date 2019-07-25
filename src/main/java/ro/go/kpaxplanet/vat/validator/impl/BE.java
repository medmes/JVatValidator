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
 * Belgium VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class BE extends AbstractVatFormalValidator {

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a Belgium VAT number.

		// Nine digit numbers have a 0 inserted at the front.
		if (vatNumber.length() == 9)
			vatNumber = "0" + vatNumber;

		if (Integer.parseInt(vatNumber.substring(1, 2)) == 0) {
			return false;
		}
		// Modulus 97 check on last nine digits
		return (97 - Integer.parseInt(vatNumber.substring(0, 8)) % 97) == Integer.parseInt(vatNumber.substring(8, 10));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(0?\\d{9})$"};
	}

}
