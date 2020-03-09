package seleniumPageObjectModelPractice.secondHomeworkWithPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FormPage extends PageObject {

    @FindBy(tagName = "h1")
    private WebElement pageTitle;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "job-title")
    private WebElement jobTitle;

    @FindBy(id = "radio-button-1")
    private WebElement educationHighSchool;

    @FindBy(id = "radio-button-2")
    private WebElement educationCollege;

    @FindBy(id = "radio-button-3")
    private WebElement educationSchool;

    @FindBy(id = "checkbox-1")
    private WebElement sexMale;

    @FindBy(id = "checkbox-2")
    private WebElement sexFemale;

    @FindBy(id = "checkbox-3")
    private WebElement sexUnknown;

    @FindBy(id = "select-menu")
    private WebElement experience;

    @FindBy(id = "datepicker")
    private WebElement date;

    @FindBy(xpath = "//a[text()='Submit']")
    private WebElement submitButton;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return firstName.isDisplayed();
    }

    public String pageTitle() {
        return pageTitle.getText();
    }

    public void setFirstName(String userFirstName) {
        firstName.clear();
        firstName.sendKeys(userFirstName);
    }

    public void setLastName(String userLastName) {
        lastName.clear();
        lastName.sendKeys(userLastName);
    }

    public void setJobTitle(String userJobTitle) {
        jobTitle.clear();
        jobTitle.sendKeys(userJobTitle);
    }

    public void selectHighSchoolEducation() {
        educationHighSchool.click();
    }

    public boolean isHighSchoolEducationSelected() {
        return educationHighSchool.isSelected();
    }

    public void selectCollegeEducation() {
        educationCollege.click();
    }

    public boolean isCollegeEducationSelected() {
        return educationCollege.isSelected();
    }

    public void selectSchoolEducation() {
        educationSchool.click();
    }

    public boolean isSchoolEducationSelected() {
        return educationSchool.isSelected();
    }

    public void selectMaleSex() {
        sexMale.click();
    }

    public void selectFemaleSex() {
        sexFemale.click();
    }

    public void selectUnknownSex() {
        sexUnknown.click();
    }

    public boolean isMaleSexSelected() {
        return sexMale.isSelected();
    }

    public boolean isFemaleSexSelected() {
        return sexFemale.isSelected();
    }

    public boolean isUnknownSexSelected() {
        return sexUnknown.isSelected();
    }

    public void setExperience(int userExperience) {
        Select item = new Select(experience);
        item.selectByIndex(userExperience);
    }

    public void setDate(String userData) {
        date.clear();
        date.sendKeys(userData);
    }

    public PageObject clickSubmit() {
        submitButton.click();
        return new PageObject(driver);
    }

}
