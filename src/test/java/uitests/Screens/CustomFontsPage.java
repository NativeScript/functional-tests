package uitests.Screens;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

import java.util.List;

public class CustomFontsPage extends HomePageExtended {

    public CustomFontsPage(String example, MobileContext context) {
        super(example, context);
        this.basePageLoaded();
    }

    private List<UIElement> buttons() {
        return this.find.elementsByLocator(this.locators.buttonLocator());
    }

    public void basePageLoaded() {
        if (this.buttons() == null) {
            Assert.assertTrue(false, "CustomFontsPage is not loaded");
        }
    }
}
