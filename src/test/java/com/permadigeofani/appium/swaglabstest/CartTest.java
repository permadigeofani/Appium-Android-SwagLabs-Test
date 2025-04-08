package com.permadigeofani.appium.swaglabstest;

import com.permadigeofani.appium.swaglabstest.screens.CartScreen;
import com.permadigeofani.appium.swaglabstest.utils.Screenshot;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class CartTest {


    private AndroidDriver driver;
    private CartScreen cartScreen;

    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = DriverSigleton.getDriver();
        cartScreen = new CartScreen(driver);
    }

    @Test
    public void demoTest() throws IOException {
        cartScreen.testCart();
        cartScreen.swipe("left");
        Screenshot.shootByDate(driver, "10");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        cartScreen.removeItem();
        Screenshot.shootByDate(driver, "11");
    }
}
