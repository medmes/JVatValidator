package ro.go.kpaxplanet.vat.validator.impl;

/**
 * Moroccan VAT number validator.
 *
 * @author Mohammed MESAOUDI
 *
 */
public class MA extends AbstractVatFormalValidator {

    private static final int VAT_NUMBER_LENGTH = 8;

    // Moroccan VAT is a number of eight digits.
    @Override
    public boolean validateDigits(String vatNumber) {
        return vatNumber.length() == VAT_NUMBER_LENGTH;
    }

    @Override
    public String[] getRegexArray() {
        return new String[]{"^(\\d{8})$", "^MA(\\d{8})$"};
    }
}
