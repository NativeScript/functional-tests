package plugins.barcodescanner.Tests;

import functional.tests.core.basetest.UIBaseTest;
import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import io.appium.java_client.SwipeElementDirection;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import plugins.barcodescanner.Screens.DemoPage;
import plugins.barcodescanner.Screens.DialogRequestPermissions;
import plugins.barcodescanner.Screens.HomePage;

public class Smoke extends UIBaseTest {
    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeSmokeTestClass() {
        this.homePage = new HomePage();
        UIElement demo = this.wait.waitForVisible(this.locators.byText("DEMO"));
        if (demo != null) {
            demo.tap();
        }
    }

    @Test
    public void checkAvailability() throws Exception {
        DemoPage demoPage = homePage.tapDemo();
        demoPage.availableButton().tap();

        demoPage.wait.waitForVisible(this.locators.findByTextLocator("YES", true), true);

        demoPage.wait.waitForVisible(this.locators.byText("OK")).tap();
    }


    // TODO: should make it to work on real device extend it
    @Test
    public void scan() throws Exception {
        DemoPage demoPage = this.homePage.tapDemo();

        if (this.settings.platform == PlatformType.iOS) {
            if (this.settings.isRealDevice) {
                demoPage.backCammeraButton().click();
                demoPage.wait.waitForVisible(this.locators.findByTextLocator("EXIT", false), true);
            }
        } else if (this.settings.platform == PlatformType.Andorid) {
            if (this.settings.platformVersion >= 6) {
                // Request Permissions
                demoPage.requestPermissionsButton().click();
                DialogRequestPermissions dialogRequestPermissions = new DialogRequestPermissions();
                dialogRequestPermissions.tapAllow();
                dialogRequestPermissions.unloaded();
                demoPage.loaded();
            }
            // Scan
            UIElement backCammeraButton = demoPage.gestures.swipeInWindowToElement(SwipeElementDirection.DOWN, this.locators.byText("back camera, with flip"), 1, 800, 0);
            backCammeraButton.tap();
            demoPage.wait.waitForVisible(this.locators.findByTextLocator("Use the volume buttons for extra light", false), true);
        }
    }
}