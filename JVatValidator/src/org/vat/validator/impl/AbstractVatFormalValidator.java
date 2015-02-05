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

import java.util.Arrays;

import org.vat.validator.DigitValidator;
import org.vat.validator.VatFormalValidator;

public abstract class AbstractVatFormalValidator extends AbstractRegexValidator implements VatFormalValidator, DigitValidator {
	
	@Override
	public boolean validate(String vatNumber) {
		System.out.println("Vat number to formal validate [" + vatNumber + "]");
		if (validateRegex(vatNumber)) {
			return validateDigits(vatNumber);
		} else {
			System.out.println("Doesn't match any of the regex array: " + Arrays.toString(getRegexArray()));
			return false;
		}
	}
}
