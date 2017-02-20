package nativescriptdemo.Screens.Examples;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class ItemLayoutsPage extends BasePage {

    public ItemLayoutsPage(MobileContext context) {
        super(context);
    }

    public void loaded() {
        UIElement element = this.wait.waitForVisible(this.locators.byText("Item layouts", false, false), this.settings.shortTimeout, true);
        if (element != null) {
            this.log.info("Items layouts page loaded.");
        } else {
            Assert.fail("Items layouts page NOT loaded!");
        }
    }
}
