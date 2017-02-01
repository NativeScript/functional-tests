package cuteness.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import org.testng.Assert;

public class DetailsPage extends BasePage {

    public DetailsPage() {
        super();
    }

    private UIElement details() {
        return this.find.byTextContains("comments");
    }

    public void loaded() {
        Assert.assertNotNull(this.details(), "Details page not loaded.");
        this.log.info("Details page loaded.");
    }
}