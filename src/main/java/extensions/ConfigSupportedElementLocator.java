package extensions;

import driverManager.iOSMobileDriver;


import org.openqa.selenium.support.pagefactory.DefaultElementLocator;

import java.lang.reflect.Field;


public class ConfigSupportedElementLocator extends DefaultElementLocator {

    public ConfigSupportedElementLocator(Field field) {
        super(iOSMobileDriver.driver, new com.tests.qa.testbase.extensions.ConfigSupportedAnnotations(field));
    }

}
