package Pages;

import LoggerUtility.LoggerUtility;
import ObjectData.CheckoutObject;
import ObjectData.CustomerAccountObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']//option[text()='Romania']")
    private WebElement country;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement address1;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement zipCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneNumber;

    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button']")
    private WebElement continueButton2;

    @FindBy(xpath = "//button[@class='button-1 payment-method-next-step-button']")
    private WebElement continueButton3;

    @FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
    private WebElement continueButton4;

    @FindBy(id = "shippingoption_1")
    private WebElement shippingOption;

    @FindBy(xpath = "//ul[@class='info-list']//li[@class='name']")
    private WebElement billingAccountName;

    @FindBy(xpath = "//ul[@class='info-list']//li[@class='email']")
    private WebElement billingAccountEmail;

    @FindBy(xpath = "//ul[@class='info-list']//li[@class='country']")
    private WebElement billingAddressCountry;

    @FindBy(xpath = "//ul[@class='info-list']//li[@class='city']")
    private WebElement billingAddressCity;

    @FindBy(xpath = "//ul[@class='info-list']//li[@class='address1']")
    private WebElement billingAddressAddress1;

    @FindBy(xpath = "//ul[@class='info-list']//li[@class='zippostalcode']")
    private WebElement billingAddressZipCode;

    @FindBy(xpath = "//ul[@class='info-list']//li[@class='phone']")
    private WebElement billingAddressPhone;

    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement confirmButton;

    @FindBy(xpath = "//div//strong[text()='Your order has been successfully processed!']")
    private WebElement orderSuccess;


    public void fillForm(CheckoutObject checkoutObject){
        elementMethods.clickElement(country);
        LoggerUtility.infoTestCase("The user selects the country");
        elementMethods.fillElement(city, checkoutObject.getCity());
        LoggerUtility.infoTestCase("The user fills in the city");
        elementMethods.fillElement(address1, checkoutObject.getAddress1());
        LoggerUtility.infoTestCase("The user fills in the address");
        elementMethods.fillElement(zipCode, checkoutObject.getZipCode());
        LoggerUtility.infoTestCase("The user fills in the zip code");
        elementMethods.fillElement(phoneNumber, checkoutObject.getPhoneNumber());
        LoggerUtility.infoTestCase("The user fills in the phone number");
        elementMethods.clickElement(continueButton);
        LoggerUtility.infoTestCase("The user continues to shipping method");
        elementMethods.clickElement(shippingOption);
        LoggerUtility.infoTestCase("The user selects the shipping option");
        elementMethods.clickElement(continueButton2);
        LoggerUtility.infoTestCase("The user continues to payment method");
        elementMethods.clickElement(continueButton3);
        LoggerUtility.infoTestCase("The user continues to payment information");
        elementMethods.clickElement(continueButton4);
        LoggerUtility.infoTestCase("The user continues to confirm order");
    }

    public void validateBillingAccountData (CustomerAccountObject customerAccountObject) {
        Assert.assertEquals(billingAccountName.getText(), customerAccountObject.getFirstName() + " " + customerAccountObject.getLastName());
        LoggerUtility.infoTestCase("The user validates the billingAccountName");
        Assert.assertEquals(billingAccountEmail.getText(), "Email: " + customerAccountObject.getEmail());
        LoggerUtility.infoTestCase("The user validates the billingAccountEmail");
    }

    public void validateBillingAddress (CheckoutObject checkoutObject) {
        Assert.assertEquals(billingAddressCountry.getText(), checkoutObject.getCountry());
        LoggerUtility.infoTestCase("The user validates the billingAddressCountry");
        Assert.assertEquals(billingAddressCity.getText(), checkoutObject.getCity());
        LoggerUtility.infoTestCase("The user validates the billingAddressCity");
        Assert.assertEquals(billingAddressAddress1.getText(), checkoutObject.getAddress1());
        LoggerUtility.infoTestCase("The user validates the billingAddressAddress1");
        Assert.assertEquals(billingAddressZipCode.getText(), checkoutObject.getZipCode());
        LoggerUtility.infoTestCase("The user validates the billingAddressZipCode");
        Assert.assertEquals(billingAddressPhone.getText(), "Phone: " + checkoutObject.getPhoneNumber());
        LoggerUtility.infoTestCase("The user validates the billingAddressPhone");
    }

    public void confirmOrder () {
        elementMethods.clickElement(confirmButton);
        LoggerUtility.infoTestCase("The user confirms the order");
    }

    public void validateOrderSuccess () {
        Assert.assertEquals(orderSuccess.getText(), "Your order has been successfully processed!");
        LoggerUtility.infoTestCase("The user validates the order has been successfully processed");
    }
}