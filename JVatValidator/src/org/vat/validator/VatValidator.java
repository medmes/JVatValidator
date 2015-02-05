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
package org.vat.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.vat.validator.impl.AT;
import org.vat.validator.impl.BE;
import org.vat.validator.impl.BG;
import org.vat.validator.impl.CHE;
import org.vat.validator.impl.CY;
import org.vat.validator.impl.CZ;
import org.vat.validator.impl.DE;
import org.vat.validator.impl.DK;
import org.vat.validator.impl.EE;
import org.vat.validator.impl.EL;
import org.vat.validator.impl.ES;
import org.vat.validator.impl.EU;
import org.vat.validator.impl.FI;
import org.vat.validator.impl.FR;
import org.vat.validator.impl.GB;
import org.vat.validator.impl.HR;
import org.vat.validator.impl.HU;
import org.vat.validator.impl.IE;
import org.vat.validator.impl.IT;
import org.vat.validator.impl.LT;
import org.vat.validator.impl.LU;
import org.vat.validator.impl.LV;
import org.vat.validator.impl.MT;
import org.vat.validator.impl.NL;
import org.vat.validator.impl.NO;
import org.vat.validator.impl.PL;
import org.vat.validator.impl.PT;
import org.vat.validator.impl.RO;
import org.vat.validator.impl.RS;
import org.vat.validator.impl.RU;
import org.vat.validator.impl.SE;
import org.vat.validator.impl.SI;
import org.vat.validator.impl.SK;

/**
 * 
 * @author Eugen Covaci
 *
 */
public class VatValidator {
	
	private static final Map<String, VatFormalValidator> VALIDATORS_MAP = new HashMap<String, VatFormalValidator>();

	//Register the predefined validators
	static {
		VALIDATORS_MAP.put("AT", new AT());
		VALIDATORS_MAP.put("BE", new BE());
		VALIDATORS_MAP.put("BG", new BG());
		VALIDATORS_MAP.put("CHE", new CHE());
		VALIDATORS_MAP.put("CY", new CY());
		VALIDATORS_MAP.put("CZ", new CZ());
		VALIDATORS_MAP.put("DE", new DE());
		VALIDATORS_MAP.put("DK", new DK());
		VALIDATORS_MAP.put("EE", new EE());
		VALIDATORS_MAP.put("EL", new EL());
		VALIDATORS_MAP.put("ES", new ES());
		VALIDATORS_MAP.put("EU", new EU());
		VALIDATORS_MAP.put("FI", new FI());
		VALIDATORS_MAP.put("FR", new FR());
		VALIDATORS_MAP.put("GB", new GB());
		VALIDATORS_MAP.put("GR", new EL());
		VALIDATORS_MAP.put("HR", new HR());
		VALIDATORS_MAP.put("HU", new HU());
		VALIDATORS_MAP.put("IE", new IE());
		VALIDATORS_MAP.put("IT", new IT());
		VALIDATORS_MAP.put("LT", new LT());
		VALIDATORS_MAP.put("LU", new LU());
		VALIDATORS_MAP.put("LV", new LV());
		VALIDATORS_MAP.put("MT", new MT());
		VALIDATORS_MAP.put("NL", new NL());
		VALIDATORS_MAP.put("NO", new NO());
		VALIDATORS_MAP.put("PL", new PL());
		VALIDATORS_MAP.put("PT", new PT());
		VALIDATORS_MAP.put("RO", new RO());
		VALIDATORS_MAP.put("RU", new RU());
		VALIDATORS_MAP.put("RS", new RS());
		VALIDATORS_MAP.put("SI", new SI());
		VALIDATORS_MAP.put("SK", new SK());
		VALIDATORS_MAP.put("SE", new SE());
	}

	/**
	 * Validate the vat number according to country rules.
	 * @param countryCode The country's code.
	 * @param vatNumber The vat number.
	 * @return <code>true</code> if <code>vatNumber</code> is valid.
	 * @throws IllegalArgumentException when the country's code is not registered or vat number is null.
	 */
	public static boolean validate(String countryCode, String vatNumber) {
		if (!VALIDATORS_MAP.containsKey(countryCode)) {
			throw new IllegalArgumentException("Country code [" + countryCode + "] is not among accepted countries");
		}
		if (vatNumber == null) {
			throw new IllegalArgumentException("vatNumber cannot be null");
		}
		return VALIDATORS_MAP.get(countryCode).validate(vatNumber.replaceAll("[\\s\\.\\-\\,]", "").toUpperCase());
	}
	
	public static Set<String> getAcceptedCountries () {
		return VALIDATORS_MAP.keySet();
	}
	
	public static boolean isAcceptedCountry (String country) {
		return VALIDATORS_MAP.containsKey(country);
	}
	
	public static void addCountry (String countryCode, VatFormalValidator validator) {
		VALIDATORS_MAP.put(countryCode, validator);
	}
}
