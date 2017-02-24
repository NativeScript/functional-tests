package plugins.push.Tests;

import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.enums.PlatformType;
import org.testng.annotations.Test;
import plugins.push.Screens.HomePage;

public class Smoke extends MobileTest {

    @Test(groups = {"android", "ios"})
    public void addItems() throws Exception {
        HomePage homePage = new HomePage();
        homePage.loaded();
        homePage.enableNotifications();
        if (this.settings.platform == PlatformType.Android){
            homePage.disableNotifications();
            homePage.loaded();
        }
    }
}
