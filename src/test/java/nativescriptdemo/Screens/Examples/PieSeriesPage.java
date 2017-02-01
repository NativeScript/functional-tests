package nativescriptdemo.Screens.Examples;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import org.testng.Assert;

public class PieSeriesPage extends BasePage {

    public PieSeriesPage(Context context) {
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
