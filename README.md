# JVatValidator
## About
This is a standalone Java library for VAT Information Exchange System (VIES) formal validation. It doesn't connect to any web service. It can be used to verify that an input value is a valid VAT number with respect of the formal rules of a certain country.

<b>Important This library does not verify that the input value is truly assigned to a certain company or organisation.

## Usage
This will validate 11198699 value against Romanian VAT patterns:
<pre>
boolean isValid = VatValidator.validate("RO", "11198699");
</pre>
The first argument is the ISO-3166 country code, the second one is the value to be validated.
