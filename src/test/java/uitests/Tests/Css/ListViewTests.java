package uitests.Tests.Css;

import functional.tests.core.enums.PlatformType;
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

    @Test(groups = {"android", "ios"})
    public void listview_bg_separator_color_3233_3574() throws Exception {
        this.cssBasePage.navigateTo("listview_bg_separator_color");
        this.assertScreen(this.settings.defaultTimeout);
    }
}
