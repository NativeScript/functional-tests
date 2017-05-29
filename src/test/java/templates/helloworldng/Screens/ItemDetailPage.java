package templates.helloworldng.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class ItemDetailPage extends BasePage {

    public ItemDetailPage() {
        super();
    }

    private UIElement title() {
        return this.find.byText("Details");
    }

    public UIElement player(String player) {
        return this.find.byText(player);
    }

    public void loaded() {
        Assert.assertNotNull(this.title());
        this.log.info("HelloWorldNG item detail page loaded.");
    }
}