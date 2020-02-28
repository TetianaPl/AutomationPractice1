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

import java.util.List;

public class CheckDropdown {

    public WebDriver chromeDriver;
    public String baseUrl = "https://formy-project.herokuapp.com/dropdown";


    @BeforeTest
    public void launchBrowser() {
        chromeDriver = new ChromeDriver();
    }

    @AfterTest
    public void terminateBrowser() {
        chromeDriver.close();
    }

    @DataProvider(name = "getValidationConditions")
    public Object[][] getValidationConditions() {
        return new Object[][]{
                {1, "Autocomplete"},
                {3, "Checkboxes"},
                {4, "Datepicker"},
                {5, "Drag the image into the box"},
                {7, "Enabled and Disabled elements"},
                {8, "File upload"},
                {9, "File download"},
                {10, "Keyboard and Mouse Input"},
                {11, "Modal"},
                {12, "Large page content"},
                {13, "Radio buttons"},
                {14, "Switch Window"},
                {15, "Complete Web Form"}
        };
    }

    @Test(dataProvider = "getValidationConditions")
    public void checkDropdown(int i, String pageVerification) {
        chromeDriver.navigate().to(baseUrl);
        WebElement element = chromeDriver.findElement(By.id("dropdownMenuButton"));
        element.click();
        element = chromeDriver.findElement(By.xpath("//div[@class=\"dropdown-menu show\"]/a[" + i + "]"));
        String itemName = element.getText();
        element.click();
        chromeDriver.navigate().refresh();
        element = chromeDriver.findElement(By.tagName("h1"));
        Assert.assertEquals(element.getText(), pageVerification, "Test checks the page that opened after the \"" + itemName + "\" item in the dropdown was selected on the page \"" + baseUrl +
                "\".\nThe headline \"" + pageVerification + "\" not found on the page " + chromeDriver.getCurrentUrl());

//        Assert.assertTrue(chromeDriver.findElement(By.xpath("//h1[text()=\"" + pageVerification + "\"]")).isDisplayed(), "The headline \"" + pageVerification + "\" not found on the page " + chromeDriver.getCurrentUrl());
    }


    @Test
    public void checkDropdownButtons() {
        chromeDriver.navigate().to(baseUrl);
        WebElement element = chromeDriver.findElement(By.id("dropdownMenuButton"));
        element.click();
        element = chromeDriver.findElement(By.xpath("//div[@class=\"dropdown-menu show\"]/a[2]"));
        element.click();
        chromeDriver.navigate().refresh();
        List<WebElement> elements = chromeDriver.findElements(By.xpath("//button"));
        Assert.assertTrue(elements.size() > 5, "Test checks the page that opens after the \"Buttons\" item in the dropdown was selected on the page " + baseUrl +
                ".\nThere is only " + elements.size() + " buttons found on the page " + chromeDriver.getCurrentUrl());
    }

}

