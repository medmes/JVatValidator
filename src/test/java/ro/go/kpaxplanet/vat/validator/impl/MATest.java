package ro.go.kpaxplanet.vat.validator.impl;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MATest {

    private static final String MOROCCAN_VALID_VAT_NUMBER = "12345678";

    private static final String MOROCCAN_INVALID_VAT_NUMBER_LESS_THAN_EIGHT_DIGITS = "1234567";

    private static final String MOROCCAN_INVALID_VAT_NUMBER_MORE_THAN_EIGHT_DIGITS = "123456789";

    @Test
    public void validateDigits_ShouldReturnTrueWhenVatNumberHasEightDigits() {
        //Given, When and Then
        assertTrue(new MA().validate(MOROCCAN_VALID_VAT_NUMBER));
    }

    @Test
    public void validateDigits_ShouldReturnFalseWhenVatNumberHasLessThanEightDigits() {
        //Given, When and Then
        assertFalse(new MA().validate(MOROCCAN_INVALID_VAT_NUMBER_LESS_THAN_EIGHT_DIGITS));
    }

    @Test
    public void validateDigits_ShouldReturnFalseWhenVatNumberHasMoreThanEightDigits() {
        //Given, When and Then
        assertFalse(new MA().validate(MOROCCAN_INVALID_VAT_NUMBER_MORE_THAN_EIGHT_DIGITS));
    }

}
