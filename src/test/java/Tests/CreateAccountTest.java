package Tests;

import ObjectData.CustomerAccountObject;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import PropertyUtility.PropertyUtility;
import SharedData.SharedData;
import org.testng.annotations.Test;




public class CreateAccountTest extends SharedData{
    @Test
    public void metodaTest () {
        PropertyUtility propertyUtility = new PropertyUtility("CustomerAccountData");
        CustomerAccountObject customerAccountObject = new CustomerAccountObject(propertyUtility.getAllData());

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(getWebDriver());
        registerPage.createAccount(customerAccountObject);
        registerPage.validateRegistration();

        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.logOutMyAccount();
    }
}
