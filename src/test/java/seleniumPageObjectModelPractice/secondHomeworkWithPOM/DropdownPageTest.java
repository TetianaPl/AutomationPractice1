package seleniumPageObjectModelPractice.secondHomeworkWithPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class DropdownPageTest extends FunctionalTest {
    private String baseUrl = "https://formy-project.herokuapp.com/dropdown";
    private DropdownPage dropdownPage;

    @BeforeMethod
    public void launchBrowser_CreatePage() {
        driver.get(baseUrl);
        dropdownPage = new DropdownPage(driver);
        assertTrue(dropdownPage.isInitialized());
        dropdownPage.clickDropdown();
    }

    @Test(priority = 1)
    public void checkPageAfterAutocompleteItemClicking() {
        dropdownPage.clickDropdownItemAutocomplete();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Autocomplete",
                "Test checks the page that opens after the 'Autocomplete' dropdown item was selected" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

    @Test(priority = 2)
    public void checkPageAfterButtonsItemClicking() {
        dropdownPage.clickDropdownItemButtons();
        List<WebElement> elements = driver.findElements(By.xpath("//button"));
        Assert.assertTrue(elements.size() != 12,
                "Test checks the page that opens after the 'Buttons' dropdown item was selected" +
                        ".\nThere are " + elements.size() + " buttons found on the page " + driver.getCurrentUrl() + "instead 12.");
    }

    @Test(priority = 3)
    public void checkPageAfterCheckboxItemClicking() {
        CheckboxPage checkboxPage = dropdownPage.clickDropdownItemCheckbox();
        assertTrue(checkboxPage.isInitialized());
        Assert.assertEquals(checkboxPage.pageTitle(), "Checkboxes",
                "Test checks the page that opens after the 'Checkbox' dropdown item was selected" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

    @Test(priority = 4)
    public void checkPageAfterDatepickerItemClicking() {
        dropdownPage.clickDropdownItemDatepicker();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Datepicker",
                "Test checks the page that opens after the 'Datepicker' dropdown item was selected" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

    @Test(priority = 5)
    public void checkPageAfterDragAndDropItemClicking() {
        dropdownPage.clickDropdownItemDragAndDrop();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Drag the image into the box",
                "Test checks the page that opens after the 'Drag and Drop' dropdown item was selected" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

    @Test(priority = 6)
    public void checkPageAfterDropdownItemClicking() {
        dropdownPage.clickDropdownItemDdropdown();
        assertTrue(dropdownPage.isInitialized());
        Assert.assertEquals(dropdownPage.pageTitle(), "Dropdown",
                "Test checks the page that opens after the 'Dropdown' dropdown item was selected" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

    @Test(priority = 7)
    public void checkPageAfterEnabledAndDisabledElementsItemClicking() {
        dropdownPage.clickDropdownItemEnabledAndDisabledElements();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Enabled and Disabled elements",
                "Test checks the page that opens after the 'Enabled and disabled elements' dropdown item was selected" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

    @Test(priority = 8)
    public void checkPageAfterFileUploadItemClicking() {
        dropdownPage.clickDropdownItemFileUpload();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "File upload",
                "Test checks the page that opens after the 'File Upload' dropdown item was selected" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

    @Test(priority = 9)
    public void checkPageAfterFileDownloadItemClicking() {
        dropdownPage.clickDropdownItemFileDownload();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "File download",
                "Test checks the page that opens after the 'File Download' dropdown item was selected" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

    @Test(priority = 10)
    public void checkPageAfterKeyAndMousePressItemClicking() {
        dropdownPage.clickDropdownItemKeyAndMousePress();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Keyboard and Mouse Input",
                "Test checks the page that opens after the 'Key and Mouse Press' dropdown item was selected" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

    @Test(priority = 11)
    public void checkPageAfterModalItemClicking() {
        dropdownPage.clickDropdownItemModal();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Modal",
                "Test checks the page that opens after the 'Modal' dropdown item was selected" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

    @Test(priority = 12)
    public void checkPageAfterPageScrollItemClicking() {
        dropdownPage.clickDropdownItemPageScroll();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Large page content",
                "Test checks the page that opens after the 'Page Scroll' dropdown item was selected" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

    @Test(priority = 13)
    public void checkPageAfterRadioButtonItemClicking() {
        dropdownPage.clickDropdownItemRadioButton();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Radio buttons",
                "Test checks the page that opens after the 'Radio Button' dropdown item was selected" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

    @Test(priority = 14)
    public void checkPageAfterSwitchWindowItemClicking() {
        dropdownPage.clickDropdownItemSwitchWindow();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Switch Window",
                "Test checks the page that opens after the 'Switch Window' dropdown item was selected" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

    @Test(priority = 15)
    public void checkPageAfterCompleteWebFormItemClicking() {
        dropdownPage.clickDropdownItemCompleteWebForm();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Complete Web Form",
                "Test checks the page that opens after the 'Complete Web Form' dropdown item was selected" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

}
