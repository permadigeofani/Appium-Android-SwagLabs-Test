package com.permadigeofani.appium.swaglabstest;

import com.permadigeofani.appium.swaglabstest.screens.HomeScreen;
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

public class SignInTest {

    private AndroidDriver driver;
    private SignInScreen signInScreen;
    private HomeScreen homeScreen;

    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = DriverSigleton.getDriver();
        signInScreen = new SignInScreen(driver);
        homeScreen = new HomeScreen(driver);
    }

    @Test(priority = 1)
    @Parameters({ "username" })
    public void fillUsername(String username) throws IOException {
        signInScreen.setUsername(username);
        Screenshot.shootByDate(driver, "04");
    }

    @Test(priority = 2)
    @Parameters({ "password" })
    public void fillPassword(String password) throws IOException {
        signInScreen.setPassword(password);
        Screenshot.shootByDate(driver, "05");
    }

    @Test(priority = 3)
    public void clickLogin() {
        signInScreen.clickLogin();
    }

    @Test(priority = 4)
    public void isHomeScreen() throws IOException {
        // Harus berada di screen home
        String expected = "PRODUCTS";
        String actual = homeScreen.getTitle();
        System.out.println("Sekarang berada di screen => " + actual);
        Screenshot.shootByDate(driver, "06");
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 5)
    public void logout() throws IOException {
        homeScreen.scrollProducts();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Screenshot.shootByDate(driver, "07");
        homeScreen.dragToCarts();
        Screenshot.shootByDate(driver, "08");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        System.out.println("Total cart after customize: " + homeScreen.getTotalCart());
        // homeScreen.openMenu();
        homeScreen.clickCart();
        Screenshot.shootByDate(driver, "09");
    }
}
