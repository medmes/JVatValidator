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
