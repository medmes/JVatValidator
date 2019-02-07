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
package ro.go.kpaxplanet.vat.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ro.go.kpaxplanet.vat.validator.impl.AT;
import ro.go.kpaxplanet.vat.validator.impl.BE;
import ro.go.kpaxplanet.vat.validator.impl.BG;
import ro.go.kpaxplanet.vat.validator.impl.CHE;
import ro.go.kpaxplanet.vat.validator.impl.CY;
import ro.go.kpaxplanet.vat.validator.impl.CZ;
import ro.go.kpaxplanet.vat.validator.impl.DE;
import ro.go.kpaxplanet.vat.validator.impl.DK;
import ro.go.kpaxplanet.vat.validator.impl.EC;
import ro.go.kpaxplanet.vat.validator.impl.EE;
import ro.go.kpaxplanet.vat.validator.impl.EL;
import ro.go.kpaxplanet.vat.validator.impl.ES;
import ro.go.kpaxplanet.vat.validator.impl.EU;
import ro.go.kpaxplanet.vat.validator.impl.FI;
import ro.go.kpaxplanet.vat.validator.impl.FR;
import ro.go.kpaxplanet.vat.validator.impl.GB;
import ro.go.kpaxplanet.vat.validator.impl.HR;
import ro.go.kpaxplanet.vat.validator.impl.HU;
import ro.go.kpaxplanet.vat.validator.impl.IE;
import ro.go.kpaxplanet.vat.validator.impl.IT;
import ro.go.kpaxplanet.vat.validator.impl.LT;
import ro.go.kpaxplanet.vat.validator.impl.LU;
import ro.go.kpaxplanet.vat.validator.impl.LV;
import ro.go.kpaxplanet.vat.validator.impl.MT;
import ro.go.kpaxplanet.vat.validator.impl.NL;
import ro.go.kpaxplanet.vat.validator.impl.NO;
import ro.go.kpaxplanet.vat.validator.impl.PL;
import ro.go.kpaxplanet.vat.validator.impl.PT;
import ro.go.kpaxplanet.vat.validator.impl.RO;
import ro.go.kpaxplanet.vat.validator.impl.RS;
import ro.go.kpaxplanet.vat.validator.impl.RU;
import ro.go.kpaxplanet.vat.validator.impl.SE;
import ro.go.kpaxplanet.vat.validator.impl.SI;
import ro.go.kpaxplanet.vat.validator.impl.SK;

/**
 *
 * @author Eugen Covaci
 *
 */
public class VatValidator {

	private static final Map<String, VatFormalValidator> VALIDATORS_MAP = new HashMap<>();

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
		VALIDATORS_MAP.put("EC", new EC());
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
	 * Validate the vat number according to country rules. The possible values
	 * for <code>countryCode</code> are:
	 * <ul>
	 * <li>AT</li>
	 * <li>BE</li>
	 * <li>BG</li>
	 * <li>CHE</li>
	 * <li>CY</li>
	 * <li>CZ</li>
	 * <li>DE</li>
	 * <li>DK</li>
	 * <li>EC</li>
	 * <li>EE</li>
	 * <li>EL</li>
	 * <li>ES</li>
	 * <li>EU</li>
	 * <li>FI</li>
	 * <li>FR</li>
	 * <li>GB</li>
	 * <li>GR</li>
	 * <li>HR</li>
	 * <li>HU</li>
	 * <li>IE</li>
	 * <li>IT</li>
	 * <li>LT</li>
	 * <li>LU</li>
	 * <li>LV</li>
	 * <li>MT</li>
	 * <li>NL</li>
	 * <li>NO</li>
	 * <li>PL</li>
	 * <li>PT</li>
	 * <li>RO</li>
	 * <li>RU</li>
	 * <li>RS</li>
	 * <li>SI</li>
	 * <li>SK</li>
	 * <li>SE</li>
	 * </ul>
	 *
	 * @param countryCode
	 *            The ISO-3166 country code.
	 * @param vatNumber
	 *            The vat number.
	 * @return <code>true</code> if <code>vatNumber</code> is valid.
	 * @throws IllegalArgumentException
	 *             when the country's code is not registered or vat number is
	 *             null.
	 */
	public static boolean validate(String countryCode, String vatNumber) {
		if (!VALIDATORS_MAP.containsKey(countryCode)) {
			throw new IllegalArgumentException("Country code [" + countryCode
					+ "] is not among accepted countries");
		}
		if (vatNumber == null) {
			throw new IllegalArgumentException("vatNumber cannot be null");
		}
		return VALIDATORS_MAP.get(countryCode).validate(
				vatNumber.replaceAll("[\\s\\.\\-\\,]", "").toUpperCase());
	}

	public static Set<String> getAcceptedCountries() {
		return VALIDATORS_MAP.keySet();
	}

	public static boolean isAcceptedCountry(String country) {
		return VALIDATORS_MAP.containsKey(country);
	}

	public static void addCountry(String countryCode, VatFormalValidator validator) {
		VALIDATORS_MAP.put(countryCode, validator);
	}
}
