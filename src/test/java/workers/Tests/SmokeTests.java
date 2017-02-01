package workers.Tests;

import functional.tests.core.basetest.UIBaseTest;
import functional.tests.core.enums.PlatformType;
import org.testng.annotations.Test;

public class SmokeTests extends UIBaseTest {

    protected workers.Screens.HomePage homePage;

    @Test(groups = {"android", "ios"})
    public void smokeTest() throws Exception {
        this.homePage = new workers.Screens.HomePage();
        this.homePage.loaded();
        this.homePage.startProcessing();
        if (this.settings.platform == PlatformType.Andorid) {
            this.homePage.verifyProcessed();
        }
        this.log.logScreen("workers", "workers");
    }
}