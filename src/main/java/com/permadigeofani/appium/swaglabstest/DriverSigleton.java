package com.permadigeofani.appium.swaglabstest;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

public class DriverSigleton {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver(String deviceName, String url) throws MalformedURLException {
        if (driver == null) {
            driver = AndroidManager.buildDriver(deviceName, url);
        }

        return driver;
    }

    public static AndroidDriver getDriver() throws MalformedURLException {
        return driver;
    }

    public static void exit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
