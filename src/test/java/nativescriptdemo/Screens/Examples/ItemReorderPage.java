package nativescriptdemo.Screens.Examples;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import org.testng.Assert;

public class ItemReorderPage extends BasePage {

    public ItemReorderPage(Context context) {
        super(context);
    }

    public void loaded() {
        UIElement element = this.wait.waitForVisible(this.locators.byText("Item reorder", false, false), this.settings.shortTimeout, true);
        if (element != null) {
            this.log.info("Items reorder page loaded.");
        } else {
            Assert.fail("Items reorder page NOT loaded!");
        }
    }
}
