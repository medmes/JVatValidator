package ro.go.kpaxplanet.vat.validator.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class ARTest {
    @Test
    public void testValidateAR_11DigitsNumeric() {
        assertTrue(new AR().validate("12345678901"));
    }

    @Test
    public void testNotValidateAR() {
        assertFalse(new AR().validate("1234567890A"));
    }
}
