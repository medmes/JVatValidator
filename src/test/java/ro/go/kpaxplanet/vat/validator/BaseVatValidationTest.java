package ro.go.kpaxplanet.vat.validator;

import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseVatValidationTest {
    protected final Logger logger = LoggerFactory.getLogger(VatValidationTest.class);

    @BeforeClass
    public static void configureLog () {
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "DEBUG");
    }
}
