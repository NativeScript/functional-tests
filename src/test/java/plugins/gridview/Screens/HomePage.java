package plugins.gridview.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    private UIElement item() {
        return this.find.byText("test 10");
    }

    public void loaded() {
        if (this.item() != null) {
            this.log.info("GridView app loaded.");
        } else {
            Assert.fail("GridView app NOT loaded.");
        }
    }
}