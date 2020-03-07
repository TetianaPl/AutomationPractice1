package tasksFromGrowVariant2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class CheckArticlesTitles {
    private WebDriver chromeDriver;
    private String baseUrl = "https://www.bbc.com";
    //    private List<WebElement> elements;
    private WebDriverWait wait;

    @BeforeClass
    public void launchBrowser_GoToNews() {
        chromeDriver = new ChromeDriver();
        wait = new WebDriverWait(chromeDriver, 15);
        chromeDriver.navigate().to(baseUrl);
        WebElement newsMenuItem = chromeDriver.findElement(By.xpath("//div[@id=\"orb-nav-links\"]//a[text()=\"News\"]"));
        newsMenuItem.click();
        wait.until(stalenessOf(newsMenuItem));
//        List<WebElement> secondaryArticlesTitles = chromeDriver.findElements(By.xpath("//div[contains(@class,\"top-stories__secondary-item\")]/div[1]//h3"));
    }

    @AfterClass
    public void terminateBrowser() {
        chromeDriver.quit();
    }

    @DataProvider(name = "getHeadlineArticleName")
    public Object[] getHeadline() {
        return new Object[]{
                "Markets fall as virus spreads around the world"
        };
    }

    @DataProvider(name = "getSecondaryArticlesNames")
    public Object[][] getSecondaryArticleTitle() {

        List<WebElement> secondaryArticlesTitles = chromeDriver.findElements(By.xpath("//div[contains(@class,\"top-stories__secondary-item\")]/div[1]//h3"));

        return new Object[][]{
                {secondaryArticlesTitles.get(0), "Attack in Syria kills 33 Turkish soldiers"},
                {secondaryArticlesTitles.get(1), "BP worker sacked over Hitler parody wins job back"},
                {secondaryArticlesTitles.get(2), "Eight-year ban for Chinese triple Olympic champion"},
                {secondaryArticlesTitles.get(3), "Searching for loved ones under the ashes"},
                {secondaryArticlesTitles.get(4), "Wine alert after woman dies from sip of MDMA drug"}
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
        WebElement headlineArticlesTitle = chromeDriver.findElement(By.xpath("//div[@data-entityid=\"container-top-stories#1\"]/div[1]//h3[contains(@class,\"promo-heading__title\")]"));
        String headline = headlineArticlesTitle.getText();
        Assert.assertEquals(headline, controlHeadline, "Test checks the headline article title on the page " + chromeDriver.getCurrentUrl() +
                ".\nThe name of the headline article is '" + headline + "'. It dismatchs to '" + controlHeadline + "'.");
    }

    @Test(priority = 2, dataProvider = "getSecondaryArticlesNames")
    public void checkSecondaryTitles(WebElement secondaryArticlesTitle, String controlHeadline) {
        String headline = secondaryArticlesTitle.getText();
        Assert.assertEquals(headline, controlHeadline, "Test checks the secondary articles titles on the page " + chromeDriver.getCurrentUrl() +
                ".\nThe name of the article is '" + headline + "'. It dismatchs to '" + controlHeadline + ".\n");
    }

    @Test(priority = 3, dataProvider = "getArticleForSearchName")
    public void checkSearch(String controlHeadline) {

        String wordForSearch = chromeDriver.findElement(By.xpath("//div[@data-entityid='container-top-stories#1']/div[1]//a[@aria-label]/span")).getText();
        chromeDriver.findElement(By.xpath("//input[@id='orb-search-q']")).sendKeys(wordForSearch);
        WebElement searchButton = chromeDriver.findElement(By.xpath("//button[@id='orb-search-button']"));
        searchButton.click();
        wait.until(stalenessOf(searchButton));
        WebElement firstArticleInSearchResults = chromeDriver.findElement(By.xpath("//li[@data-result-number='1']//h1"));
        String firstTitle = firstArticleInSearchResults.getText();
        Assert.assertEquals(firstTitle, controlHeadline, "Test checks the first article title in search results for '" + wordForSearch + "' on the www.bbc.com/news." +
                "\nThe name of the first article is '" + firstTitle + "'. It dismatchs to '" + controlHeadline + "'.");
    }

}

