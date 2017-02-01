package plugins.touchid.Tests;

import functional.tests.core.basetest.UIBaseTest;
import org.testng.annotations.Test;
import plugins.touchid.Screens.HomePage;

public class SmokeTests extends UIBaseTest {

    @Test(groups = {"android", "ios"})
    public void touchId() throws Exception {
        HomePage homePage = new HomePage(this.context);
        homePage.loaded();
        homePage.tapDemoBtn();
        homePage.tapAvailableBtn();
        this.log.logScreen(this.context.getTestName(), this.context.getTestName());
        homePage.tapOkBtn();
    }
}