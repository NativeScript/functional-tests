package todomvc.Tests;

import functional.tests.core.exceptions.AppiumException;
import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.BeforeClass;
import todomvc.Screens.HomePage;

public class TodoMvcBaseTest extends MobileTest {
    protected static int count;
    protected static String testTask = "test";

    protected HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeTodoMvcBaseTestClass() {
        this.homePage = new HomePage();
        try {
            this.homePage.loaded();
        } catch (AppiumException e) {
            e.printStackTrace();
        }
    }
}
