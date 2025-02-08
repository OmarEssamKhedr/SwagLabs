package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages.P01_LoginPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
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

public class TC01_LoginTest {

    private final String Username1 = DataUtils.getJsonData("validlogin", "normalUsername");
    private final String Username2 = DataUtils.getJsonData("validlogin", "username2");
    private final String Username3 = DataUtils.getJsonData("validlogin", "username3");
    private final String Username4 = DataUtils.getJsonData("validlogin", "username4");
    private final String Username5 = DataUtils.getJsonData("validlogin", "username5");

    private final String Omar = DataUtils.getJsonData("invalidlogin", "Omar");
    private final String lockedOutUser = DataUtils.getJsonData("invalidlogin", "lockedOutUser");
    private final String Char = DataUtils.getJsonData("invalidlogin", "Char");
    private final String empty = DataUtils.getJsonData("invalidlogin", "empty");
    private final String Huge = DataUtils.getJsonData("invalidlogin", "Huge");

    private final String password = DataUtils.getJsonData("validlogin", "password");
    private final String passwordEmpty = DataUtils.getJsonData("validlogin", "passwordEmpty");
    private final String passwordWrong = DataUtils.getJsonData("validlogin", "passwordWrong");

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        LogsUtils.info("Chrome driver is opened");
        getDriver().get(getPropertyValue("environment", "Base_URL"));
        LogsUtils.info("Page is redirected to the url");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void validLoginTC01() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(Username1)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Home_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void validLoginTC02() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(Username2)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Home_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void validLoginTC03() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(Username3)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Home_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void validLoginTC04() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(Username4)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Home_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void validLoginTC05() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(Username5)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Home_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void invalidLoginTC01() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(Omar)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Base_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void invalidLoginTC02() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(lockedOutUser)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Base_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void invalidLoginTC03() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(Char)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Base_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void invalidLoginTC04() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(empty)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Base_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void invalidLoginTC05() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(Huge)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Base_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void invalidLoginTC06() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(Username1)
                .enterPassword(passwordEmpty)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Base_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void invalidLoginTC07() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(Username1)
                .enterPassword(passwordWrong)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Base_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }


    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
