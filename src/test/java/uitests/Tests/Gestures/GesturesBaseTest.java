package uitests.Tests.Gestures;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.BeforeClass;
import uitests.Screens.HomePageExtended;

public class GesturesBaseTest extends MobileTest {
    public static String pagesEventsString = "events";
    public HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforePagesEventsBaseTestClass() {
        this.homePageExtended = new HomePageExtended(pagesEventsString, this.context);
    }
}
