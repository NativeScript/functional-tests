package nativescriptdemo.Screens.Pages;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class AboutPage extends BasePage {

    public AboutPage(MobileContext context) {
        super(context);
    }

    public void loaded() {
        UIElement element = this.wait.waitForVisible(this.locators.byText("NativeScript is how you build", false, false), 5, true);
        if (element != null) {
            this.log.info("About page loaded.");
        } else {
            Assert.fail("About page NOT loaded!");
        }
    }
}
