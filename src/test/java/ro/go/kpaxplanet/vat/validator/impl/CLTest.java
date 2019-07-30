package ro.go.kpaxplanet.vat.validator.impl;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CLTest {

    @Test
    public void testValidateCL_8DigitsNumeric() {
        assertTrue(new CL().validate("12345678"));
    }

    @Test
    public void testValidateCL_9DigitsNumeric() {
        assertTrue(new CL().validate("123456789"));
    }

    @Test
    public void testNotValidateCL() {
        assertFalse(new CL().validate("12345678A"));
    }
}
