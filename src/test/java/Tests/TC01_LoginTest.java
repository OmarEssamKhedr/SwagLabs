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

    private final String userName1 = DataUtils.getJsonData("validlogin", "normalUsername");
    private final String userName2 = DataUtils.getJsonData("validlogin", "username2");
    private final String userName3 = DataUtils.getJsonData("validlogin", "username3");
    private final String userName4 = DataUtils.getJsonData("validlogin", "username4");
    private final String userName5 = DataUtils.getJsonData("validlogin", "username5");

    private final String omar = DataUtils.getJsonData("invalidlogin", "Omar");
    private final String lockedOutUser = DataUtils.getJsonData("invalidlogin", "lockedOutUser");
    private final String Char = DataUtils.getJsonData("invalidlogin", "Char");
    private final String empty = DataUtils.getJsonData("invalidlogin", "empty");
    private final String huge = DataUtils.getJsonData("invalidlogin", "Huge");

    private final String password = DataUtils.getJsonData("validlogin", "password");
    private final String passwordEmpty = DataUtils.getJsonData("invalidlogin", "passwordEmpty");
    private final String passwordWrong = DataUtils.getJsonData("invalidlogin", "passwordWrong");

    @BeforeMethod
    public void setup() throws IOException {
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : getPropertyValue("environment", "Browser");
        LogsUtils.info(System.getProperty("browser"));
        setupDriver(browser);
        LogsUtils.info("Chrome driver is opened");
        getDriver().get(getPropertyValue("environment", "Base_URL"));
        LogsUtils.info("Page is redirected to the url");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void validLoginTC01() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(userName1)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Home_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void validLoginTC02() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(userName2)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Home_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void validLoginTC03() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(userName3)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Home_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void validLoginTC04() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(userName4)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Home_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void validLoginTC05() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(userName5)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Home_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void invalidLoginTC01() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(omar)
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
                .enterUsername(huge)
                .enterPassword(password)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Base_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void invalidLoginTC06() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(userName1)
                .enterPassword(passwordEmpty)
                .ClickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assetLoginTC(getPropertyValue("environment", "Base_URL")));
        getDriver().get(getPropertyValue("environment", "Base_URL"));
    }

    @Test
    public void invalidLoginTC07() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(userName1)
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
