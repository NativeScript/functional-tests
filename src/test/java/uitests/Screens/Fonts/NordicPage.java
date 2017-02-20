package uitests.Screens.Fonts;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import org.openqa.selenium.By;
import org.testng.Assert;
import uitests.Screens.HomePageExtended;

public class NordicPage extends HomePageExtended {

    public NordicPage(String example, MobileContext context) {
        super(example, context);
    }

    public void basePageLoaded() {
        if (label() != null) {
            this.log.info("Nordic page loaded.");
        } else {
            Assert.fail("Nordic page NOT loaded.");
        }
    }


    public UIElement label() {
        if (this.settings.platform == PlatformType.Android) {
            return this.find.elementsByLocator(this.locators.textViewLocator()).get(1);
        } else if (this.settings.platform == PlatformType.iOS) {
            return this.find.byLocator(this.locators.labelLocator());
        } else {
            return null;
        }
    }

    public By labelLocator() {
        if (this.settings.platform == PlatformType.Android) {
            return this.locators.textViewLocator();
        } else if (this.settings.platform == PlatformType.iOS) {
            return this.locators.labelLocator();
        } else {
            return null;
        }
    }

    public UIElement button() {
        if (this.settings.platform == PlatformType.Android) {
            return this.find.byLocator(this.locators.buttonLocator());
        } else if (this.settings.platform == PlatformType.iOS) {
            return this.find.elementsByLocator(this.locators.buttonLocator()).get(2);
        } else {
            return null;
        }
    }
}
