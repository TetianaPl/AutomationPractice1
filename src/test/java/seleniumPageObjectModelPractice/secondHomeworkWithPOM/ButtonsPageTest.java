package seleniumPageObjectModelPractice.secondHomeworkWithPOM;

import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class ButtonsPageTest extends FunctionalTest {
    private String baseUrl = "https://formy-project.herokuapp.com/buttons";
    private ButtonsPage buttonsPage;

    @BeforeClass
    public void launchBrowser_CreatePage() {
        driver.get(baseUrl);
        buttonsPage = new ButtonsPage(driver);
        assertTrue(buttonsPage.isInitialized());
    }

    @Test(priority = 1)
    public void checkPrimaryButton() {
        buttonsPage.clickPrimary();
    }

    @Test(priority = 2)
    public void checkSuccessButton() {
        buttonsPage.clickSuccess();
    }

    @Test(priority = 3)
    public void checkInfoButton() {
        buttonsPage.clickInfo();
    }

    @Test(priority = 4)
    public void checkWarningButton() {
        buttonsPage.clickWarning();
    }

    @Test(priority = 5)
    public void checkDangerButton() {
        buttonsPage.clickDanger();
    }

    @Test(priority = 6)
    public void checkLinkButton() {
        buttonsPage.clickLink();
    }

    @Test(priority = 7)
    public void checkLeftButton() {
        buttonsPage.clickLeft();
    }

    @Test(priority = 8)
    public void checkMiddleButton() {
        buttonsPage.clickMiddle();
    }

    @Test(priority = 9)
    public void checkRightButton() {
        buttonsPage.clickRight();
    }

    @Test(priority = 10)
    public void checkButton1() {
        buttonsPage.clickButton1();
    }

    @Test(priority = 11)
    public void checkButton2() {
        buttonsPage.clickButton2();
    }

    @Test(priority = 12)
    public void checkDropdown() {
        buttonsPage.clickDropdown();
        buttonsPage.clickDropdownLink1();
        buttonsPage.clickDropdown();
        buttonsPage.clickDropdownLink2();
    }
}

