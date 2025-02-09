package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_CheckoutPage {
    private final WebDriver driver;
    private final By firstName = By.xpath("//*[@id=\"first-name\"]");
    private final By lastName = By.xpath("//*[@id=\"last-name\"]");
    private final By zipCode = By.xpath("//*[@id=\"postal-code\"]");

    private final By continueButton = By.xpath("//*[@id=\"continue\"]");

    public P04_CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public P04_CheckoutPage fillingInfoForm(String fName, String lName, String zip) {
        Utility.sendData(driver, firstName, fName);
        Utility.sendData(driver, lastName, lName);
        Utility.sendData(driver, zipCode, zip);
        return this;
    }
    
    public P05_OverviewPage clickOnContinueButton() {
        Utility.ClickOnElement(driver, continueButton);
        return new P05_OverviewPage(driver);
    }
}
