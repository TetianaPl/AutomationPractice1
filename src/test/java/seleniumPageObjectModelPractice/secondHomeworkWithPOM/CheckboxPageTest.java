package seleniumPageObjectModelPractice.secondHomeworkWithPOM;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckboxPageTest extends FunctionalTest {

        @Test
        public void checkCheckbox() {
            driver.get("https://formy-project.herokuapp.com/checkbox");

            CheckboxPage checkboxPage = new CheckboxPage(driver);
            assertTrue(checkboxPage.isInitialized());

            checkboxPage.clickCheckbox1();
            Assert.assertTrue(checkboxPage.isCheckbox1Selected(), "The checkbox 1 is left unchecked after checking.");
            checkboxPage.clickCheckbox1();
            Assert.assertFalse(checkboxPage.isCheckbox1Selected(), "The checkbox 1 is left checked after unchecking.");

            checkboxPage.clickCheckbox2();
            Assert.assertTrue(checkboxPage.isCheckbox2Selected(), "The checkbox 2 is left unchecked after checking.");
            checkboxPage.clickCheckbox2();
            Assert.assertFalse(checkboxPage.isCheckbox2Selected(), "The checkbox 2 is left checked after unchecking.");

            checkboxPage.clickCheckbox3();
            Assert.assertTrue(checkboxPage.isCheckbox3Selected(), "The checkbox 3 is left unchecked after checking.");
            checkboxPage.clickCheckbox3();
            Assert.assertFalse(checkboxPage.isCheckbox3Selected(), "The checkbox 3 is left checked after unchecking.");
        }
    }
