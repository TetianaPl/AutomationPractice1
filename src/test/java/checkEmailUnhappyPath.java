import org.testng.Assert;
import org.testng.annotations.*;

public class checkEmailUnhappyPath {

    @Test(dataProvider="getBadData")
    public void checkEmail(String emailAddress) {
        boolean actualResult = Email.isEmailCorrect(emailAddress);
        Assert.assertFalse(actualResult,"Test #Unhappy with data: " + emailAddress + " is failed.");
        System.out.println("Test #Unhappy with data: " + emailAddress + " is passed.");
    }

    @DataProvider(name = "getBadData")
    public Object[] getData() {
        return new Object[]{"", null, "@.", "@gmail.com", "name@.com", "name@gmail.",
                "na@gmail.com", "name@g.com", "name@gmail.c", "na@g.c",
                 "012345678901234567890@gmail.com", "name@google.com", "name@gmail.google", "123@456.77",
                "привет@mail.ru", "name!#@mail.ru", "name.mail@ru", "bad@name@mail.ru", "bad@name.mail.ru", "name_mail_ru"};
    }
}
