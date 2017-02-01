package plugins.gridview.Tests;

import functional.tests.core.basetest.UIBaseTest;
import org.testng.annotations.Test;
import plugins.gridview.Screens.HomePage;

public class SmokeTests extends UIBaseTest {

    @Test(groups = {"android", "ios"})
    public void gridView() throws Exception {
        new HomePage().loaded();
        this.log.logScreen(this.context.getTestName(), this.context.getTestName());
    }
}