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


/**
 * Ecuadorian VAT number validator.
 *
 * @author rainier louis
 *
 */
public class EC extends AbstractVatFormalValidator  {

	@Override
	public boolean validateDigits(String vatNumber) {

		// check vatNumber contains only numerics
		if (vatNumber.matches("[0-9]+")) {

			// check the length of vatNumber is either 10 or 13
			if (vatNumber.length() == 10 || vatNumber.length() == 13) {

				// check if the first two characters are either 17 or 09
				String extractFirstTwoChars = vatNumber.substring(0, 2);
				if (extractFirstTwoChars.equals("17") || extractFirstTwoChars.equals("09")) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^(\\d{9})$"};
	}

}
