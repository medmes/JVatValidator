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
 * Swiss VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class CHE extends AbstractVatFormalValidator {

	@Override
	public boolean validateDigits(String vatNumber) {
		// Checks the check digits of a Swiss VAT number.

		// Extract the next digit and multiply by the counter.
		int[] multipliers = { 5, 4, 3, 2, 7, 6, 5, 4 };
		int total = 0;
		for (int i = 0; i < 8; i++) {
			total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
		}
		// Establish check digit.
		total = 11 - total % 11;
		if (total == 10) {
			return false;
		}
		if (total == 11) {
			total = 0;
		}
		// Check to see if the check digit given is correct, If not, we have an
		// error with the VAT number
		return total == Integer.parseInt(vatNumber.substring(8, 9));
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{9})(MWST)?$"};
	}

}
