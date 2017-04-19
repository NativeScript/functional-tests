package plugins.dropdown.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    public UIElement myHint() {
        return this.find.byText("My Hint");
    }

    public UIElement itemZero() {
        return this.find.byText("Item 0");
    }

    public UIElement itemThree() {
        return this.find.byText("Item 3");
    }

    public UIElement twentyOne() {
        return this.find.byText("21");
    }

    public UIElement itemFifteen() {
        return this.find.byText("Item 15");
    }

    public UIElement itemTwentyOne() {
        return this.find.byText("Item 21");
    }

    public void tapFifteenItem() {
        this.itemFifteen().click();
        this.log.info("Tap on 'item 15'.");
    }

    public void tapTwentyOne() {
        this.itemTwentyOne().click();
        this.log.info("Tap on 'item 21'.");
    }

    public void loaded() {
        if (this.myHint() != null) {
            this.log.info("DropDown app loaded.");
        } else {
            Assert.fail("DropDown app NOT loaded.");
        }
    }
}