import org.testng.Assert;
import org.testng.annotations.*;

public class CheckEmailHappyPath {

    //  Test checks the email address with valid data. It is considered passed if data is accepted
    @DataProvider(name = "getValidDataForEmailAddress")
    public Object[] getData() {
        return new Object[]{"12345abcde!___!FGHIG@7k.dd",
                "!!!___@F34.abc",
                "_8!07@e2e4f.ru",
                "A1z2x3R@123.ddddd",
                "c!!M_@FFFFF.ff",
                "01234567890123456789@44.yyy",
                "WWW@11111.uytre",
                "google@gg.else",
                "sgdsg@gmail.com7"
        };
    }

    @Test(dataProvider = "getValidDataForEmailAddress")
    public void checkEmail(String emailAddress) {
        boolean actualResult = Email.isEmailCorrect(emailAddress);
        Assert.assertTrue(actualResult, "Test checks the email with valid data: " + emailAddress +
                " and passes if data is accepted.\n" +
                "Seems like isEmailCorrect method rejected valid params for email address, or data is actually invalid.");
    }

}
