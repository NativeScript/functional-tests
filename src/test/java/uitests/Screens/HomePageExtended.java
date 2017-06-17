package uitests.Screens;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basepage.BasePageExtended;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.basetest.MobileSetupManager;
import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class HomePageExtended extends BasePageExtended {

    public HomePageExtended(String mainPage, MobileContext context) {
        super(mainPage, context);
        this.uiTestsHomePageLoaded(mainPage);
    }

    public HomePageExtended(String testPage, String waitForElement, MobileContext context) {
        super(testPage, context);
        this.uiTestsHomePageLoaded(waitForElement);
    }

    public void uiTestsHomePageLoaded(String element) {
        UIElement btnElement = this.wait.waitForVisible(this.locators.byText(element));
        if (btnElement == null) {
            this.context.log.logScreen(this.context.getTestName() + "_fail", "OnNavigateTo_" + element);
            this.app.restart();
            Assert.fail("Couldn't resolve navigate to " + element);
        }

        boolean hasNavigated = this.navigateTo(btnElement, element);

        if (hasNavigated) {
            this.log.info("UITests app " + element + " page loaded.");
        } else {
            this.log.info("Failed to navigate to " + element + " page.");
        }
    }

    public boolean checkIfPlatfomrVersionIsIos10() {
        if (this.settings.platformVersion >= 10 && this.settings.platform == PlatformType.iOS) {
            return true;
        } else {
            return false;
        }
    }
}
