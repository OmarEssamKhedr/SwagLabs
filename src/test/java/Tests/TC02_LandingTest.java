package Tests;

import Pages.P01_LoginPage;
import Pages.P02_LandingPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;
import static Utilities.Utility.verifyURL;

public class TC02_LandingTest {
    private final String normalUsername = DataUtils.getJsonData("validLogin", "normalUsername");

    private final String password = DataUtils.getJsonData("validLogin", "password");

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        LogsUtils.info("Chrome driver is opened");
        getDriver().get(getPropertyValue("environment", "Base_URL"));
        LogsUtils.info("Page is redirected to the url");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void comparingNumberOfSelectedProductsTC() {
        new P01_LoginPage(getDriver())
                .enterUsername(normalUsername)
                .enterPassword(password)
                .ClickOnLoginButton()
                .addAllProductsToCart();

        Assert.assertTrue(new P02_LandingPage(getDriver()).comparingNumberOfProducts());

    }

    @Test
    public void addingRandomProductsToCartTC() {
        new P01_LoginPage(getDriver())
                .enterUsername(normalUsername)
                .enterPassword(password)
                .ClickOnLoginButton()
                .addRandomProducts(3, 6);

        Assert.assertTrue(new P02_LandingPage(getDriver()).comparingNumberOfProducts());

    }

    @Test
    public void ClickOnCartIcon() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(normalUsername)
                .enterPassword(password)
                .ClickOnLoginButton()
                .clickOnCartIcon();
        Assert.assertTrue(verifyURL(getDriver(), (DataUtils.getPropertyValue("environment", "Cart_URL"))));

    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
