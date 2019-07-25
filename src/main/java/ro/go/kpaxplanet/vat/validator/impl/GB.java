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
 * UK VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class GB extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {
		
		// Checks the check digits of a UK VAT number.

		int[] multipliers = { 8, 7, 6, 5, 4, 3, 2 };

		// Government departments
		if ("GD".equals(vatNumber.substring(0, 2))) {
			if (Integer.parseInt(vatNumber.substring(2, 3)) < 500)
				return true;
			else
				return false;
		}

		// Health authorities
		if ("HA".equals(vatNumber.substring(0, 2))) {
			if (Integer.parseInt(vatNumber.substring(2, 3)) > 499)
				return true;
			else
				return false;
		}

		// Standard and commercial numbers
		int total = 0;

		// 0 VAT numbers disallowed!
		if (Integer.parseInt(vatNumber.substring(0)) == 0) {
			return false;
		}

		// Check range is OK for modulus 97 calculation
		int no = Integer.parseInt(vatNumber.substring(0, 7));

		// Extract the next digit and multiply by the counter.
		for (int i = 0; i < 7; i++) {
			total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
		}

		// Old numbers use a simple 97 modulus, but new numbers use an
		// adaptation of that (less 55). Our
		// VAT number could use either system, so we check it against both.

		// Establish check digits by subtracting 97 from total until negative.
		int cd = total;
		while (cd > 0) {
			cd = cd - 97;
		}

		// Get the absolute value and compare it with the last two characters of
		// the VAT number. If the
		// same, then it is a valid traditional check digit. However, even then
		// the number must fit within
		// certain specified ranges.
		cd = Math.abs(cd);
		if (cd == Integer.parseInt(vatNumber.substring(7, 9)) && no < 9990001 && (no < 100000 || no > 999999)
				&& (no < 9490001 || no > 9700000))
			return true;

		// Now try the new method by subtracting 55 from the check digit if we
		// can - else add 42
		if (cd >= 55) {
			cd = cd - 55;
		} else {
			cd = cd + 42;
		}
		return cd == Integer.parseInt(vatNumber.substring(7, 9)) && no > 1000000;
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{9})$", "^(\\d{12})$", "^(GD\\d{3})$", "^(HA\\d{3})$"};
	}

}
