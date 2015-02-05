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
package org.vat.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.vat.validator.VatValidator;

public class VatValidationTest {

	@Test
	public void testValidateAT_OK() {
		assertTrue(VatValidator.validate("AT", "U10223006"));
	}
	
	@Test
	public void testValidateAT_KO_1() {
		assertFalse(VatValidator.validate("AT", "U10223106"));
	}
	
	@Test
	public void testValidateAT_KO_2() {
		assertFalse(VatValidator.validate("AT", "10223006"));
	}

	@Test
	public void testValidateBE_OK() {
		assertTrue(VatValidator.validate("BE", "0776091951"));
	}
	
	@Test
	public void testValidateBE_KO_1() {
		assertFalse(VatValidator.validate("BE", "077609195"));
	}
	
	@Test
	public void testValidateBE_KO_2() {
		assertFalse(VatValidator.validate("BE", "0776092951"));
	}
	
	@Test
	public void testValidateBG_OK_1() {
		assertTrue(VatValidator.validate("BG", "101004508"));
	}
	
	@Test
	public void testValidateBG_OK_2() {
		assertTrue(VatValidator.validate("BG", "0041010002"));
	}
	
	@Test
	public void testValidateBG_OK_3() {
		assertTrue(VatValidator.validate("BG", "0000100159"));
	}
	
	@Test
	public void testValidateBG_OK_4() {
		assertTrue(VatValidator.validate("BG", "0000100153"));
	}
	
	@Test
	public void testValidateBG_KO_1() {
		assertFalse(VatValidator.validate("BG", "000100159"));
	}
	
	@Test
	public void testValidateBG_KO_2() {
		assertFalse(VatValidator.validate("BG", "0041020002"));
	}
	
	@Test
	public void testValidateBG_KO_3() {
		assertFalse(VatValidator.validate("BG", "101104508"));
	}
	
	@Test
	public void testValidateBG_KO_4() {
		assertFalse(VatValidator.validate("BG", "0000100154"));
	}
	
	@Test
	public void testValidateCHE_OK() {
		assertTrue(VatValidator.validate("CHE", "105.835.768 MWST"));
	}
	
	@Test
	public void testValidateCY_OK() {
		assertTrue(VatValidator.validate("CY", "00532445O"));
	}
	
	@Test
	public void testValidateCY_KO_1() {
		assertFalse(VatValidator.validate("CY", "0532445O"));
	}
	
	@Test
	public void testValidateCY_KO_2() {
		assertFalse(VatValidator.validate("CY", "00632445O"));
	}
	
	@Test
	public void testValidateCY_KO_3() {
		assertFalse(VatValidator.validate("CY", "00532445M"));
	}
	
	@Test
	public void testValidateCZ_OK_1() {
		assertTrue(VatValidator.validate("CZ", "46505334"));
	}
	
	@Test
	public void testValidateCZ_OK_2() {
		assertTrue(VatValidator.validate("CZ", "395601439"));
	}
	
	@Test
	public void testValidateCZ_OK_3() {
		assertTrue(VatValidator.validate("CZ", "640903926"));
	}
	
	@Test
	public void testValidateCZ_OK_4() {
		assertTrue(VatValidator.validate("CZ", "7103192745"));
	}
	
	@Test
	public void testValidateCZ_KO_1() {
		assertFalse(VatValidator.validate("CZ", "00010159"));
	}
	
	@Test
	public void testValidateCZ_KO_2() {
		assertFalse(VatValidator.validate("CZ", "0041020002"));
	}
	
	@Test
	public void testValidateCZ_KO_3() {
		assertFalse(VatValidator.validate("CZ", "102104508"));
	}
	
	@Test
	public void testValidateCZ_KO_4() {
		assertFalse(VatValidator.validate("CZ", "0001230259"));
	}
	
	@Test
	public void testValidateDE_OK() {
		assertTrue(VatValidator.validate("DE", "111111125"));
	}
	
	@Test
	public void testValidateDK_OK() {
		assertTrue(VatValidator.validate("DK", "88146328"));
	}
	
