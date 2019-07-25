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

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VatValidationTest extends BaseVatValidationTest {
	@Test
	public void testValidateAT_OK() {
		logger.debug("Testing AT OK");
		assertTrue(VatValidator.validate("AT", "U10223006"));
	}

	@Test
	public void testValidateAT_KO_1() {
		logger.debug("Testing AT KO 1");
		assertFalse(VatValidator.validate("AT", "U10223106"));
	}

	@Test
	public void testValidateAT_KO_2() {
		logger.debug("Testing AT KO 2");
		assertFalse(VatValidator.validate("AT", "10223006"));
	}

	@Test
	public void testValidateBE_OK() {
		logger.debug("Testing BE OK");
		assertTrue(VatValidator.validate("BE", "0776091951"));
	}

	@Test
	public void testValidateBE_KO_1() {
		logger.debug("Testing BE KO 1");
		assertFalse(VatValidator.validate("BE", "077609195"));
	}

	@Test
	public void testValidateBE_KO_2() {
		logger.debug("Testing BE KO 2");
		assertFalse(VatValidator.validate("BE", "0776092951"));
	}

	@Test
	public void testValidateBG_OK_1() {
		logger.debug("Testing BG OK 1");
		assertTrue(VatValidator.validate("BG", "101004508"));
	}

	@Test
	public void testValidateBG_OK_2() {
		logger.debug("Testing BG OK 2");
		assertTrue(VatValidator.validate("BG", "0041010002"));
	}

	@Test
	public void testValidateBG_OK_3() {
		logger.debug("Testing BG OK 3");
		assertTrue(VatValidator.validate("BG", "0000100159"));
	}

	@Test
	public void testValidateBG_OK_4() {
		logger.debug("Testing BG OK 4");
		assertTrue(VatValidator.validate("BG", "0000100153"));
	}

	@Test
	public void testValidateBG_KO_1() {
		logger.debug("Testing BG KO 1");
		assertFalse(VatValidator.validate("BG", "000100159"));
	}

	@Test
	public void testValidateBG_KO_2() {
		logger.debug("Testing BG KO 2");
		assertFalse(VatValidator.validate("BG", "0041020002"));
	}

	@Test
	public void testValidateBG_KO_3() {
		logger.debug("Testing BG KO 3");
		assertFalse(VatValidator.validate("BG", "101104508"));
	}

	@Test
	public void testValidateBG_KO_4() {
		logger.debug("Testing BG KO 4");
		assertFalse(VatValidator.validate("BG", "0000100154"));
	}

	@Test
	public void testValidateCHE_OK() {
		logger.debug("Testing CHE OK");
		assertTrue(VatValidator.validate("CHE", "105.835.768 MWST"));
	}

	@Test
	public void testValidateCY_OK() {
		logger.debug("Testing VY OK");
		assertTrue(VatValidator.validate("CY", "00532445O"));
	}

	@Test
	public void testValidateCY_KO_1() {
		logger.debug("Testing CY KO 1");
		assertFalse(VatValidator.validate("CY", "0532445O"));
	}

	@Test
	public void testValidateCY_KO_2() {
		logger.debug("Testing CY KO 2");
		assertFalse(VatValidator.validate("CY", "00632445O"));
	}

	@Test
	public void testValidateCY_KO_3() {
		logger.debug("Testing CY KO 3");
		assertFalse(VatValidator.validate("CY", "00532445M"));
	}

	@Test
	public void testValidateCZ_OK_1() {
		logger.debug("Testing CZ OK 1");
		assertTrue(VatValidator.validate("CZ", "46505334"));
	}

	@Test
	public void testValidateCZ_OK_2() {
		logger.debug("Testing CZ OK 2");
		assertTrue(VatValidator.validate("CZ", "395601439"));
	}

	@Test
	public void testValidateCZ_OK_3() {
		logger.debug("Testing CZ OK 3");
		assertTrue(VatValidator.validate("CZ", "640903926"));
	}

	@Test
	public void testValidateCZ_OK_4() {
		logger.debug("Testing CZ OK 4");
		assertTrue(VatValidator.validate("CZ", "7103192745"));
	}

	@Test
	public void testValidateCZ_KO_1() {
		logger.debug("Testing CZ KO 1");
		assertFalse(VatValidator.validate("CZ", "00010159"));
	}

	@Test
	public void testValidateCZ_KO_2() {
		logger.debug("Testing CZ KO 2");
		assertFalse(VatValidator.validate("CZ", "0041020002"));
	}

	@Test
	public void testValidateCZ_KO_3() {
		logger.debug("Testing CZ KO 3");
		assertFalse(VatValidator.validate("CZ", "102104508"));
	}

	@Test
	public void testValidateCZ_KO_4() {
		logger.debug("Testing CZ KO 4");
		assertFalse(VatValidator.validate("CZ", "0001230259"));
	}

	@Test
	public void testValidateDE_OK() {
		logger.debug("Testing DE OK");
		assertTrue(VatValidator.validate("DE", "111111125"));
	}

	@Test
	public void testValidateDK_OK() {
		logger.debug("Testing DK OK");
		assertTrue(VatValidator.validate("DK", "88146328"));
	}

	@Test
	public void testValidateEE_OK() {
		logger.debug("Testing EE OK");
		assertTrue(VatValidator.validate("EE", "100207415"));
	}

	@Test
	public void testValidateEC_OK_1() {
		logger.debug("Testing EC OK");
		assertTrue(VatValidator.validate("EC", "1734567890"));
	}

	@Test
	public void testValidateEC_OK_2() {
		logger.debug("Testing EC OK");
		assertTrue(VatValidator.validate("EC", "0934567890"));
	}

	@Test
	public void testValidateEC_OK_3() {
		logger.debug("Testing EC OK");
		assertTrue(VatValidator.validate("EC", "1734567890123"));
	}

	@Test
	public void testValidateEC_OK_4() {
		logger.debug("Testing EC OK");
		assertTrue(VatValidator.validate("EC", "0934567890123"));
	}

	@Test
	public void testValidateEL_OK() {
		logger.debug("Testing EL OK");
		assertTrue(VatValidator.validate("EL", "040127797"));
	}

	@Test
	public void testValidateES_OK() {
		logger.debug("Testing ES OK");
		assertTrue(VatValidator.validate("ES", "A0011012B"));
	}

	@Test
	public void testValidateFI_OK() {
		logger.debug("Testing FI OK");
		assertTrue(VatValidator.validate("FI", "09853608"));
	}

	@Test
	public void testValidateFR_OK() {
		logger.debug("Testing FR OK");
		assertTrue(VatValidator.validate("FR", "00300076965"));
	}

	@Test
	public void testValidateGB_OK_1() {
		logger.debug("Testing GB OK 1");
		assertTrue(VatValidator.validate("GB", "GD123"));
	}

	@Test
	public void testValidateGB_OK_2() {
		logger.debug("Testing GB OK 1");
		assertTrue(VatValidator.validate("GB", "434031494"));
	}

	@Test
	public void testValidateHU_OK_1() {
		logger.debug("Testing HU OK 1");
		assertTrue(VatValidator.validate("HU", "21376414"));
	}

	@Test
	public void testValidateHU_OK_2() {
		logger.debug("Testing HU OK 2");
		assertTrue(VatValidator.validate("HU", "10597190"));
	}

	@Test
	public void testValidateIE_OK_1() {
		logger.debug("Testing IE OK 1");
		assertTrue(VatValidator.validate("IE", "8Z49289F"));
	}

	@Test
	public void testValidateIE_OK_2() {
		logger.debug("Testing IE OK 2");
		assertTrue(VatValidator.validate("IE", "3628739L"));
	}

	@Test
	public void testValidateLT_OK_1() {
		logger.debug("Testing LT OK 1");
		assertTrue(VatValidator.validate("LT", "213179412"));
	}

	@Test
	public void testValidateLT_OK_2() {
		logger.debug("Testing LT OK 2");
		assertTrue(VatValidator.validate("LT", "290061371314"));
	}

	@Test
	public void testValidateLU_OK() {
		logger.debug("Testing LU OK");
		assertTrue(VatValidator.validate("LU", "10000356"));
	}

	@Test
	public void testValidateLV_OK_1() {
		logger.debug("Testing LV OK 1");
		assertTrue(VatValidator.validate("LV", "40003009497"));
	}

	@Test
	public void testValidateLV_OK_2() {
		logger.debug("Testing LV OK 2");
		assertTrue(VatValidator.validate("LV", "07091910933"));
	}

	@Test
	public void testValidateMT_OK() {
		logger.debug("Testing MT OK");
		assertTrue(VatValidator.validate("MT", "15121333"));
	}

	@Test
	public void testValidateNL_OK() {
		logger.debug("Testing NL OK");
		assertTrue(VatValidator.validate("NL", "010000446B01"));
	}

	@Test
	public void testValidatePL_OK() {
		logger.debug("Testing PL OK");
		assertTrue(VatValidator.validate("PL", "5260001246"));
	}

	@Test
	public void testValidatePT_OK() {
		logger.debug("Testing PT OK");
		assertTrue(VatValidator.validate("PT", "502757191"));
	}

	@Test
	public void testValidateRO_OK_1() {
		logger.debug("Testing RO OK 1");
		assertTrue(VatValidator.validate("RO", "11198699"));
	}

	@Test
	public void testValidateRO_OK_2() {
		logger.debug("Testing RO OK 2");
		assertTrue(VatValidator.validate("RO", "99908"));
	}

	@Test
	public void testValidateRO_OK_3() {
		logger.debug("Testing RO OK 3");
		assertTrue(VatValidator.validate("RO", "25886108"));
	}

	@Test
	public void testValidateRO_OK_4() {
		logger.debug("Testing RO OK 4");
		assertTrue(VatValidator.validate("RO", "4221306"));
	}

	@Test
	public void testValidateRO_OK_5() {
		logger.debug("Testing RO OK 5");
		assertTrue(VatValidator.validate("RO", "19"));
	}

	@Test
	public void testValidateSE_OK() {
		logger.debug("Testing SE OK");
		assertTrue(VatValidator.validate("SE", "556188840401"));
	}

	@Test
	public void testValidateSI_OK() {
		logger.debug("Testing SI OK");
		assertTrue(VatValidator.validate("SI", "15012557"));
	}

	@Test
	public void testValidateSK_OK() {
		logger.debug("Testing SK OK");
		assertTrue(VatValidator.validate("SK", "4030000007"));
	}

	@Test
	public void testValidateSK_KO() {
		logger.debug("Testing SK KO");
		assertFalse(VatValidator.validate("SK", "5407062531"));
	}

}
