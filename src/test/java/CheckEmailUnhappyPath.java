import org.testng.Assert;
import org.testng.annotations.*;

public class CheckEmailUnhappyPath {

    //  Test checks the email address with invalid data. It is considered passed if data is rejected
    @DataProvider(name = "getInvalidDataForEmailAddress")
    public Object[] getData() {
        return new Object[]{"",
                null,
                "@.",
                "@gmail.com",
                "name@.com",
                "name@gmail.",
                "na@gmail.com",
                "name@g.com",
                "name@gmail.c",
                "na@g.c",
                "012345678901234567890@gmail.com",
                "name@google.com",
                "name@gmail.google",
                "123@456.77",
                "привет@mail.ru",
                "name!#@mail.ru",
                "name.mail@ru",
                "bad@name@mail.ru",
                "bad@name.mail.ru",
                "name_mail_ru",
                "sgdsg@gmail.com"
        };
    }

    @Test(dataProvider = "getInvalidDataForEmailAddress")
    public void checkEmail(String emailAddress) {
        boolean actualResult = Email.isEmailCorrect(emailAddress);
        Assert.assertFalse(actualResult, "Test checks the email with invalid data: " + emailAddress +
                " and passes if data is rejected.\n" +
                "Seems like isEmailCorrect method accepted invalid params for email address, or data is actually valid.");
    }

}
