package seleniumPageObjectModelPractice.secondHomeworkWithPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxPage extends PageObject {

    @FindBy(tagName = "h1")
    private WebElement pageTitle;

    @FindBy(id = "checkbox-1")
    private WebElement checkbox1;

    @FindBy(id = "checkbox-2")
    private WebElement checkbox2;

    @FindBy(id = "checkbox-3")
    private WebElement checkbox3;

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return checkbox1.isDisplayed();
    }

    public String pageTitle() {
        return pageTitle.getText();
    }

    public void clickCheckbox1() {
        checkbox1.click();
    }

    public void clickCheckbox2() {
        checkbox2.click();
    }

    public void clickCheckbox3() {
        checkbox3.click();
    }

    public boolean isCheckbox1Selected() {
        return checkbox1.isSelected();
    }

    public boolean isCheckbox2Selected() {
        return checkbox2.isSelected();
    }

    public boolean isCheckbox3Selected() {
        return checkbox3.isSelected();
    }
}

