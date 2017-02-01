package templates.helloworld;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    public UIElement button() {
        return this.find.byText("TAP");
    }

    public void loaded() {
        Assert.assertNotNull(button());
        this.log.info("HelloWorld app home page loaded.");
    }
}