package Pages;

import ObjectData.CustomerAccountObject;
import LoggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class CustomerInfoPage extends BasePage {
    public CustomerInfoPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div//h1[text()='My account - Customer info']")
    private WebElement myAccountcustomerInfoLink;

    @FindBy(id = "FirstName")
    private WebElement firstNameFiled;

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

    @FindBy(id = "save-info-button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@class='bar-notification success']//span[@title='Close']")
    private WebElement closeMessageSucces;



    public void fillCompanyField (String companyValue) {
        elementMethods.refillElement(companyField, companyValue);
    }

    public void setCompanyField (CustomerAccountObject customerAccountObject) {
        fillCompanyField(customerAccountObject.getCompany());
        LoggerUtility.infoTestCase("The user filled the company field");
        elementMethods.clickElement(saveButton);
        LoggerUtility.infoTestCase("The user saves the data");
        elementMethods.clickElement(closeMessageSucces);
        LoggerUtility.infoTestCase("The user closes the update successfully confirmation message");
    }

    public void validateCustomerInfo (CustomerAccountObject customerAccountObject){
        Assert.assertEquals(myAccountcustomerInfoLink.getText(), "My account - Customer info");
        LoggerUtility.infoTestCase("The user validates the table name");

        Assert.assertEquals(firstNameFiled.getAttribute("value"),customerAccountObject.getFirstName());
        LoggerUtility.infoTestCase("The user validates the first name");

        Assert.assertEquals(lastNameField.getAttribute("value"), customerAccountObject.getLastName());
        LoggerUtility.infoTestCase("The user validates the last name");

        Assert.assertEquals(dayOfBirth.getAttribute("value"), "22");
        LoggerUtility.infoTestCase("The user validates the day of birth");

        Assert.assertEquals(monthOfBirth.getAttribute("value"), "3");
        LoggerUtility.infoTestCase("The user validates the month of birth");

        Assert.assertEquals(yearOfBirth.getAttribute("value"), "1980");
        LoggerUtility.infoTestCase("The user validates the year of birth");

        Assert.assertEquals(emailField.getAttribute("value"), customerAccountObject.getEmail());
        LoggerUtility.infoTestCase("The user validates the email");

        Assert.assertEquals(companyField.getAttribute("value"), customerAccountObject.getCompany());
        LoggerUtility.infoTestCase("The user validates the company");

    }
}
