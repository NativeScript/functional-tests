package nativescriptdemo.Screens.Examples;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class BarSeriesPage extends BasePage {

    public BarSeriesPage(MobileContext context) {
        super(context);
    }

    public void loaded() {
        UIElement element = this.wait.waitForVisible(this.locators.byText("Bar series", false, false), this.settings.shortTimeout, true);
        if (element != null) {
            this.log.info("Bar series page loaded.");
        } else {
            Assert.fail("Bar series page NOT loaded!");
        }
    }
}
