package cuteness.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class AboutPage extends BasePage {

    public AboutPage() {
        super();
    }

    private UIElement about() {
        return this.wait.waitForVisible(
                this.locators.byText("Cuteness is a proof of concept app", false, false));
    }

    public void loaded() {
        Assert.assertNotNull(this.about(), "About page NOT loaded.");
        this.log.info("About page loaded.");
    }
}