package plugins.dropdown.Tests;

import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.find.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import plugins.dropdown.Screens.HomePage;

public class SmokeTests extends MobileTest {

    @Test(groups = {"android", "ios"})
    public void dropDown() throws Exception {
        HomePage homePage = new HomePage();
        homePage.loaded();
        homePage.tapFifteenItem();
        if (this.settings.platform == PlatformType.Android) {
            Wait.sleep(5);
            homePage.itemTwentyOne();
            homePage.tapTwentyOne();
            Assert.assertNotNull(homePage.twentyOne());
        }
        this.log.logScreen(this.context.getTestName(), this.context.getTestName());
    }
}