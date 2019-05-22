package com.adaapt;

import java.net.MalformedURLException;

import driverManager.iOSMobileDriver;
import org.testng.annotations.*;

public class Hooks extends iOSMobileDriver {

    @Test
    public void Test() throws MalformedURLException, InterruptedException {
        iOSMobileDriver.iosDriver();
    }

    @AfterTest
    public void TearDown() {

        iOSMobileDriver.CloseApp();
    }

}