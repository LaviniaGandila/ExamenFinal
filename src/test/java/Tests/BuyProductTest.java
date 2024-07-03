package Tests;

import ObjectData.CheckoutObject;
import ObjectData.CustomerAccountObject;
import Pages.*;
import PropertyUtility.PropertyUtility;
import SharedData.SharedData;
import org.testng.annotations.Test;



public class BuyProductTest extends SharedData{
    @Test
    public void metodaTest () {
        PropertyUtility propertyUtility = new PropertyUtility("CustomerAccountData");
        CustomerAccountObject customerAccountObject = new CustomerAccountObject(propertyUtility.getAllData());

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.loginAccount(customerAccountObject);
        loginPage.navigateToComputerPage();

        ComputersPage computerPage = new ComputersPage(getWebDriver());
        computerPage.navigateToNotebooksPage();

        NotebooksPage notebooksPage = new NotebooksPage(getWebDriver());
        notebooksPage.selectFirstFromNotebooksList();
        notebooksPage.addToCart();
        notebooksPage.goToCartPage();

        CartPage cartPage = new CartPage(getWebDriver());
        cartPage.shoppingCartPage();

        PropertyUtility propertyUtilityCheckOut = new PropertyUtility("CheckOutData");
        CheckoutObject checkoutObject = new CheckoutObject(propertyUtilityCheckOut.getAllData());

        CheckOutPage checkOutPage = new CheckOutPage(getWebDriver());
        checkOutPage.fillForm(checkoutObject);
        checkOutPage.validateBillingAccountData(customerAccountObject);
        checkOutPage.validateBillingAddress(checkoutObject);
        checkOutPage.confirmOrder();
        checkOutPage.validateOrderSuccess();

        loginPage.logOutMyAccount();




        




    }
}
