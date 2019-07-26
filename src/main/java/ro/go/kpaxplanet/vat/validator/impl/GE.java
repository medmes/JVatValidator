package ro.go.kpaxplanet.vat.validator.impl;

public class GE extends AbstractVatFormalValidator {

    // GEORGIA

    @Override
    public boolean validateDigits(String vatNumber) {
        return true;
    }

    @Override
    public String[] getRegexArray() {
        return new String[]{"^(\\d{9})$"};
    }
}
