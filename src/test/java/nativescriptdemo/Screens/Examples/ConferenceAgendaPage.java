package nativescriptdemo.Screens.Examples;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import org.testng.Assert;

public class ConferenceAgendaPage extends BasePage {

    public ConferenceAgendaPage(Context context) {
        super(context);
    }

    public void loaded() {
        UIElement element = this.wait.waitForVisible(this.locators.byText("Conference agenda", false, false), this.settings.shortTimeout, true);
        if (element != null) {
            this.log.info("Conference agenda page loaded.");
        } else {
            Assert.fail("Conference agenda page NOT loaded!");
        }
    }
}
