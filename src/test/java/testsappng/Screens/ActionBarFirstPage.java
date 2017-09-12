package testsappng.Screens;

import functional.tests.core.mobile.basepage.BasePageExtended;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.helpers.NavigationManager;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ActionBarFirstPage extends BasePageExtended {
    public static final String actionBarOne = "ActionBar1";

    public ActionBarFirstPage(MobileContext context) {
        super(context);
        UIElement btnElement = this.wait.waitForVisible(this.locators.byText(actionBarOne, false, false), 4, true);
        this.navigateTo(btnElement, actionBarOne);
        this.navigationManager.setMainPage(actionBarOne);
        this.loadedActionBarFirstPage();
    }

    public ActionBarFirstPage(MobileContext context, NavigationManager navigationManager) {
        super(context, navigationManager);
    }

    private UIElement title() {
        return this.find.byTextContains("Title 1");
    }

    private UIElement itemAction() {
        return this.find.byText("action");
    }

    private UIElement itemShare() {
        return this.find.byText("share");
    }

    private UIElement itemDelete() {
        if (this.settings.platform == PlatformType.Android) {
            this.find.byText("More options").click();
        }
        return this.find.byText("delete");
    }

    public boolean navigateToActionBarPage() {
        UIElement btnElement = this.wait.waitForVisible(this.locators.byText(actionBarOne, false, false));
        boolean result = this.navigateTo(btnElement, actionBarOne);
        this.navigationManager.setMainPage(actionBarOne);

        if (result) {
            this.wait.waitForVisible(this.locators.byText("Title", false, false), true);
        }
        return result;
    }

    public void tapActionItem() {
        this.itemAction().click();
        this.log.info("Tap on Action item.");
    }

    public void tapShareItem() {
        this.itemShare().click("Click on share");
    }

    public void tapDeleteItem() {
        this.itemDelete().click("Click on delete item");
    }

    public UIElement labelShare() {
        return this.find.byTextContains("share tap");
    }

    public UIElement labelDelete() {
        return this.find.byTextContains("delete tap");
    }

    public void loadedActionBarFirstPage() {
        if (this.title() != null) {
            this.log.info("ActionBar First Page Loaded.");
        } else {
            Assert.fail("ActionBar First Page NOT Loaded.");
        }
    }

    public SecondComponentPage navigateToSecondCoponentPage() {
        UIElement action = this.wait.waitForVisible(this.locators.byText("action"));
        this.navigateTo(action);

        return new SecondComponentPage(this.context);
    }
}
