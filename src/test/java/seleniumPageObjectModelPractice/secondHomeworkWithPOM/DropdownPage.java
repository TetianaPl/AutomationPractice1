package seleniumPageObjectModelPractice.secondHomeworkWithPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DropdownPage extends PageObject {

    @FindBy(tagName = "h1")
    private WebElement pageTitle;

    @FindBy(id = "dropdownMenuButton")
    private WebElement dropdownButton;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[1]")
    private WebElement dropdownItemAutocomplete;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[2]")
    private WebElement dropdownItemButtons;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[3]")
    private WebElement dropdownItemCheckbox;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[4]")
    private WebElement dropdownItemDatepicker;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[5]")
    private WebElement dropdownItemDragAndDrop;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[6]")
    private WebElement dropdownItemDdropdown;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[7]")
    private WebElement dropdownItemEnabledAndDisabledElements;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[8]")
    private WebElement dropdownItemFileUpload;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[9]")
    private WebElement dropdownItemFileDownload;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[10]")
    private WebElement dropdownItemKeyAndMousePress;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[11]")
    private WebElement dropdownItemModal;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[12]")
    private WebElement dropdownItemPageScroll;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[13]")
    private WebElement dropdownItemRadioButton;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[14]")
    private WebElement dropdownItemSwitchWindow;

    @FindBy(xpath = "//div[@class='dropdown-menu show']/a[15]")
    private WebElement dropdownItemCompleteWebForm;

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return dropdownButton.isDisplayed();
    }

    public String pageTitle() {
        return pageTitle.getText();
    }

    public void clickDropdown() {
        dropdownButton.click();
    }

    public PageObject clickDropdownItemAutocomplete() {
        dropdownItemAutocomplete.click();
        return new PageObject(driver);
    }

    public ButtonsPage clickDropdownItemButtons() {
        dropdownItemButtons.click();
        return new ButtonsPage(driver);
    }

    public CheckboxPage clickDropdownItemCheckbox() {
        dropdownItemCheckbox.click();
        return new CheckboxPage(driver);
    }

    public PageObject clickDropdownItemDatepicker() {
        dropdownItemDatepicker.click();
        return new PageObject(driver);
    }

    public PageObject clickDropdownItemDragAndDrop() {
        dropdownItemDragAndDrop.click();
        return new PageObject(driver);
    }

    public DropdownPage clickDropdownItemDdropdown() {
        dropdownItemDdropdown.click();
        return new DropdownPage(driver);
    }

    public PageObject clickDropdownItemEnabledAndDisabledElements() {
        dropdownItemEnabledAndDisabledElements.click();
        return new PageObject(driver);
    }

    public PageObject clickDropdownItemFileUpload() {
        dropdownItemFileUpload.click();
        return new PageObject(driver);
    }

    public PageObject clickDropdownItemFileDownload() {
        dropdownItemFileDownload.click();
        return new PageObject(driver);
    }

    public PageObject clickDropdownItemKeyAndMousePress() {
        dropdownItemKeyAndMousePress.click();
        return new PageObject(driver);
    }

    public PageObject clickDropdownItemModal() {
        dropdownItemModal.click();
        return new PageObject(driver);
    }

    public PageObject clickDropdownItemPageScroll() {
        dropdownItemPageScroll.click();
        return new PageObject(driver);
    }

    public PageObject clickDropdownItemRadioButton() {
        dropdownItemRadioButton.click();
        return new PageObject(driver);
    }

    public PageObject clickDropdownItemSwitchWindow() {
        dropdownItemSwitchWindow.click();
        return new PageObject(driver);
    }

    public PageObject clickDropdownItemCompleteWebForm() {
        dropdownItemCompleteWebForm.click();
        return new PageObject(driver);
    }

}

