package ro.go.kpaxplanet.vat.validator.impl;

import org.junit.Test;
import ro.go.kpaxplanet.vat.validator.BaseVatValidationTest;
import ro.go.kpaxplanet.vat.validator.VatValidator;

import static org.junit.Assert.*;

public class ITTest extends BaseVatValidationTest {
    @Test
    public void testValidateIT_OK() {
        logger.debug("Testing IT OK");
        assertTrue(VatValidator.validate("IT", "00000010215"));
    }
}

