package plugins.admob.Tests;

import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.mobile.find.Wait;
import org.testng.annotations.Test;
import plugins.admob.Screens.HomePage;

public class SmokeTests extends MobileTest {

    @Test(groups = {"android", "ios"})
    public void adMob() throws Exception {
        HomePage homePage = new HomePage();
        homePage.tapDemoBtn();
        homePage.tapSmartBannerBtn();

        Wait.sleep(10);
        homePage.btnHideBanner();
        this.log.logScreen(this.context.getTestName(), this.context.getTestName());
    }
}