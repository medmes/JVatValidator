package ro.go.kpaxplanet.vat.validator.impl;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CLest {

    @Test
    public void testValidateCL_8DigitisNumeric() {
        assertTrue(new CL().validate("12345678"));
    }

    @Test
    public void testValidateCL_9DigitisNumeric() {
        assertTrue(new CL().validate("123456789"));
    }

    @Test
    public void testNotValidateCL() {
        assertFalse(new CL().validate("1234567890A"));
    }
}
