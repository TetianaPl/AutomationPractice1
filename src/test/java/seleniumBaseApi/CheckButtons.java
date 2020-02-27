package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckButtons {
    public WebDriver chromeDriver;
    public String baseUrl = "https://formy-project.herokuapp.com/buttons";

    @BeforeTest
    public void launchBrowser() {
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to(baseUrl);
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void terminateBrowser() {
        chromeDriver.close();
    }

    @Test(priority = 1)
    public void checkPrimaryButton() {
        WebElement element = chromeDriver.findElement(By.xpath("//button[text()=\"Primary\"]"));
        element.click();
    }

    @Test(priority = 2)
    public void checkSuccessButton() {
        WebElement element = chromeDriver.findElement(By.xpath("//button[text()=\"Success\"]"));
        element.click();
    }

    @Test(priority = 3)
    public void checkInfoButton() {
        WebElement element = chromeDriver.findElement(By.xpath("//button[text()=\"Info\"]"));
        element.click();
    }

    @Test(priority = 4)
    public void checkWarningButton() {
        WebElement element = chromeDriver.findElement(By.xpath("//button[text()=\"Warning\"]"));
        element.click();
    }

    @Test(priority = 5)
    public void checkDangerButton() {
        WebElement element = chromeDriver.findElement(By.xpath("//button[text()=\"Danger\"]"));
        element.click();
    }

    @Test(priority = 6)
    public void checkLinkButton() {
        WebElement element = chromeDriver.findElement(By.xpath("//button[text()=\"Link\"]"));
        element.click();
    }

    @Test(priority = 7)
    public void checkLeftButton() {
        WebElement element = chromeDriver.findElement(By.xpath("//button[text()=\"Left\"]"));
        element.click();
    }

    @Test(priority = 8)
    public void checkMiddleButton() {
        WebElement element = chromeDriver.findElement(By.xpath("//button[text()=\"Middle\"]"));
        element.click();
    }

    @Test(priority = 9)
    public void checkRightButton() {
        WebElement element = chromeDriver.findElement(By.xpath("//button[text()=\"Right\"]"));
        element.click();
    }

    @Test(priority = 10)
    public void check1Button() {
        WebElement element = chromeDriver.findElement(By.cssSelector("div[aria-label=\"Button group with nested dropdown\"] button:first-child"));
        element.click();
    }

    @Test(priority = 11)
    public void check2Button() {
        WebElement element = chromeDriver.findElement(By.cssSelector("div[aria-label=\"Button group with nested dropdown\"] button:nth-child(2)"));
        element.click();
    }

    @Test(priority = 12)
    public void checkDropdownButton() {
        WebElement element = chromeDriver.findElement(By.id("btnGroupDrop1"));
        element.click();
        element = chromeDriver.findElement(By.linkText("Dropdown link 1"));
        element.click();
        element = chromeDriver.findElement(By.id("btnGroupDrop1"));
        element.click();
        element = chromeDriver.findElement(By.linkText("Dropdown link 2"));
        element.click();
    }

}
