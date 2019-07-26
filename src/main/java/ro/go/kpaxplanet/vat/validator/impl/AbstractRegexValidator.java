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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.go.kpaxplanet.vat.validator.RegexValidator;

public abstract class AbstractRegexValidator implements RegexValidator {
	private final Logger logger = LoggerFactory.getLogger(AbstractVatFormalValidator.class);

	/* (non-Javadoc)
	 * @see ro.go.kpaxplanet.vat.validator.RegexValidator#validateRegex(java.lang.String)
	 */
	@Override
	public boolean validateRegex(String value) {
		for (String regex : getRegexArray()) {
			logger.debug("Validate against regex: {}", regex);
			if (value.matches(regex)) {
				return true;
			}
		}
		return false;
	}
}
