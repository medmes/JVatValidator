/*******************************************************************************
 * Copyright 2015 Eugen Covaci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package ro.go.kpaxplanet.vat.validator.impl;

/**
 * Spanish VAT number validator.
 *
 * @author eugen covaci
 *
 */
public class ES extends AbstractVatFormalValidator {
	@Override
	public boolean validateDigits(String vatNumber) {

		// Checks the check digits of a Spanish VAT number.

        int total = 0;
        int temp;
        int[] multipliers = {2, 1, 2, 1, 2, 1, 2};
        String[] esexp = new String[4];
        esexp[0] = "^[A-H|J|U|V]\\d{8}$";
        esexp[1] = "^[A-H|N-S|W]\\d{7}[A-J]$";
        esexp[2] = "^[0-9|Y|Z]\\d{7}[A-Z]$";
        esexp[3] = "^[K|L|M|X]\\d{7}[A-Z]$";
        int i;

		// National juridical entities
		if (vatNumber.matches(esexp[0])) {

            // Extract the next digit and multiply by the counter.
            for (i = 0; i < 7; i++) {
                temp = Integer.parseInt(vatNumber.substring(i + 1, i + 2)) * multipliers[i];
                if (temp > 9)
                    total += (temp / 10) + temp % 10;
                else
                    total += temp;
            }
            // Now calculate the check digit itself.
            total = 10 - total % 10;
            if (total == 10) {
                total = 0;
            }

			// Compare it with the last character of the VAT number. If it's the
			// same, then it's valid.
			return total == Integer.parseInt(vatNumber.substring(8, 9));
		}

		// Juridical entities other than national ones
		else if (vatNumber.matches(esexp[1])) {

			// Extract the next digit and multiply by the counter.
			for (i = 0; i < 7; i++) {
				temp = Integer.parseInt(vatNumber.substring(i + 1, i + 2)) * multipliers[i];
				if (temp > 9)
					total += (temp / 10) + temp % 10;
				else
					total += temp;
			}

			// Now calculate the check digit itself.
			total = 10 - total % 10;

			// Compare it with the last character of the VAT number. If it's the
			// same, then it's valid.
			return (char) (total + 64) == vatNumber.charAt(8);
		}

		// Personal number (NIF) (starting with numeric of Y or Z)
		else if (vatNumber.matches(esexp[2])) {
			String tempNumber = new String(vatNumber);
			if (tempNumber.substring(0, 1).equals("Y"))
				tempNumber = "1" + tempNumber.substring(1);
			if (tempNumber.substring(0, 1).equals("Z"))
				tempNumber = "2" + tempNumber.substring(1);
			return tempNumber.charAt(8) == "TRWAGMYFPDXBNJZSQVHLCKE"
					.charAt(Integer.parseInt(tempNumber.substring(0, 8)) % 23);
		}

        // Personal number (NIF) (starting with K, L, M, or X)
        else if (vatNumber.matches(esexp[3])) {
            return vatNumber.charAt(8) == "TRWAGMYFPDXBNJZSQVHLCKE"
                    .charAt(Integer.parseInt(vatNumber.substring(1, 8)) % 23);
        } else {
            return false;
        }
    }

	@Override
	public String[] getRegexArray() {
		return new String[] { "^([A-Z]\\d{8})$", "^([A-H|N-S|W]\\d{7}[A-J])$", "^([0-9|Y|Z]\\d{7}[A-Z])$",
				"^([K|L|M|X]\\d{7}[A-Z])$" };
	}

}
