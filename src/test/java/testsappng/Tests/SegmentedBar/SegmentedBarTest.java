package testsappng.Tests.SegmentedBar;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.HomePage;
import testsappng.TestsAppNgBase;

public class SegmentedBarTest extends TestsAppNgBase {
    protected HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeSegmentedBarTestClass() throws Exception {
        this.homePage = new HomePage("SegmentedBar", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void issue_649() throws Exception {
        this.homePage.navigateTo("issue-649");
        this.assertScreen(3);
    }
}