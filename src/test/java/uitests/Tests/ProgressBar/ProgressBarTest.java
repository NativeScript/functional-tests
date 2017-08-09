package uitests.Tests.ProgressBar;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

public class ProgressBarTest extends UIBaseTests {

    public HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeProgressBarTestClass() {
        this.homePageExtended = new HomePageExtended("progress-bar", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void activity_indicator() throws Exception {
        this.homePageExtended.navigateTo("activity-indicator");
        this.assertScreen(10);
    }

    @Test(groups = {"android", "ios"})
    public void progress_bar() throws Exception {
        this.homePageExtended.navigateTo(this.find.byText("progress-bar"));
        this.assertScreen(10);
    }


}
