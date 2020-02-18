import org.junit.*;

public class CheckBeforeJUnit {

    @BeforeClass //до создания экземпляра тест-класса
    public static void checkBeforeClass() {
        System.out.println("@BeforeClass execution");
    }

    @Before //перед каждым @Test
    public void checkBefore() {
        System.out.println("@Before execution");
    }

    @After  //после каждого @Test
    public void checkAfter() {
        System.out.println("@After execution");
    }

    @AfterClass //после последнего @Test в текущем классе
    public static void checkAfterClass() {
        System.out.println("@AfterClass execution");
    }

    @Test
    public void Test1() {
        System.out.println("My test 1 execution");
    }

    @Test
    public void Test2() {
        System.out.println("My test 2 execution");
    }

}