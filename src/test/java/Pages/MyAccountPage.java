package Pages;

import LoggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[text()='Log out']")
    private WebElement LogOutLink;

    public void LogOutMyAccount() {
        elementMethods.clickElement(LogOutLink);
        LoggerUtility.infoTestCase("The user clicks My Reward Points link");
    }
}