package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages.P01_LoginPage;
import Pages.P02_LandingPage;
import Pages.P03_CartPage;
import Pages.P04_CheckoutPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class})

public class TC04_CheckoutTest {

    private final String username1 = DataUtils.getJsonData("validlogin", "normalUsername");
    private final String password = DataUtils.getJsonData("validlogin", "password");
    private final String firstName = DataUtils.getJsonData("information", "fName") + " - " + "Time";
    private final String lastName = DataUtils.getJsonData("information", "lName") + " - " + "Time";
    private final String zipCode = DataUtils.getJsonData("information", "ZIP") + " - " + "Time";


    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        LogsUtils.info("Chrome driver is opened");
        getDriver().get(getPropertyValue("environment", "Base_URL"));
        LogsUtils.info("Page is redirected to the url");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkoutStepOneTC() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(username1)
                .enterPassword(password)
                .ClickOnLoginButton();
        new P02_LandingPage(getDriver())
                .addRandomProducts(2, 6)
                .clickOnCartIcon();
        new P03_CartPage(getDriver())
                .clickOnCheckoutButton();
        new P04_CheckoutPage(getDriver())
                .fillingInfoForm(firstName, lastName, zipCode)
                .clickOnContinueButton();
        LogsUtils.info(firstName + " " + lastName + " " + zipCode);
        Assert.assertTrue(Utility.verifyURL(getDriver(), getPropertyValue("environment", "Checkout2_URL")));
    }


    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
