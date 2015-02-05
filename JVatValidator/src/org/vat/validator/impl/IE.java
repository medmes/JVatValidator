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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Irish VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class IE extends AbstractVatFormalValidator  {
	private static Pattern TYPE_ONE_PATTERN = Pattern.compile("^\\d[A-Z\\*\\+]");
	
	@Override
	public boolean validateDigits(String vatNumber) {
		
		// Checks the check digits of an Irish VAT number.

		int total = 0;
		int[] multipliers = { 8, 7, 6, 5, 4, 3, 2 };

		// If the code is type 1 format, we need to convert it to the new before
		// performing the validation.
		if (TYPE_ONE_PATTERN.matcher(vatNumber).find()) {
			vatNumber = "0" + vatNumber.substring(2, 7) + vatNumber.substring(0, 1) + vatNumber.substring(7, 8);
		}

		System.out.println("New format vatNumber " + vatNumber);
		
		// Extract the next digit and multiply by the counter.
		for (int i = 0; i < 7; i++) {
			total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
		}
		// If the number is type 3 then we need to include the trailing A or H
		// in the calculation
		if (vatNumber.matches("^\\d{7}[A-Z][AH]$")) {

			// Add in a multiplier for the character A (1*9=9) or H (8*9=72)
			if (vatNumber.charAt(8) == 'H') {
				total += 72;
			} else {
				total += 9;
			}
		}

		// Establish check digit using modulus 23, and translate to char.
		// equivalent.
		total = total % 23;
		char totalChar;
		if (total == 0) {
			totalChar = 'W';
		} else {
			totalChar = (char) (total + 64);
		}
		
		// Compare it with the eighth character of the VAT number. If it's the
		// same, then it's valid.
		return totalChar == vatNumber.charAt(7);
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{7}[A-W])$", "^([7-9][A-Z\\*\\+)]\\d{5}[A-W])$", "^(\\d{7}[A-W][AH])$"};
	}

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^\\d[A-Z\\*\\+]");
		Matcher m = pattern.matcher("8Z49289F");
		System.out.println(m.find());
	}
}
