package plugins.touchid.Tests;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.Test;
import plugins.touchid.Screens.HomePage;

public class SmokeTests extends MobileTest {

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