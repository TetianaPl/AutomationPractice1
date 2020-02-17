import org.testng.annotations.*;

public class checkBefore {

    @BeforeSuite //перед всеми тестовыми методами всех классов. Эта аннотация помечает точку входа при запуске
    public void checkBeforeSuite() {
        System.out.println("@BeforeSuite execution");
    }

    @BeforeTest //перед запуском первого метода с аннотацией @Test
    public void checkBeforeTest() {
        System.out.println("@BeforeTest execution");
    }

    @BeforeClass //перед первым тестовым методом в текущем классе
    public void checkBeforeClass() {
        System.out.println("@BeforeClass execution");
    }

    @BeforeGroups("testGroup") //перед указанной группой тестов
    public void checkBeforeGroups() {
        System.out.println("@BeforeGroups execution");
    }

    @BeforeMethod //перед каждым @Test-методом
    public void checkBeforeMethod() {
        System.out.println("@BeforeMethod execution");
    }

    @AfterMethod //после каждого @Test-метода
    public void checkAfterMethod() {
        System.out.println("@AfterMethod execution");
    }

    @AfterGroups("testGroup") //после выполнения всех тестовых методов указанной группы
    public void checkAfterGroups() {
        System.out.println("@AfterGroups execution");
    }

    @AfterClass //после последнего тестового метода в текущем классе
    public void checkAfterClass() {
        System.out.println("@AfterClass execution");
    }

    @AfterTest //после всех @Test-методов теста
    public void checkAfterTest() {
        System.out.println("@AfterTest execution");
    }

    @AfterSuite //после запуска всех методов тестирования во всех классах
    public void checkAfterSuite() {
        System.out.println("@AfterSuite execution");
    }








    @Test
    public void Test1() {
        System.out.println("My test 1 execution");
    }

    @Test(groups = "testGroup")
    public void Test2() {
        System.out.println("My test 2 execution");
    }

    @Test(groups = "testGroup")
    public void Test3() {
        System.out.println("My test 3 execution");
    }

}