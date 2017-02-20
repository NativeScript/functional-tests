package uitests.Tests.PagesEvents;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.BeforeClass;
import uitests.Screens.HomePageExtended;

public class PagesEventsBaseTest extends MobileTest {
    public static String pagesEventsString = "pages-events";
    public HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforePagesEventsBaseTestClass() {
        this.homePageExtended = new HomePageExtended(pagesEventsString, this.context);
    }
}
