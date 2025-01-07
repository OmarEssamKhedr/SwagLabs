package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    private final By username = By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input");
    private final By password = By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input");
    private final By LoginButton = By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input");
    private final WebDriver driver;

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_LoginPage enterUsername(String usernameText) {
        Utility.sendData(driver, username, usernameText);
        return this;
    }

    public P01_LoginPage enterPassword(String PasswordText) {
        Utility.sendData(driver, password, PasswordText);
        return this;
    }

    public P02_LandingPage ClickOnLoginButton() {
        Utility.ClickOnElement(driver, LoginButton);
        return new P02_LandingPage(driver);
    }

    public boolean assetLoginTC(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }

}
