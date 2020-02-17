import org.testng.Assert;
import org.testng.annotations.*;

public class checkEmailHappyPath {

    @Test(dataProvider = "getData")
    public void checkEmail(String emailAddress) {
        boolean actualResult = Email.isEmailCorrect(emailAddress);
        Assert.assertTrue(actualResult, "\"Test #Happy with data: " + emailAddress + " is failed.");
        System.out.println("Test #Happy with data: " + emailAddress + " is passed.");
    }

    @DataProvider(name = "getData")
    public Object[] getData() {
        return new Object[]{"12345abcde!___!FGHIG@7k.dd", "!!!___@F34.abc", "_8!07@e2e4f.ru", "A1z2x3R@123.ddddd",
                "c!!M_@FFFFF.ff", "01234567890123456789@44.yyy", "WWW@11111.uytre", "google@gg.else"};
    }

}
