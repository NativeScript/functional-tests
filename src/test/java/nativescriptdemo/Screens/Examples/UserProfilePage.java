package nativescriptdemo.Screens.Examples;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class UserProfilePage extends BasePage {

    public UserProfilePage(MobileContext context) {
        super(context);
    }

    public void loaded() {
        UIElement element = this.wait.waitForVisible(this.locators.byText("User profile", false, false), this.settings.shortTimeout, true);
        if (element != null) {
            this.log.info("User profile page loaded.");
        } else {
            Assert.fail("User profile page NOT loaded!");
        }
    }
}
