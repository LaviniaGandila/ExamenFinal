package Pages;


import LoggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends BasePage {
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "termsofservice")
    private WebElement termsofserviceCheckBox;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;


    public void shoppingCartPage() {
        elementMethods.scrollElementByPixel(0, 1000);
        elementMethods.clickElement(termsofserviceCheckBox);
        LoggerUtility.infoTestCase("The user checks the termsofserviceCheckBox");
        elementMethods.clickElement(checkoutButton);
        LoggerUtility.infoTestCase("The user clicks the checkoutButton");
    }



}