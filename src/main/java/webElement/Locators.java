package webElement;


import driverManager.iOSMobileDriver;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Application specific test projects can use properties file to keep locators which are used to identify web elements.
 * Locators are managed using this class. This class provides
 *
 * @author Nilmi
 */
public class Locators extends iOSMobileDriver {

    private static final Properties locators = new Properties();

    /**
     * Initializes element locators. Element locators are stored in key value pair format.
     * Key is the element name and value is the locator. Therefore its recommended to store
     * element locators in property files in a certain directory and give that directory
     * path in configurations property file.
     */
    public static void init() {
        try {
            File locatorFiles = new File("/Users/subhasishsengupta/Documents/isoSample/src/main/resources/locators");
            if (locatorFiles.exists()) {
                if (locatorFiles.isDirectory()) {
                    Files.walk(locatorFiles.toPath())
                            .filter(path -> path.toString().endsWith(".properties"))
                            .forEach(path -> {
                                Properties properties = new Properties();
                                try {
                                    properties.load(new FileInputStream(path.toFile()));
                                    locators.putAll(properties);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                } else {
                    locators.load(new FileInputStream(locatorFiles));
                }
            } else {
                Logger.getLogger(Constants.LOG_CODE).log(Level.WARNING, "Please specify locators");
            }
        } catch (Exception e) {
            Logger.getLogger(Constants.LOG_CODE).log(Level.SEVERE, "Error in initializing locators", e);
        }
    }

    /**
     * Find web element using specified locator type and  locator.
     *
     * @param how       Locator type to find the web element
     * @param key       Locator key (specified in locator property file)
     * @param arguments Additional arguments
     * @return WebElement, according to specified parameters
     */
    public static WebElement getElement(How how, String key, Object... arguments) {
        By by = getBy(how, key, arguments);
        if (by != null) {
            return iOSMobileDriver.driver.findElement(by);
        }
        return null;
    }

    /**
     * Returns relevant By instance for specified parameters.
     *
     * @param how       Locator type to find the web element
     * @param key       Locator key (specified in locator property file)
     * @param arguments Additional arguments
     * @return Appropriate By instance
     */
    public static By getBy(How how, String key, Object... arguments) {
        String locator = get(key);
        if (!StringUtils.isEmpty(locator)) {
            if (arguments != null && arguments.length > 0) {
                locator = MessageFormat.format(locator, arguments);
            }
            switch (how) {
                case CLASS_NAME: {
                    return By.className(locator);
                }
                case CSS: {
                    return By.cssSelector(locator);
                }
                case ID: {
                    return By.id(locator);
                }
                case LINK_TEXT: {
                    return By.linkText(locator);
                }
                case NAME: {
                    return By.name(locator);
                }
                case PARTIAL_LINK_TEXT: {
                    return By.partialLinkText(locator);
                }
                case TAG_NAME: {
                    return By.tagName(locator);
                }
                case XPATH: {
                    return By.xpath(locator);
                }
            }
        }
        return null;
    }

    /**
     * Returns locator for a given element.
     *
     * @param key Element in String format
     * @return Element locator in String format
     */
    public static String get(String key) {
        return locators.getProperty(key);
    }

}
