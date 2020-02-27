package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckCheckbox {

    public WebDriver chromeDriver;
    public String baseUrl = "https://formy-project.herokuapp.com/checkbox";

    @BeforeTest
    public void launchBrowser() {
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to(baseUrl);
    }

    @AfterTest
    public void terminateBrowser() {
        chromeDriver.close();
    }

    @DataProvider(name = "getXPathForCheckbox")
    public Object[] getXPathData() {
        return new Object[]{
                "//input[@type=\"checkbox\"][@value=\"checkbox-1\"]",
                "//input[@type=\"checkbox\"][@value=\"checkbox-2\"]",
                "//input[@type=\"checkbox\"][@value=\"checkbox-3\"]"
        };
    }

    @DataProvider(name = "getCSSForCheckbox")
    public Object[] getCSSData() {
        return new Object[]{
                "input[type=\"checkbox\"][value=\"checkbox-1\"]",
                "input[type=\"checkbox\"][value=\"checkbox-2\"]",
                "input[type=\"checkbox\"][value=\"checkbox-3\"]"
        };
    }

    @Test(dataProvider = "getXPathForCheckbox")
    public void checkCheckboxViaXPath(String xPath) {
        WebElement element = chromeDriver.findElement(By.xpath(xPath));
        element.click();
        Assert.assertTrue(element.isSelected(), "The checkbox " + element.getAttribute("value") + " is left unchecked after checking.");
        element.click();
        Assert.assertFalse(element.isSelected(), "The checkbox " + element.getAttribute("value") + " is left checked after unchecking.");
    }

    @Test(dataProvider = "getCSSForCheckbox")
    public void checkCheckboxViaCSS(String cSS) {
        WebElement element = chromeDriver.findElement(By.cssSelector(cSS));
        element.click();
        Assert.assertTrue(element.isSelected(), "The checkbox " + element.getAttribute("value") + " is left unchecked after checking.");
        element.click();
        Assert.assertFalse(element.isSelected(), "The checkbox " + element.getAttribute("value") + " is left checked after unchecking.");
    }

}
