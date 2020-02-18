import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CheckAssertions {

    @Test
    public void checkEqualsString() {
        Assert.assertEquals("Google", "Google", "Test #1.1: Strings do not match.");
        Assert.assertEquals("Gooooogle", "Google", "Test #1.2: Strings do not match.");
    }

    @Test
    public void checkEqualsBoolean() {
        Assert.assertEquals(4 < 5, 6 > 1, "Test #2.1: Values do not match.");
        Assert.assertEquals(4 > 5, 6 > 1, "Test #2.2: Values do not match.");
    }

    @Test
    public void checkEqualsCollections() {
        SoftAssert softAssert = new SoftAssert();
        List<String> list1 = Arrays.asList("1", "2", "3", "4");
        List<String> list2 = Arrays.asList("1", "2", "3", "4", "5");

        softAssert.assertEquals(list1, list1, "Test #3.1: Collections do not match.");
        softAssert.assertEquals(list1, list2, "Test #3.2: Collections do not match.");
        softAssert.assertAll();
    }

    @Test
    public void checkTrue() {
        Assert.assertTrue(true, "Test #4.1: Value is not true.");
        Assert.assertTrue(2 == 3, "Test #4.2: Value is not true.");
    }

    @Test
    public void checkFalse() {
        Assert.assertFalse(false, "Test #5.1: Value is not false.");
        Assert.assertFalse(2 == 2, "Test #5.2: Value is not false.");
    }
}
