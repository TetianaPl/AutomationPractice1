package seleniumPageObjectModelPractice.secondHomeworkWithPOM;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FormPageTest extends FunctionalTest {
    private String baseUrl = "https://formy-project.herokuapp.com/form";
    private FormPage formPage;

    @BeforeClass
    public void launchBrowser_CreatePage() {
        driver.get(baseUrl);
        formPage = new FormPage(driver);
        assertTrue(formPage.isInitialized());
    }

    @Test
    public void checkFirstNameFilling() {
        formPage.setFirstName("Ivan");
        formPage.setLastName("Ivanov");
        formPage.setJobTitle("Student");
        formPage.selectHighSchoolEducation();
        formPage.selectHighSchoolEducation();
        formPage.selectCollegeEducation();
        formPage.selectCollegeEducation();
        formPage.selectSchoolEducation();
        formPage.selectSchoolEducation();
        formPage.selectMaleSex();
        formPage.selectMaleSex();
        formPage.selectFemaleSex();
        formPage.selectFemaleSex();
        formPage.selectUnknownSex();
        formPage.selectUnknownSex();
        formPage.setExperience(1);
        formPage.setDate("02/12/2020");
        formPage.clickSubmit();

        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Thanks for submitting your form",
                "Test checks the page that opens after the 'Submit' button clicking" +
                        ".\nThe expected headline not found on the page " + driver.getCurrentUrl());
    }

}
