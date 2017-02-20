package plugins.firebase.Tests;

import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.find.Wait;
import io.appium.java_client.SwipeElementDirection;
import org.testng.annotations.Test;
import plugins.firebase.Screens.DemoPage;
import plugins.firebase.Screens.HomePage;

public class Smoke extends MobileTest {

    @Test(groups = {"android", "ios"})
    public void addRemoveChild() throws Exception {
        HomePage homePage = new HomePage();
        homePage.loaded();
        homePage.navigateToDemo();
        DemoPage demoPage = new DemoPage();
        demoPage.loaded();

        demoPage.init();
        if (this.settings.platform == PlatformType.Android) {
            homePage.gestures.scrollToElement(SwipeElementDirection.DOWN, "store by push", 2);
        } else if (this.settings.platform == PlatformType.iOS) {
            this.gestures.scrollToElement(SwipeElementDirection.DOWN, "download file", 2);
        }
        demoPage.storeByPush();
        demoPage.addChild();
        if (this.settings.platform == PlatformType.Android) {
            homePage.gestures.scrollToElement(SwipeElementDirection.DOWN, "download file", 2);
        }
        demoPage.verifyTextVisible("ChildAdded");
        Wait.sleep(2000);
        if (this.settings.platform == PlatformType.Android) {
            homePage.gestures.scrollToElement(SwipeElementDirection.UP, "store by push", 2);
        }
        demoPage.removePath();
        Wait.sleep(2000);
        if (this.settings.platform == PlatformType.Android) {
            homePage.gestures.scrollToElement(SwipeElementDirection.DOWN, "download file", 2);
        }
        demoPage.verifyTextVisible("ChildRemoved");
        Wait.sleep(2000);
        this.log.logScreen("unittests", "Firebase demo screen.");
    }
}
