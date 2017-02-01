package uitests.Screens;

import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import org.testng.Assert;

import java.util.List;

public class CustomFontsPage extends HomePageExtended {

    public CustomFontsPage(String example, Context context) {
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
