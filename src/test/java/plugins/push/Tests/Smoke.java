package plugins.push.Tests;

import functional.tests.core.basetest.UIBaseTest;
import functional.tests.core.enums.PlatformType;
import org.testng.annotations.Test;
import plugins.push.Screens.HomePage;

public class Smoke extends UIBaseTest {

    @Test(groups = {"android", "ios"})
    public void addItems() throws Exception {
        HomePage homePage = new HomePage();
        homePage.loaded();
        homePage.enableNotifications();
        if (this.settings.platform == PlatformType.Andorid){
            homePage.disableNotifications();
            homePage.loaded();
        }
    }
}
