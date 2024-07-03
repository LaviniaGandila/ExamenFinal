package Pages;

import LoggerUtility.LoggerUtility;
import ObjectData.CustomerAccountObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[text()='My account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//a[text()='Computers ']")
    private WebElement computersLink;

    @FindBy(xpath = "//a[text()='Log out']")
    private WebElement logOutLink;

    public void loginAccount(CustomerAccountObject customerAccountObject) {
        elementMethods.fillElement(emailField, customerAccountObject.getEmail());
        LoggerUtility.infoTestCase("The user adds username value");
        elementMethods.fillElement(passwordField, customerAccountObject.getPassword());
        LoggerUtility.infoTestCase("The user adds password value");
        elementMethods.clickElement(loginButton);
        LoggerUtility.infoTestCase("The user clicks the login button");}


    public void navigateToAccountPage () {
        elementMethods.validateExpectedElement(myAccountLink, "My account");
        LoggerUtility.infoTestCase("The user is logged in");
        elementMethods.clickElement(myAccountLink);
        LoggerUtility.infoTestCase("The user clicks the my account link");
    }

    public void navigateToComputerPage() {
        elementMethods.clickElement(computersLink);
        LoggerUtility.infoTestCase("The user clicks the computers link");
    }

    public void logOutMyAccount() {
        elementMethods.clickElement(logOutLink);
        LoggerUtility.infoTestCase("The user clicks the logout link");
    }

}