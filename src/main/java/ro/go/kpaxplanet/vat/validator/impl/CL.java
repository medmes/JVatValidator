package ro.go.kpaxplanet.vat.validator.impl;

public class CL extends AbstractVatFormalValidator {

    // CHILE

    @Override
    public boolean validateDigits(String vatNumber) {
        return true;
    }

    @Override
    public String[] getRegexArray() {
        return new String[]{"^\\d{8,9}$"};
    }
}
