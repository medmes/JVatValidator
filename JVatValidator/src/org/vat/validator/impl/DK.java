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
 * Danish VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class DK extends AbstractVatFormalValidator {

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a Danish VAT number.

		int total = 0;
		int[] multipliers = { 2, 7, 6, 5, 4, 3, 2, 1 };

		// Extract the next digit and multiply by the counter.
		for (int i = 0; i < 8; i++) {
			total += Integer.parseInt(vatNumber.substring(i, i + 1)) * multipliers[i];
		}
		// Establish check digit.
		total = total % 11;

		// The remainder should be 0 for it to be valid..
		return total == 0;
	}

	@Override
	public String[] getRegexArray() {
		return  new String[]{"^(\\d{8})$"};
	}

}
