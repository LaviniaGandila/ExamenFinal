
package Pages;

import LoggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    public HomePage (WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[text()='Register']")
    private WebElement registerLink;

    public void navigateToLoginPage() {
        elementMethods.clickElement(loginLink);
        LoggerUtility.infoTestCase("The user clicks on Login Link");
    }

    public void navigateToRegisterPage() {
        elementMethods.clickElement(registerLink);
        LoggerUtility.infoTestCase("The user clicks on Register Link");
    }


}
