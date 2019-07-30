package ro.go.kpaxplanet.vat.validator.impl;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TRTest {

    @Test
    public void testValidateTR_10DigitsNumeric() {
        assertTrue(new TR().validate("1234567890"));
    }

    @Test
    public void testNotValidateTR() {
        assertFalse(new TR().validate("123456789A"));
    }
}
