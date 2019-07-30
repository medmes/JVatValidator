package ro.go.kpaxplanet.vat.validator.impl;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GETest {

    @Test
    public void testValidateGE_9DigitsNumeric() {
        assertTrue(new GE().validate("123456789"));
    }

    @Test
    public void testNotValidateGE() {
        assertFalse(new GE().validate("12345678A"));
    }
}
