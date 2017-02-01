package nativescriptdemo.Screens.Examples;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import org.testng.Assert;

public class LineSeriesPage extends BasePage {

    public LineSeriesPage(Context context) {
        super(context);
    }

    public void loaded() {
        UIElement element = this.wait.waitForVisible(this.locators.byText("Line series", false, false), this.settings.shortTimeout, true);
        if (element != null) {
            this.log.info("Line series page loaded.");
        } else {
            Assert.fail("Line series page NOT loaded!");
        }
    }
}
