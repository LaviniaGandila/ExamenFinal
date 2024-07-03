package SharedData;

import SharedData.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SharedData {
    private WebDriver webDriver;

    @BeforeMethod
    public void prepareDriver () {
        webDriver = new BrowserFactory().getBrowserInstance();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

//    @AfterMethod
//    public void clearDriver (){
//        webDriver.quit();
//    }


}
