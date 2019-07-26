package ro.go.kpaxplanet.vat.validator.impl;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ITTest {
    @Test
    public void testValidateIT_Numeric() {
        assertTrue(new IT().validate("00000010215"));
    }

    @Test
    public void testValidateIT_Alphanumeric() {
        assertTrue(new IT().validate("CLMCLL78C65F205U"));
    }
}

