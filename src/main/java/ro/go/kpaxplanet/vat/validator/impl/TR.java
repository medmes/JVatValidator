package ro.go.kpaxplanet.vat.validator.impl;

public class TR extends AbstractVatFormalValidator {

    // TURKEY

    @Override
    public boolean validateDigits(String vatNumber) {
        return true;
    }

    @Override
    public String[] getRegexArray() {
        return new String[]{"^(\\d{10})$"};
    }
}
