package ro.go.kpaxplanet.vat.validator.impl;

public class AR extends AbstractVatFormalValidator {

    @Override
    public boolean validateDigits(String vatNumber) {
        return true;
    }

    @Override
    public String[] getRegexArray() {
        return new String[]{"^(\\d{11})$"};
    }
}
