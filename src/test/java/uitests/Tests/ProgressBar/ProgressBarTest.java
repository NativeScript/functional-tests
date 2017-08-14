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
        this.assertScreen(15,0.07);
    }

    @Test(groups = {"android", "ios"})
    public void progress_bar() throws Exception {
        this.homePageExtended.navigateToMainPage();
        this.homePageExtended.navigateTo(this.wait.waitForVisible(this.locators.byText("progress-bar")));
        this.assertScreen(10);
    }
}
