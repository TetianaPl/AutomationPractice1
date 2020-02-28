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

public class CheckSpamBBC {

    public WebDriver chromeDriver;
    public String baseUrl = "https://www.bbc.com";
    public String url;

    @BeforeTest
    public void launchBrowser() {
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to(baseUrl);
        WebElement element = chromeDriver.findElement(By.xpath("//div[@id=\"orb-nav-links\"]//a[text()=\"News\"]"));
        element.click();
//        chromeDriver.navigate().to(chromeDriver.getCurrentUrl());
        element = chromeDriver.findElement(By.xpath("//button[@class=\"nw-c-nav__wide-morebutton nw-c-nav__wide-morebutton__closed\"]"));
        element.click();
        element = chromeDriver.findElement(By.xpath("//li[contains(@class, \"nw-c-nav__wide-menuitem-container\")]//span[text()=\"Have Your Say\"]"));
        element.click();
        element = chromeDriver.findElement(By.xpath("//h3[text()=\"How to share with BBC News\"]/.."));
        element.click();
        url = chromeDriver.getCurrentUrl();
    }

    @AfterTest
    public void terminateBrowser() {
        chromeDriver.close();
    }

    @DataProvider(name = "getValidDataForMailToBBC")
    public Object[][] getValidDataForMailToBBC() {
        return new Object[][]{
                {"Some Name", "someaddress@mail.ru", "Kyiv, Ukraine", "+380-95-123-45-67",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus sed porttitor mauris. Sed accumsan sit amet lectus id porttitor. Nulla nibh ante, tempor nec ultricies a, malesuada et leo. Praesent non pretium nulla. Ut cursus ligula ac lorem pretium mollis. Cras at varius erat. Vestibulum lectus tellus, dignissim et lorem non, luctus lobortis turpis. Nulla at arcu efficitur, placerat velit vitae, dignissim arcu. Nunc bibendum facilisis quam, ut molestie risus vestibulum id. Donec commodo, metus quis fermentum fringilla, ipsum diam lacinia lectus, sed interdum enim purus eu enim. Curabitur lorem eros, ultricies luctus ultrices in, laoreet et nisi. Donec fringilla.",
                        "with all valid data, comment is 100 words"
                }
        };
    }

    @DataProvider(name = "getInvalidDataForMailToBBC")
    public Object[][] getInvalidDataForMailToBBC() {
        return new Object[][]{
//                {"Some Name", "someaddress@mail.ru", "Kyiv, Ukraine", "+380-95-123-45-67",
//                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus eu feugiat mauris. Cras quis libero elementum, finibus orci nec, finibus ante. Duis sit amet augue nec justo bibendum commodo. Nam sit amet imperdiet tortor. Donec vel hendrerit elit. Sed ornare orci vel nulla pellentesque, sed pellentesque massa sagittis. Aliquam eleifend maximus lacinia. Nullam nec convallis ligula. Ut ut diam sagittis, porttitor augue at, laoreet dolor. Ut non quam non velit vehicula congue. Suspendisse tincidunt cursus neque. Etiam vitae ligula pulvinar, molestie augue efficitur, fringilla arcu. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quis ultricies tellus, vitae facilisis nisl." +
//                                "Maecenas euismod sem ac volutpat ullamcorper. Sed imperdiet vitae ligula ac aliquam. Donec eget lacus id nisl placerat eleifend ornare sed nisi. Vestibulum euismod elementum facilisis. Nunc consequat mi ac facilisis luctus. Cras suscipit pharetra sem, sed sodales nisi mollis sit amet. Quisque ornare vel massa eget tincidunt. Curabitur varius elit ut ex elementum blandit. Suspendisse gravida, lectus non iaculis viverra, quam felis iaculis turpis, non tempus felis erat in turpis. Curabitur posuere purus augue, sit amet varius ligula feugiat at. Aenean pharetra quam eu nisi lobortis, vitae condimentum velit convallis. Integer vestibulum consectetur blandit. Proin posuere nunc vel lacus.",
//                        "with 200 words comment"
//                }, //Data were confirmed!
                {"Some Name", "", "Kyiv", "+380-95-123-45-67",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus sed porttitor mauris. Sed accumsan sit amet lectus id porttitor. Nulla nibh ante, tempor nec ultricies a, malesuada et leo. Praesent non pretium nulla. Ut cursus ligula ac lorem pretium mollis. Cras at varius erat. Vestibulum lectus tellus, dignissim et lorem non, luctus lobortis turpis. Nulla at arcu efficitur, placerat velit vitae, dignissim arcu. Nunc bibendum facilisis quam, ut molestie risus vestibulum id. Donec commodo, metus quis fermentum fringilla, ipsum diam lacinia lectus, sed interdum enim purus eu enim. Curabitur lorem eros, ultricies luctus ultrices in, laoreet et nisi. Donec fringilla.",
                        "without email, comment is 100 words"
                },
                {"Some Name", "someaddress@mail.ru", "Kyiv", "+380-95-123-45-67",
                        "",
                        "with name, without comment"
                } //Data with null were confirmed!
        };
    }

    @Test(dataProvider = "getValidDataForMailToBBC")
    public void checkSendMailHappyPath(String name, String email, String town, String phone, String comment, String description) {
        chromeDriver.navigate().to(url);
        WebElement element = chromeDriver.findElement(By.id("fullName"));
        element.sendKeys(name);
        element = chromeDriver.findElement(By.id("email"));
        element.sendKeys(email);
        element = chromeDriver.findElement(By.id("town"));
        element.sendKeys(town);
        element = chromeDriver.findElement(By.id("phone"));
        element.sendKeys(phone);
        element = chromeDriver.findElement(By.id("message"));
        element.sendKeys(comment);
        element = chromeDriver.findElement(By.id("submit"));
        String url = chromeDriver.getCurrentUrl();
//        element.click();
        Assert.assertNotEquals(url, chromeDriver.getCurrentUrl(), "Test checks sending the message to BBC " + description +
                ".\nThe url does not changed after submitting.");
    }

    @Test(dataProvider = "getInvalidDataForMailToBBC")
    public void checkSendMailUnhappyPath(String name, String email, String town, String phone, String comment, String description) {
        chromeDriver.navigate().to(url);
        WebElement element = chromeDriver.findElement(By.id("fullName"));
        element.sendKeys(name);
        element = chromeDriver.findElement(By.id("email"));
        element.sendKeys(email);
        element = chromeDriver.findElement(By.id("town"));
        element.sendKeys(town);
        element = chromeDriver.findElement(By.id("phone"));
        element.sendKeys(phone);
        element = chromeDriver.findElement(By.id("message"));
        element.sendKeys(comment);
        element = chromeDriver.findElement(By.id("submit"));
        String url = chromeDriver.getCurrentUrl();
        element.click();
        Assert.assertEquals(url, chromeDriver.getCurrentUrl(), "Test checks sending the message to BBC with invalid data: " + description +
                ".\nThe data were confirmed!");
    }

}
