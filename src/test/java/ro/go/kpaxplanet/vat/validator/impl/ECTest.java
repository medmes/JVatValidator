package ro.go.kpaxplanet.vat.validator.impl;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ECTest {
    @Test
    public void testValidateEC_10Plus3DigitsNumeric() {
        assertTrue(new EC().validate("1090033944001"));
    }

    @Test
    public void testValidateEC_10DigitsNumeric() {
        assertTrue(new EC().validate("1090033944"));
    }

    @Test
    public void testNotValidateEC_14DigitsNumeric() {
        assertFalse(new EC().validate("10900339440012"));
    }

    @Test
    public void testNotValidateEC_whenLetter() {
        assertFalse(new EC().validate("A090033944001"));
    }
}
