package animations.Screens;

import functional.tests.core.basepage.BasePageExtended;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import functional.tests.core.exceptions.AppiumException;
import org.testng.Assert;

public class HomePage extends BasePageExtended {

    public HomePage(String mainTestPage, Context context) {
        super(mainTestPage, context);
        if (mainTestPage != "") {
            this.navigateTo(mainTestPage);
        }
    }

    private UIElement title() {
        return this.find.byText("Animations");
    }

    private UIElement button() {
        return this.find.byText("multiple-properties");
    }

    public void loaded() throws AppiumException {
        if (this.button() != null) {
            this.log.info("Animations app home page loaded.");
        } else {
            Assert.fail("Animations app home page NOT loaded.");
        }
    }
}