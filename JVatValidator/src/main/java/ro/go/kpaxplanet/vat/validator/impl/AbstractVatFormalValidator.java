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

import java.util.Arrays;

import ro.go.kpaxplanet.vat.validator.DigitValidator;
import ro.go.kpaxplanet.vat.validator.VatFormalValidator;

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
