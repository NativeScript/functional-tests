package uitests.Screens.Components;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;
import uitests.Screens.HomePageExtended;

public class ActionBarPage extends HomePageExtended {

    public ActionBarPage(MobileContext context) {
        super("action-bar", context);
    }

    public UIElement actionBar() {
        if (this.settings.platform == PlatformType.Android) {
            int index = 2;
            if (this.settings.platformVersion >= 7) {
                index = 0;
                long startTime = System.currentTimeMillis();
                while (this.find.elementsByLocator(this.locators.viewGroupLocator()).size() < 4 && (System.currentTimeMillis() - startTime) < 3000) {
                    this.log.info("Elemenst count: " + this.find.elementsByLocator(this.locators.viewGroupLocator()).size());
                }
            }
            return this.find.elementsByLocator(this.locators.viewGroupLocator()).get(index);
        } else if (this.settings.platform == PlatformType.iOS) {
            return this.find.byLocator(this.locators.navigationBarLocator());
        } else {
            return null;
        }
    }

    public void tapActionItem() {
        this.find.byText("ITEM").tap();
    }

    public void tapGoToCleanPageBtn() {
        this.find.byText("go to cleared page").tap();
    }

    public void tapGoToPreviousPageBtn() {
        this.find.byText("go to previous page").tap();
    }

    public UIElement greenActionView() {
        if (this.settings.platform == PlatformType.Android) {
            return this.find.byText("Green");
        } else {
            if (this.settings.platformVersion < 11) {
                return this.find.elementsByLocator(this.locators.buttonLocator()).get(2);
            }

            return this.find.byText("Green");
        }
    }

    public void tapOnBtnTap() {
        this.find.byText("Tap").tap();
    }

    public void loaded() {
        if (actionBar() != null) {
            this.log.info("ActionBar page loaded.");
        } else {
            Assert.fail("ActionBar page NOT loaded.");
        }
    }
}
