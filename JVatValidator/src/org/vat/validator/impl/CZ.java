/*******************************************************************************
 * Copyright (c) 2014 Eugen Covaci.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Eugen Covaci - initial API and implementation
 ******************************************************************************/
package org.vat.validator.impl;


/**
 * Czech VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class CZ extends AbstractVatFormalValidator {

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
			System.out.println("CZ: Legal entities");
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
			System.out.println("CZ: Individuals type 1");
			return !(Integer.parseInt(vatNumber.substring(0, 2)) > 53);
		}

		// Individuals type 2
		else if (vatNumber.matches(czexp[2])) {
			System.out.println("CZ: Individuals type 2");
			// Extract the next digit and multiply by the counter.
			for (int i = 0; i < 7; i++)
				total += Integer.parseInt(vatNumber.substring(i + 1, i + 2)) * multipliers[i];

			// Establish check digit.
			total = 11 - total % 11;
			if (total == 10)
				total = 0;
			if (total == 11)
				total = 1;

			// Convert calculated check digit according to a lookup table;
			int[] lookup = { 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 10 };
			return lookup[total - 1] == Integer.parseInt(vatNumber.substring(8, 9));
		}

		// Individuals type 3
		else if (vatNumber.matches(czexp[3])) {
			System.out.println("CZ: Individuals type 3");
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
