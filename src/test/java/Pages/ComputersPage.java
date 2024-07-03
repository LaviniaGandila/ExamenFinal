package Pages;

import LoggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ComputersPage extends BasePage {
    public ComputersPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//h2//a[text()=' Notebooks ']")
    private WebElement notebooksLink;


    public void navigateToNotebooksPage() {
        elementMethods.clickElement(notebooksLink);
        LoggerUtility.infoTestCase("The user clicks the notebooks link");
    }
}
