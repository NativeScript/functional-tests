package uitests.Screens;

import functional.tests.core.mobile.basepage.BasePageExtended;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;

public class HomePageExtended extends BasePageExtended {

    public HomePageExtended(String mainPage, MobileContext context) {
        super(mainPage, context);
        this.uiTestsHomePageloaded(mainPage);
    }

    public HomePageExtended(String testPage, String waitForElement, MobileContext context) {
        super(testPage, context);
        this.uiTestsHomePageloaded(waitForElement);
    }

    public void uiTestsHomePageloaded(String element) {
        UIElement btnElement = this.find.byText(element);
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
