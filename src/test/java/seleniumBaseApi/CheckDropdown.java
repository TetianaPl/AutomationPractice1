package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckDropdown {

    public WebDriver chromeDriver;
    public String baseUrl = "https://formy-project.herokuapp.com/dropdown";


    @BeforeTest
    public void launchBrowser() {
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to(baseUrl);
    }

    @AfterTest
    public void terminateBrowser() {
        chromeDriver.close();
    }

    @Test
    public void checkDropdown() {
        WebElement element;
        for (int i = 1; i <= 15; i++) {
            element = chromeDriver.findElement(By.id("dropdownMenuButton"));
            element.click();
            element = chromeDriver.findElement(By.cssSelector("div[class=\"dropdown-menu show\"] a:nth-child(" + i + ")"));
            element.click();
            chromeDriver.navigate().to(baseUrl);
        }
    }
}
