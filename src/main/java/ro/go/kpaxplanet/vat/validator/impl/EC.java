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

		return vatNumber.matches("^(?=\\d{10,13}$)(01|09)\\d+");
	}

	@Override
	public String[] getRegexArray() {
		return new String[]{"^\\d{10}(\\d{3})?$"};
	}

}
