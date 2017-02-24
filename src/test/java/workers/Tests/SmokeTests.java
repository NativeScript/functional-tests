package workers.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.Test;

public class SmokeTests extends MobileTest {

    protected workers.Screens.HomePage homePage;

    @Test(groups = {"android", "ios"})
    public void smokeTest() throws Exception {
        this.homePage = new workers.Screens.HomePage();
        this.homePage.loaded();
        this.homePage.startProcessing();
        if (this.settings.platform == PlatformType.Android) {
            this.homePage.verifyProcessed();
        }
        this.log.logScreen("workers", "workers");
    }
}