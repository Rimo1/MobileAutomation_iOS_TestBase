package extensions;

import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;


public class ConfigSupportedElementLocatorFactory implements ElementLocatorFactory {

    @Override
    public ElementLocator createLocator(Field field) {
        return new ConfigSupportedElementLocator(field);
    }

}
