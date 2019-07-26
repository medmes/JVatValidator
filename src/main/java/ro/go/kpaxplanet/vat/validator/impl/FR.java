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
 * French VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class FR extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a French VAT number.

		if (!vatNumber.matches("^\\d{11}$"))
			return true;

		// Extract the last nine digits as an integer.
		long total = Long.parseLong(vatNumber.substring(2));

		// Establish check digit.
		total = (total * 100L + 12L) % 97;

		// Compare it with the last character of the VAT number. If it's the
		// same, then it's valid.
		return total == Integer.parseInt(vatNumber.substring(0, 2));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{14})$","^(\\d{11})$", "^([(A-H)|(J-N)|(P-Z)]\\d{10})$", "^(\\d[(A-H)|(J-N)|(P-Z)]\\d{9})$", "^([(A-H)|(J-N)|(P-Z)]{2}\\d{9})$"};
	}

}
