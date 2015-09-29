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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.go.kpaxplanet.vat.validator.DigitValidator;
import ro.go.kpaxplanet.vat.validator.VatFormalValidator;

public abstract class AbstractVatFormalValidator extends AbstractRegexValidator implements VatFormalValidator, DigitValidator {

	private final Logger logger = LoggerFactory.getLogger(AbstractVatFormalValidator.class);

	@Override
	public boolean validate(String vatNumber) {
		logger.debug("Vat number to formal validate [" + vatNumber + "]");
		if (validateRegex(vatNumber)) {
			return validateDigits(vatNumber);
		} else {
			logger.debug("Doesn't match any of the regex array: " + Arrays.toString(getRegexArray()));
			return false;
		}
	}
}
