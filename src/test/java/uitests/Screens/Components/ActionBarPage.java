package uitests.Screens.Components;

import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import org.testng.Assert;
import uitests.Screens.HomePageExtended;

public class ActionBarPage extends HomePageExtended {

    public ActionBarPage(Context context) {
        super("action-bar", context);
    }

    public UIElement actionBar() {
        if (this.settings.platform == PlatformType.Andorid) {
            int index = 2;
            if (this.settings.platformVersion >= 7) {
                index = 0;
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
        if (this.settings.platform == PlatformType.Andorid) {
            return this.find.byText("Green");
        } else {
            return this.find.elementsByLocator(this.locators.buttonLocator()).get(2);
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
