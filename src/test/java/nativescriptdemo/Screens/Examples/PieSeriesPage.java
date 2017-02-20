package nativescriptdemo.Screens.Examples;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class PieSeriesPage extends BasePage {

    public PieSeriesPage(MobileContext context) {
        super(context);
    }

    public void loaded() {
        UIElement element = this.wait.waitForVisible(this.locators.byText("International food", false, false), this.settings.shortTimeout, true);
        if (element != null) {
            this.log.info("Pie series page loaded.");
        } else {
            Assert.fail("Pie series page NOT loaded!");
        }
    }
}
