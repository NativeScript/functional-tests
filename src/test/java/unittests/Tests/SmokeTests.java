package unittests.Tests;

import functional.tests.core.enums.DeviceType;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.utils.OSUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import unittests.Screens.HomePage;

import java.util.HashMap;

public class SmokeTests extends MobileTest {

    @Test(groups = {"android", "ios"})
    public void runTests() throws Exception {
        HomePage homePage = new HomePage();

        // Allow tests to access photos, media, and files on the device
        // if (this.settings.platform == PlatformType.Android && this.settings.platformVersion >= 6.0) {
        //     homePage.find.byText("Allow").click();
        // }

        boolean result = homePage.waitForTestsToComplete();
        Assert.assertTrue(result, "There are failing unit tests!");
    }
}
