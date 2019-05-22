package driverManager;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class iOSMobileDriver {

    public static io.appium.java_client.AppiumDriver<WebElement> driver;
    public static DesiredCapabilities cap;

    public static void iosDriver() throws MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPad Pro (9.7-inch)");
        cap.setCapability("platformVersion", "12.2");
        cap.setCapability("bundleId", "au.edu.mcri.au.edu.mcri.adaapt");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        driver = new IOSDriver <WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        Assert.assertNotNull(driver);
       // return driver;

    }

    public static void CloseApp() {
        driver.quit();

    }


}