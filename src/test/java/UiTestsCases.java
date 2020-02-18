import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UiTestsCases {

    @Test
    public void verifyString() {
        //Прописала в переменной среды
//      System.setProperty("webdriver.chrome.driver", "C:\\Drivers");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.youtube.com/");
    }
}