	@Test
	public void testValidateEE_OK() {
		assertTrue(VatValidator.validate("EE", "100207415"));
	}
	
	@Test
	public void testValidateEL_OK() {
		assertTrue(VatValidator.validate("EL", "040127797"));
	}
	
	@Test
	public void testValidateES_OK() {
		assertTrue(VatValidator.validate("ES", "A0011012B"));
	}
	
	@Test
	public void testValidateFI_OK() {
		assertTrue(VatValidator.validate("FI", "09853608"));
	}
	
	@Test
	public void testValidateFR_OK() {
		assertTrue(VatValidator.validate("FR", "00300076965"));
	}
	
	@Test
	public void testValidateGB_OK_1() {
		assertTrue(VatValidator.validate("GB", "GD123"));
	}
	
	@Test
	public void testValidateGB_OK_2() {
		assertTrue(VatValidator.validate("GB", "434031494"));
	}
	
	@Test
	public void testValidateHU_OK_1() {
		assertTrue(VatValidator.validate("HU", "21376414"));
	}
	
	@Test
	public void testValidateHU_OK_2() {
		assertTrue(VatValidator.validate("HU", "10597190"));
	}
	
	@Test
	public void testValidateIE_OK_1() {
		assertTrue(VatValidator.validate("IE", "8Z49289F"));
	}
	
	@Test
	public void testValidateIE_OK_2() {
		assertTrue(VatValidator.validate("IE", "3628739L"));
	}
	
	@Test
	public void testValidateIT_OK() {
		assertTrue(VatValidator.validate("IT", "00000010215"));
	}
	
	@Test
	public void testValidateLT_OK_1() {
		assertTrue(VatValidator.validate("LT", "213179412"));
	}
	
	@Test
	public void testValidateLT_OK_2() {
		assertTrue(VatValidator.validate("LT", "290061371314"));
	}
	
	@Test
	public void testValidateLU_OK() {
		assertTrue(VatValidator.validate("LU", "10000356"));
	}
	
	@Test
	public void testValidateLV_OK_1() {
		assertTrue(VatValidator.validate("LV", "40003009497"));
	}
	
	@Test
	public void testValidateLV_OK_2() {
		assertTrue(VatValidator.validate("LV", "07091910933"));
	}
	
	@Test
	public void testValidateMT_OK() {
		assertTrue(VatValidator.validate("MT", "15121333"));
	}
	
	@Test
	public void testValidateNL_OK() {
		assertTrue(VatValidator.validate("NL", "010000446B01"));
	}
	
	@Test
	public void testValidatePL_OK() {
		assertTrue(VatValidator.validate("PL", "5260001246"));
	}
	
	@Test
	public void testValidatePT_OK() {
		assertTrue(VatValidator.validate("PT", "502757191"));
	}
	
	@Test
	public void testValidateRO_OK_1() {
		assertTrue(VatValidator.validate("RO", "11198699"));
	}
	
	@Test
	public void testValidateRO_OK_2() {
		assertTrue(VatValidator.validate("RO", "99908"));
	}
	
	@Test
	public void testValidateRO_OK_3() {
		assertTrue(VatValidator.validate("RO", "25886108"));
	}
	
	@Test
	public void testValidateRO_OK_4() {
		assertTrue(VatValidator.validate("RO", "4221306"));
	}
	
	@Test
	public void testValidateRO_OK_5() {
		assertTrue(VatValidator.validate("RO", "19"));
	}
	
	@Test
	public void testValidateSE_OK() {
		assertTrue(VatValidator.validate("SE", "556188840401"));
	}
	
	@Test
	public void testValidateSI_OK() {
		assertTrue(VatValidator.validate("SI", "15012557"));
	}
	
	@Test
	public void testValidateSK_OK() {
		assertTrue(VatValidator.validate("SK", "4030000007"));
	}
	
	@Test
	public void testValidateSK_KO() {
		assertFalse(VatValidator.validate("SK", "5407062531"));
	}

}
