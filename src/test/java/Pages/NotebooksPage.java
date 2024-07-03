package Pages;

import LoggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class NotebooksPage extends BasePage {
    public NotebooksPage(WebDriver webDriver) {
        super(webDriver);
    }



    @FindBy(xpath = "//h2[@class='product-title']//a")
    private List<WebElement> NotebooksList;

    @FindBy(id = "add-to-cart-button-4")
    private WebElement addToCart;

    @FindBy(xpath = "//a//span[text()='Notebooks']")
    private WebElement notebooksLinkBreadcrumbs;

    @FindBy(xpath = "//p//a[text()='shopping cart']")
    private WebElement cartLink;


    public void selectFirstFromNotebooksList (){
        for(Integer index = 0; index<NotebooksList.size(); index++) {
                elementMethods.clickElement(NotebooksList.get(0));
                break;
        }
        LoggerUtility.infoTestCase("The user selects the first notebook in the page");
    }

    public void addToCart() {
        elementMethods.clickElement(addToCart);
        LoggerUtility.infoTestCase("The user adds the product to the cart");
    }

    public void goToCartPage() {
        elementMethods.clickElement(cartLink);
        LoggerUtility.infoTestCase("The user goes to the cart page");
    }


}