package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class CheckButtons {
    private WebDriver chromeDriver;
    private String baseUrl = "https://formy-project.herokuapp.com/buttons";

    @BeforeClass
    public void launchBrowserAndNavigateToBaseUrl() {
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to(baseUrl);
    }

    @AfterClass
    public void terminateBrowser() {
        chromeDriver.quit();
    }

    @Test(priority = 1)
    public void checkPrimaryButton() {
        chromeDriver.findElement(By.xpath("//button[text()='Primary']")).click();
    }

    @Test(priority = 2)
    public void checkSuccessButton() {
        chromeDriver.findElement(By.xpath("//button[text()='Success']")).click();
    }

    @Test(priority = 3)
    public void checkInfoButton() {
        chromeDriver.findElement(By.xpath("//button[text()='Info']")).click();
    }

    @Test(priority = 4)
    public void checkWarningButton() {
        chromeDriver.findElement(By.xpath("//button[text()='Warning']")).click();
    }

    @Test(priority = 5)
    public void checkDangerButton() {
        chromeDriver.findElement(By.xpath("//button[text()='Danger']")).click();
    }

    @Test(priority = 6)
    public void checkLinkButton() {
        chromeDriver.findElement(By.xpath("//button[text()='Link']")).click();
    }

    @Test(priority = 7)
    public void checkLeftButton() {
        chromeDriver.findElement(By.xpath("//button[text()='Left']")).click();
    }

    @Test(priority = 8)
    public void checkMiddleButton() {
        chromeDriver.findElement(By.xpath("//button[text()='Middle']")).click();
    }

    @Test(priority = 9)
    public void checkRightButton() {
        chromeDriver.findElement(By.xpath("//button[text()='Right']")).click();
    }

    @Test(priority = 10)
    public void check1Button() {
        chromeDriver.findElement(By.cssSelector("div[aria-label='Button group with nested dropdown'] button:first-child")).click();
    }

    @Test(priority = 11)
    public void check2Button() {
        chromeDriver.findElement(By.cssSelector("div[aria-label='Button group with nested dropdown'] button:nth-child(2)")).click();
    }

    @Test(priority = 12)
    public void checkDropdownButton() {
        chromeDriver.findElement(By.id("btnGroupDrop1")).click();
        chromeDriver.findElement(By.linkText("Dropdown link 1")).click();
        chromeDriver.navigate().refresh();
        chromeDriver.findElement(By.id("btnGroupDrop1")).click();
        chromeDriver.findElement(By.linkText("Dropdown link 2")).click();
    }

}
