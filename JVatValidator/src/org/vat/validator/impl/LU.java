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
 * Luxembourg VAT number validator.
 * 
 * @author eugen covaci
 * 
 */
public class LU extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {
		
		// Checks the check digits of a Luxembourg VAT number.

		return Integer.parseInt(vatNumber.substring(0, 6)) % 89 == Integer.parseInt(vatNumber.substring(6, 8));
	}

	@Override
	public String[] getRegexArray() {
		return  new String[]{"^(\\d{8})$"};
	}

}
