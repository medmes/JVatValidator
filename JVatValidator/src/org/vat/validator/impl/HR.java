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
 * Croatian VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class HR extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a Croatian VAT number using ISO 7064, MOD
		// 11-10 for check digit.

		int product = 10;
		int sum = 0;

		for (int i = 0; i < 10; i++) {

			// Extract the next digit and implement the algorithm
			sum = (Integer.parseInt(vatNumber.substring(i, i + 1)) + product) % 10;
			if (sum == 0) {
				sum = 10;
			}
			product = (2 * sum) % 11;
		}

		// Now check that we have the right check digit
		return (product + Integer.parseInt(vatNumber.substring(10, 11)) * 1) % 10 == 1;
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{11})$"};
	}

}
