package uitests.Tests.PagesEvents;

import functional.tests.core.basetest.UIBaseTest;
import org.testng.annotations.BeforeClass;
import uitests.Screens.HomePageExtended;

public class PagesEventsBaseTest extends UIBaseTest {
    public HomePageExtended homePageExtended;
    public static String pagesEventsString = "pages-events";

    @BeforeClass(alwaysRun = true)
    public void beforePagesEventsBaseTestClass() {
        this.homePageExtended = new HomePageExtended(pagesEventsString, this.context);
    }
}
