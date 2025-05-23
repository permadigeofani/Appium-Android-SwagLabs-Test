package com.permadigeofani.appium.swaglabstest;

import com.permadigeofani.appium.swaglabstest.screens.SignInScreen;
import com.permadigeofani.appium.swaglabstest.utils.Screenshot;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class SignInNegativeEmptyUsernameTest {


    private AndroidDriver driver;
    private SignInScreen signInScreen;

    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = DriverSigleton.getDriver();
        signInScreen = new SignInScreen(driver);
    }

    @Test(priority = 1)
    public void clickLogin() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        signInScreen.clickLogin();

    }

    @Test(priority = 2)
    @Parameters({ "errorWhenEmptyUsername" })
    public void compareError(String errorWhenEmptyUsername) throws IOException {
        String actual = signInScreen.getErrorMessage(SignInScreen.EMPTY_USERNAME);
        System.out.println(actual);
        Screenshot.shootByDate(driver, "01");
        Assert.assertEquals(actual, errorWhenEmptyUsername);
    }
}
