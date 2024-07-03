package Tests;

import ObjectData.CustomerAccountObject;
import Pages.CustomerInfoPage;
import Pages.HomePage;
import Pages.LoginPage;
import PropertyUtility.PropertyUtility;
import SharedData.SharedData;
import org.testng.annotations.Test;

public class LogginAccountAndValidationTest extends SharedData {


    @Test
    public void metodaTest () {
        PropertyUtility propertyUtility = new PropertyUtility("CustomerAccountData");
        CustomerAccountObject customerAccountObject = new CustomerAccountObject(propertyUtility.getAllData());

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.loginAccount(customerAccountObject);
        loginPage.navigateToAccountPage();

        CustomerInfoPage customerInfoPage = new CustomerInfoPage(getWebDriver());
        customerInfoPage.setCompanyField(customerAccountObject);
        customerInfoPage.validateCustomerInfo(customerAccountObject);

        loginPage.logOutMyAccount();
    }
}
