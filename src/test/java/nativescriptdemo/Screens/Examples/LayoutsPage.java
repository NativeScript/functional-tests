package nativescriptdemo.Screens.Examples;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import org.testng.Assert;

import java.util.List;

public class LayoutsPage extends BasePage {

    public LayoutsPage(MobileContext context) {
        super(context);
    }

    public List<UIElement> items() {
        return this.find.elementsByLocator(this.locators.imageLocator());
    }

    public UIElement itemStack() {
        if (this.settings.platform == PlatformType.Android) {
            return this.items().get(0);
        } else if (this.settings.platform == PlatformType.iOS) {
            return this.find.byText("Stack");
        } else {
            return null;
        }
    }

    public UIElement itemGrid() {
        if (this.settings.platform == PlatformType.Android) {
            return this.items().get(1);
        } else if (this.settings.platform == PlatformType.iOS) {
            return this.find.byText("Grid");
        } else {
            return null;
        }
    }

    public UIElement itemWrap() {
        if (this.settings.platform == PlatformType.Android) {
            return this.items().get(2);
        } else if (this.settings.platform == PlatformType.iOS) {
            return this.find.byText("Wrap");
        } else {
            return null;
        }
    }

    public UIElement itemDock() {
        if (this.settings.platform == PlatformType.Android) {
            return this.items().get(3);
        } else if (this.settings.platform == PlatformType.iOS) {
            return this.find.byText("Dock");
        } else {
            return null;
        }
    }

    public UIElement itemAbsolute() {
        if (this.settings.platform == PlatformType.Android) {
            return this.items().get(4);
        } else if (this.settings.platform == PlatformType.iOS) {
            return this.find.byText("Absolute");
        } else {
            return null;
        }
    }

    public void loaded() {
        UIElement element = this.wait.waitForVisible(this.locators.byText("Layouts", false, false), this.settings.shortTimeout, true);
        if (element != null) {
            this.log.info("Layouts page loaded.");
        } else {
            Assert.fail("Layouts page NOT loaded!");
        }
    }
}
