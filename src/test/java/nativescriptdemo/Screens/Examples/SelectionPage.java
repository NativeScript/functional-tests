package nativescriptdemo.Screens.Examples;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import org.testng.Assert;

public class SelectionPage extends BasePage {

    public SelectionPage(Context context) {
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
