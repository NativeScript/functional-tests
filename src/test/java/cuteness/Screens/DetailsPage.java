package cuteness.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class DetailsPage extends BasePage {

    public DetailsPage() {
        super();
    }

    private UIElement details() {
        return this.wait.waitForVisible(this.locators.byText("comments"));
    }

    public void loaded() {
        Assert.assertNotNull(this.details(), "Details page not loaded.");
        this.log.info("Details page loaded.");
    }
}