package ro.go.kpaxplanet.vat.validator.impl;

import org.junit.Test;
import ro.go.kpaxplanet.vat.validator.VatValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ATTest {
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
}
