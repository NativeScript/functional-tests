package animations.Screens;

import functional.tests.core.exceptions.AppiumException;
import functional.tests.core.log.Log;
import functional.tests.core.mobile.basetest.MobileContext;
import org.testng.Assert;

public class DemoPage extends CssAnimationsPage {
    public Log log;

    public DemoPage(String page, MobileContext context) {
        super(page, context);
        this.log = context.log;
    }

    public Boolean loaded() throws AppiumException {
        if (this.btnReset() != null) {
            this.log.info("Demo page loaded.");
            return true;
        } else {
            this.log.error("Demo page NOT loaded.");
            return false;
        }
    }

    public void loadedSlideInEffect() throws AppiumException {
        if (this.btnAddItem() != null) {
            this.log.info("Demo page loaded.");
        } else {
            Assert.fail("Demo page NOT loaded.");
        }
    }
}