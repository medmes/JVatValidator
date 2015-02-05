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


public class EU extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {
		// We know little about EU numbers apart from the fact that the first 3
		// digits represent the
		// country, and that there are nine digits in total.
		return true;
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{9})$"};
	}

}
