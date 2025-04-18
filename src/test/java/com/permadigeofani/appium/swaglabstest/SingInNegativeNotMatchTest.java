package com.permadigeofani.appium.swaglabstest;

import com.permadigeofani.appium.swaglabstest.screens.SignInScreen;
import com.permadigeofani.appium.swaglabstest.utils.Screenshot;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class SingInNegativeNotMatchTest {

    private AndroidDriver driver;
    private UiAutomator2Options options;
    private SignInScreen signInScreen;

    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = DriverSigleton.getDriver();
        signInScreen = new SignInScreen(driver);
    }

    @Test(priority = 1)
    @Parameters({ "username" })
    public void fillUsername(String username) throws IOException {
        signInScreen.setUsername(username);
        Screenshot.shootByDate(driver, "02");
    }

    @Test(priority = 2)
    @Parameters({ "wrongPassword" })
    public void fillPassword(String password) throws IOException {
        signInScreen.setPassword(password);
        Screenshot.shootByDate(driver, "03");
    }

    @Test(priority = 3)
    public void clickLogin() {
        signInScreen.clickLogin();
    }

    @Test(priority = 4)
    @Parameters({ "errorWhenNotMatch" })
    public void compareError(String errorWhenNotMatch) throws IOException {
        String actual = signInScreen.getErrorMessage(SignInScreen.NOT_MATCH);
        System.out.println(actual);
        Screenshot.shootByDate(driver, "03");
        Assert.assertEquals(actual, errorWhenNotMatch);
    }
}

