/*******************************************************************************
 * Copyright (c) 2014 Eugen Covaci.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Eugen Covaci - initial API and implementation
 ******************************************************************************/
package org.vat.validator.impl;

import org.vat.validator.RegexValidator;

public abstract class AbstractRegexValidator implements RegexValidator {
	/* (non-Javadoc)
	 * @see org.vat.validator.RegexValidator#validateRegex(java.lang.String)
	 */
	@Override
	public boolean validateRegex(String value) {
		for (String regex : getRegexArray()) {
			if (value.matches(regex)) {
				return true;
			}
		}
		return false;
	}
}
