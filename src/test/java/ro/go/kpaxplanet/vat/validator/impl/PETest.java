package ro.go.kpaxplanet.vat.validator.impl;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PETest {

    @Test
    public void testValidatePE_11DigitsNumeric() {
        assertTrue(new PE().validate("12345678901"));
    }

    @Test
    public void testNotValidatePE() {
        assertFalse(new PE().validate("1234567890A"));
    }
}
