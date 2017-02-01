package workers.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import functional.tests.core.exceptions.AppiumException;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    private UIElement processButton() {
        return this.find.byText("Process (BW)");
    }

    public void startProcessing() {
        this.processButton().tap();
        this.log.info("Start processing...");
    }

    public void verifyProcessed() {
        UIElement e = this.find.byText("100", this.settings.defaultTimeout);
        Assert.assertNotNull(e, "Failed to find 100% text on the page.");
        this.log.info("Processing complete!");
    }

    public void loaded() throws AppiumException {
        if (this.processButton() != null) {
            this.log.info("Workers home page loaded.");
        } else {
            Assert.fail("Workers home page not loaded.");
        }
    }
}
