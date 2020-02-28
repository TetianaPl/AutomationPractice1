package tasksFromGrowVariant2;

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

public class CheckArticlesTitles {
    public WebDriver chromeDriver;
    public String baseUrl = "https://www.bbc.com";
    public List<WebElement> elements;

    @BeforeTest
    public void launchBrowser() {
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to(baseUrl);
        WebElement element = chromeDriver.findElement(By.xpath("//div[@id=\"orb-nav-links\"]//a[text()=\"News\"]"));
        element.click();
        elements = chromeDriver.findElements(By.xpath("//div[contains(@class,\"top-stories__secondary-item\")]/div[1]//h3"));
    }

    @AfterTest
    public void terminateBrowser() {
        chromeDriver.close();
    }

    @DataProvider(name = "getHeadlineArticleName")
    public Object[] getHeadline() {
        return new Object[]{
                "Markets fall as virus spreads around the world"
        };
    }

    @DataProvider(name = "getSecondaryArticlesNames")
    public Object[][] getSecondaryArticleTitle() {
        return new Object[][]{
                {elements.get(0), "Attack in Syria kills 33 Turkish soldiers"},
                {elements.get(1), "BP worker sacked over Hitler parody wins job back"},
                {elements.get(2), "Eight-year ban for Chinese triple Olympic champion"},
                {elements.get(3), "Searching for loved ones under the ashes"},
                {elements.get(4), "Wine alert after woman dies from sip of MDMA drug"}
        };
    }

    @DataProvider(name = "getArticleForSearchName")
    public Object[] getArticleTitle() {
        return new Object[]{
                "World's End: World's End"
        };
    }

    @Test(priority = 1, dataProvider = "getHeadlineArticleName")
    public void checkHeadline(String controlHeadline) {
        WebElement element = chromeDriver.findElement(By.xpath("//div[@data-entityid=\"container-top-stories#1\"]/div[1]//h3[contains(@class,\"promo-heading__title\")]"));
        String headline = element.getText();
        Assert.assertEquals(headline, controlHeadline, "Test checks the headline article title on the page " + chromeDriver.getCurrentUrl() +
                ".\nThe name of the headline article is \"" + headline + "\". It dismatchs to \"" + controlHeadline + "\".");
    }

    @Test(priority = 2, dataProvider = "getSecondaryArticlesNames")
    public void checkSecondaryTitles(WebElement element, String controlHeadline) {
        String headline = element.getText();
        Assert.assertEquals(headline, controlHeadline, "Test checks the secondary articles titles on the page " + chromeDriver.getCurrentUrl() +
                ".\nThe name of the article is \"" + headline + "\". It dismatchs to \"" + controlHeadline + ".\n");
    }

    @Test(priority = 3, dataProvider = "getArticleForSearchName")
    public void checkSearch(String controlHeadline) {

        WebElement element = chromeDriver.findElement(By.xpath("//div[@data-entityid=\"container-top-stories#1\"]/div[1]//a[@aria-label]/span"));
        String wordRorSearch = element.getText();
        element = chromeDriver.findElement(By.xpath("//input[@id=\"orb-search-q\"]"));
        element.sendKeys(wordRorSearch);
        element = chromeDriver.findElement(By.xpath("//button[@id=\"orb-search-button\"]"));
        element.click();
        element = chromeDriver.findElement(By.xpath("//li[@data-result-number=\"1\"]//h1"));
        String firstTitle = element.getText();
        Assert.assertEquals(firstTitle, controlHeadline, "Test checks the first article title in search results for \"" + wordRorSearch + "\" on the www.bbc.com/news." +
                "\nThe name of the first article is \"" + firstTitle + "\". It dismatchs to \"" + controlHeadline + "\".");
    }

}

