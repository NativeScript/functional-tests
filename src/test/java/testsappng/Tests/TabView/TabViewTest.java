package testsappng.Tests.TabView;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.HomePage;
import testsappng.TestsAppNgBase;

public class TabViewTest extends TestsAppNgBase {
    protected HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClassTabVieWTests() throws Exception {
        this.homePage = new HomePage("TAB-VIEW", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void tabView_issue_654() throws Exception {
        this.assertScreen(3);
    }
}