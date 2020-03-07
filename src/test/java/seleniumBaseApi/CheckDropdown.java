package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class CheckDropdown {

    private WebDriver chromeDriver;
    private String baseUrl = "https://formy-project.herokuapp.com/dropdown";
    private WebDriverWait wait;
    private WebElement dropdownButton, dropdownItem;

    @BeforeClass
    public void launchBrowser() {
        chromeDriver = new ChromeDriver();
        wait = new WebDriverWait(chromeDriver, 15);
    }

    @BeforeMethod
    public void NavigateToBaseUrl_ClickDropdown() {
        chromeDriver.navigate().to(baseUrl);
        dropdownButton = chromeDriver.findElement(By.id("dropdownMenuButton"));
        dropdownButton.click();
    }

    @AfterClass
    public void terminateBrowser() {
        chromeDriver.quit();
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

        dropdownItem = chromeDriver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[" + i + "]"));
        String itemName = dropdownItem.getText();
        dropdownItem.click();
        wait.until(stalenessOf(dropdownItem));
//        wait.until(visibilityOfElementLocated(By.tagName("h1")));

        Assert.assertEquals(chromeDriver.findElement(By.tagName("h1")).getText(), pageVerification, "Test checks the page that opened after the '" + itemName + "' item in the dropdown was selected on the page '" + baseUrl +
                "'.\nThe headline '" + pageVerification + "' not found on the page " + chromeDriver.getCurrentUrl());
    }

    @Test
    public void checkSwitchToButtonsPage() {

        dropdownItem = chromeDriver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[2]"));
        dropdownItem.click();
        wait.until(stalenessOf(dropdownItem));
//        wait.until(visibilityOfElementLocated(By.xpath("//button")));

        List<WebElement> buttons = chromeDriver.findElements(By.xpath("//button"));

        Assert.assertTrue(buttons.size() != 12,
                "Test checks the page that opens after the 'Buttons' item in the dropdown was selected on the page " + baseUrl +
                        ".\nThere are " + buttons.size() + " buttons found on the page " + chromeDriver.getCurrentUrl() + "instead 12.");
    }

}

