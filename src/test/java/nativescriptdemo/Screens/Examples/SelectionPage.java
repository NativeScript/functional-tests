package nativescriptdemo.Screens.Examples;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class SelectionPage extends BasePage {

    public SelectionPage(MobileContext context) {
        super(context);
    }

    public void loaded() {
        UIElement element = this.wait.waitForVisible(this.locators.byText("Selection", false, false), this.settings.shortTimeout, true);
        if (element != null) {
            this.log.info("Selection page loaded.");
        } else {
            Assert.fail("Selection page NOT loaded!");
        }
    }
}
