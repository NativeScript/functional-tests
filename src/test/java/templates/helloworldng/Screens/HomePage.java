package templates.helloworldng.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    public UIElement listView() {
        return this.find.byLocator(this.locators.listViewLocator());
    }

    public void loaded() {
        Assert.assertNotNull(listView());
        this.log.info("Hello-World-NG home page loaded.");
    }
}