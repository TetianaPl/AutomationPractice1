import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;

public class CheckAssertions {

    @Test
    public void checkEqualsString(){
        Assert.assertEquals("Google", "Google", "Test #1.1: Strings do not match.");
        System.out.println("Test #1.1: Strings matching passed.");
        Assert.assertEquals("Gooooogle", "Google", "Test #1.2: Strings do not match.");
        System.out.println("Test #1.2: Strings matching passed.");
    }

    @Test
    public void checkEqualsBoolean(){
        Assert.assertEquals(4 < 5, 6 > 1, "Test #2.1: Values do not match.");
        System.out.println("Test #2.1: Booleans matching passed.");
        Assert.assertEquals(4 > 5, 6 > 1, "Test #2.2: Values do not match.");
        System.out.println("Test #2.2: Booleans matching passed.");
    }

    @Test
    public void checkEqualsCollections(){
        SoftAssert softAssert = new SoftAssert();
        Collection col = new ArrayList();
        col.add("1");
        col.add("2");
        col.add("3");
//        col.add("4");
        Collection col1 = new ArrayList();
        col1.add("1");
        col1.add("2");
        col1.add("5");

        softAssert.assertEquals(col, col1,"Test #2.1: Collections do not match.");
        System.out.println("Test #3.1: Collections matching executed.");
        softAssert.assertEquals(col, col);
        System.out.println("Test #3.2: Collections matching executed.");
        softAssert.assertAll();
    }

    @Test
    public void checkTrue(){
        Assert.assertTrue(true,  "Test #4.1: Value is not true.");
        System.out.println("Test #4.1: Truth check passed.");
        Assert.assertTrue(2 == 3, "Test #4.2: Value is not true.");
        System.out.println("Test #4.2: Truth check passed.");
    }

    @Test
    public void checkFalse(){
        Assert.assertFalse(false,  "Test #5.1: Value is not false.");
        System.out.println("Test #5.1: False check passed.");
        Assert.assertFalse(2 == 2);
        System.out.println("Test #5.2: False check passed.");
    }
}
