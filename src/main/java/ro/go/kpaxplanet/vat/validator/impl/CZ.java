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


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Czech VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class CZ extends AbstractVatFormalValidator {
	private final Logger logger = LoggerFactory.getLogger(CZ.class);

	@Override
	public boolean validateDigits(String vatNumber) {
		// Checks the check digits of a Czech Republic VAT number.

		int total = 0;
		int[] multipliers = { 8, 7, 6, 5, 4, 3, 2 };

		String[] czexp = new String[4];
		czexp[0] = "^\\d{8}$";
		czexp[1] = "^[0-5][0-9][0|1|5|6]\\d[0-3]\\d\\d{3}$";
		czexp[2] = "^6\\d{8}$";
		czexp[3] = "^\\d{2}[0-3|5-8]\\d[0-3]\\d\\d{4}$";
		// int i = 0;

		// Legal entities
		if (vatNumber.matches(czexp[0])) {
			logger.debug("CZ: Legal entities");
			// Extract the next digit and multiply by the counter.
			for (int i = 0; i < 7; i++)
				total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];

			// Establish check digit.
			total = 11 - total % 11;
			if (total == 10)
				total = 0;
			if (total == 11)
				total = 1;

			// Compare it with the last character of the VAT number. If it's the
			// same, then it's valid.
			return total == Integer.parseInt(vatNumber.substring(7, 8));
		}

		// Individuals type 1
		else if (vatNumber.matches(czexp[1])) {
			logger.debug("CZ: Individuals type 1");
			return !(Integer.parseInt(vatNumber.substring(0, 2)) > 53);
		}

		// Individuals type 2
		else if (vatNumber.matches(czexp[2])) {
			logger.debug("CZ: Individuals type 2");
			// Extract the next digit and multiply by the counter.
			for (int i = 0; i < 7; i++)
				total += Integer.parseInt(vatNumber.substring(i + 1, i + 2)) * multipliers[i];

			// Establish check digit.
			int tmp;
			if (total % 11 == 0)
				tmp = total + 11;
			else
				tmp = (int) Math.ceil(total / 11.0) * 11;
			total = tmp - total;

			// Convert calculated check digit according to a lookup table;
			int[] lookup = { 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8 };
			return lookup[total - 1] == Integer.parseInt(vatNumber.substring(8, 9));
		}

		// Individuals type 3
		else if (vatNumber.matches(czexp[3])) {
			logger.debug("CZ: Individuals type 3");
			int temp = Integer.parseInt(vatNumber.substring(0, 2)) + Integer.parseInt(vatNumber.substring(2, 4))
					+ Integer.parseInt(vatNumber.substring(4, 6)) + Integer.parseInt(vatNumber.substring(6, 8))
					+ Integer.parseInt(vatNumber.substring(8));
			return temp % 11 == 0 && Long.parseLong(vatNumber) % 11 == 0;
		}

		return false;
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{8,10})(\\d{3})?$"};
	}

}
