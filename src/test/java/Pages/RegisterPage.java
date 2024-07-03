
package Pages;

import LoggerUtility.LoggerUtility;
import ObjectData.CustomerAccountObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class RegisterPage extends BasePage {
    public RegisterPage (WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']//option[text()='22']")
    private WebElement dayOfBirth;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']//option[text()='March']")
    private WebElement monthOfBirth;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']//option[text()='1980']")
    private WebElement yearOfBirth;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Company")
    private WebElement companyField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(xpath = "//div[text()='Your registration completed']")
    private WebElement registrationCompleted;

    public void createAccount(CustomerAccountObject customerAccountObject) {
        elementMethods.fillElement(firstNameField, customerAccountObject.getFirstName());
        LoggerUtility.infoTestCase("The user adds the first name value");
        elementMethods.fillElement(lastNameField, customerAccountObject.getLastName());
        LoggerUtility.infoTestCase("The user adds the last name value");
        elementMethods.clickElement(dayOfBirth);
        LoggerUtility.infoTestCase("The user selects the day value");
        elementMethods.clickElement(monthOfBirth);
        LoggerUtility.infoTestCase("The user selects the month value");
        elementMethods.clickElement(yearOfBirth);
        LoggerUtility.infoTestCase("The user selects the year value");
        elementMethods.fillElement(emailField, customerAccountObject.getEmail());
        LoggerUtility.infoTestCase("The user adds the email value");
        elementMethods.fillElement(passwordField, customerAccountObject.getPassword());
        LoggerUtility.infoTestCase("The user add password value");
        elementMethods.fillElement(confirmPasswordField, customerAccountObject.getPassword());
        LoggerUtility.infoTestCase("The user confirms the password value");
        elementMethods.clickElement(registerButton);
        LoggerUtility.infoTestCase("The user clicks the register button");
    }

    public void validateRegistration () {
        Assert.assertEquals(registrationCompleted.getText(), "Your registration completed");
        LoggerUtility.infoTestCase("The user validates the registration");

    }
}