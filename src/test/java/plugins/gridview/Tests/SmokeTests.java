package plugins.gridview.Tests;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.Test;
import plugins.gridview.Screens.HomePage;

public class SmokeTests extends MobileTest {

    @Test(groups = {"android", "ios"})
    public void gridView() throws Exception {
        new HomePage().loaded();
        this.log.logScreen(this.context.getTestName(), this.context.getTestName());
    }
}