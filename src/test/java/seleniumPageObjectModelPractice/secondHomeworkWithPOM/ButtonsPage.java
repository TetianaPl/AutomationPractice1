package seleniumPageObjectModelPractice.secondHomeworkWithPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends PageObject {

    @FindBy(xpath = "//button[text()='Primary']")
    private WebElement primaryButton;

    @FindBy(xpath = "//button[text()='Success']")
    private WebElement successButton;

    @FindBy(xpath = "//button[text()='Info']")
    private WebElement infoButton;

    @FindBy(xpath = "//button[text()='Warning']")
    private WebElement warningButton;

    @FindBy(xpath = "//button[text()='Danger']")
    private WebElement dangerButton;

    @FindBy(xpath = "//button[text()='Link']")
    private WebElement linkButton;

    @FindBy(xpath = "//button[text()='Left']")
    private WebElement leftButton;

    @FindBy(xpath = "//button[text()='Middle']")
    private WebElement middleButton;

    @FindBy(xpath = "//button[text()='Right']")
    private WebElement rightButton;

    @FindBy(css = "div[aria-label='Button group with nested dropdown'] button:first-child")
    private WebElement button1;

    @FindBy(css = "div[aria-label='Button group with nested dropdown'] button:nth-child(2)")
    private WebElement button2;

    @FindBy(id = "btnGroupDrop1")
    private WebElement dropdownButton;

    @FindAll(@FindBy(xpath = "//div[@class='dropdown-menu show']/a[1]"))
    private WebElement dropdownLink1;

    @FindAll(@FindBy(xpath = "//div[@class='dropdown-menu show']/a[2]"))
    private WebElement dropdownLink2;

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return primaryButton.isDisplayed();
    }

    public void clickPrimary() {
        primaryButton.click();
    }

    public void clickSuccess() {
        successButton.click();
    }

    public void clickInfo() {
        infoButton.click();
    }

    public void clickWarning() {
        warningButton.click();
    }

    public void clickDanger() {
        dangerButton.click();
    }

    public void clickLink() {
        linkButton.click();
    }

    public void clickLeft() {
        leftButton.click();
    }

    public void clickMiddle() {
        middleButton.click();
    }

    public void clickRight() {
        rightButton.click();
    }

    public void clickButton1() {
        button1.click();
    }

    public void clickButton2() {
        button2.click();
    }

    public void clickDropdown() {
        dropdownButton.click();
    }

    public void clickDropdownLink1() {
        dropdownLink1.click();
    }

    public void clickDropdownLink2() {
        dropdownLink2.click();
    }
}

