package Pages;


import HelperMethods.ElementMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public ElementMethods elementMethods;

    public WebDriver webDriver;


    public BasePage (WebDriver webDriver) {
        this.webDriver = webDriver;
        elementMethods = new ElementMethods(webDriver);
        PageFactory.initElements(webDriver, this);
    }
}
