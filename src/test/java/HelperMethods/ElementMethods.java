package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class ElementMethods {
    private WebDriver webDriver;

    public ElementMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void scrollElementByPixel (Integer x, Integer y) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy("+x+","+y+")", "");
    }

    public void waitVisibleElement (WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement (WebElement element){
        waitVisibleElement(element);
        element.click();
    }

    public void validateExpectedElement (WebElement element, String expected) {
        waitVisibleElement(element);
        String actual = element.getText();
        Assert.assertEquals(actual, expected);
    }

    public void fillElement (WebElement element, String value){
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void refillElement (WebElement element, String value){
        waitVisibleElement(element);
        element.clear();
        element.sendKeys(value);
    }
}
