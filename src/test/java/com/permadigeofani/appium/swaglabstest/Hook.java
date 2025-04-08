package com.permadigeofani.appium.swaglabstest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class Hook {


    @BeforeSuite
    @Parameters({ "url", "deviceName" })
    public void setup(String url, String deviceName) throws MalformedURLException {
        DriverSigleton.getDriver(deviceName, url);
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        DriverSigleton.exit();
    }
}
