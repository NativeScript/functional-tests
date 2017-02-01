package uitests.Tests.Css;

import functional.tests.core.enums.PlatformType;
import io.appium.java_client.SwipeElementDirection;
import org.testng.annotations.Test;

public class ListViewTests extends CssBaseTest {

    @Test(groups = {"android", "ios"})
    public void cssListView_01() throws Exception {
        this.cssBasePage.navigateTo("csslv");
        this.compareScreens(this.settings.defaultTimeout, 0.25);
        this.cssBasePage.scrollTo("NAME99", 20);

        double tolerance = 0.28d;
        if (this.settings.platform == PlatformType.iOS) {
            tolerance = 0.40d;
        }
        this.compareScreens(2, tolerance);
        this.assertImagesResults();
    }


    // Uncomment when the example is added
    //@Test(groups = {"android", "ios"})
    public void cssListPicker_issue_3453() throws Exception {
        this.cssBasePage.navigateTo("list-picker");
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 250, 100);
        this.wait.waitForVisible(this.locators.listPicker()).swipeInElement(SwipeElementDirection.DOWN, 0, 6);
        this.assertScreen(this.settings.defaultTimeout);
    }
}
