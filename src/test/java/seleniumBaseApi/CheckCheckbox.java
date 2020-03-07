package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckCheckbox {

    private WebDriver chromeDriver;
    private String baseUrl = "https://formy-project.herokuapp.com/checkbox";

    @BeforeClass
    public void launchBrowserAndNavigateToBaseUrl() {
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to(baseUrl);
    }

    @AfterClass
    public void terminateBrowser() {
        chromeDriver.quit();
    }

    @DataProvider(name = "getXPathForCheckbox")
    public Object[] getXPathData() {
        return new Object[]{
                "//input[@type='checkbox'][@value='checkbox-1']",
                "//input[@type='checkbox'][@value='checkbox-2']",
                "//input[@type='checkbox'][@value='checkbox-3']"
        };
    }

    @DataProvider(name = "getCSSForCheckbox")
    public Object[] getCSSData() {
        return new Object[]{
                "input[type='checkbox'][value='checkbox-1']",
                "input[type='checkbox'][value='checkbox-2']",
                "input[type='checkbox'][value='checkbox-3']"
        };
    }

    @Test(dataProvider = "getXPathForCheckbox")
    public void checkCheckboxViaXPath(String xPath) {
        WebElement checkbox = chromeDriver.findElement(By.xpath(xPath));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected(), "The checkbox " + checkbox.getAttribute("value") + " is left unchecked after checking.");
        checkbox.click();
        Assert.assertFalse(checkbox.isSelected(), "The checkbox " + checkbox.getAttribute("value") + " is left checked after unchecking.");
    }

    @Test(dataProvider = "getCSSForCheckbox")
    public void checkCheckboxViaCSS(String cSS) {
        WebElement checkbox = chromeDriver.findElement(By.cssSelector(cSS));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected(), "The checkbox " + checkbox.getAttribute("value") + " is left unchecked after checking.");
        checkbox.click();
        Assert.assertFalse(checkbox.isSelected(), "The checkbox " + checkbox.getAttribute("value") + " is left checked after unchecking.");
    }

}
