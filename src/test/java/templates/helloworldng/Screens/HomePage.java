package templates.helloworldng.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    private UIElement listView() {
        return this.find.byLocator(this.locators.listViewLocator());
    }

    public void tapOnItem(String itemText) {
        this.find.byText(itemText).tap();
    }

    public void loaded() {
        Assert.assertNotNull(this.listView());
        this.log.info("HelloWorldNG home page loaded.");
    }
}