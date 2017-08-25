package testsappng.Screens;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;

public class ActionBarSecondPage extends HomePage {
    public static final String actionBarTwo = "ActionBar2";

    public ActionBarSecondPage(MobileContext context) {
        super(ActionBarSecondPage.actionBarTwo, context);
    }

    private UIElement title() {
        return this.find.byText("Title 2");
    }

    private UIElement itemBack() {
        if (this.settings.platform == PlatformType.Android) {
            return this.find.byLocator(this.locators.imageButtonLocator());
        }
        if (this.settings.platform == PlatformType.iOS) {
            return this.find.byLocator(By.id("First"));
        } else {
            return null;
        }
    }

    public UIElement itemCustom() {
        return this.find.byText("CUSTOM");
    }

    private UIElement btnTap() {
        return this.find.byText("TAP");
    }

    private UIElement btnShow() {
        return this.find.byText("show");
    }

    private UIElement btnHide() {
        return this.find.byText("hide");
    }

    public void tapBackItem() {
        this.navigationManager.navigateBack(itemBack());
        this.log.info("Tap on Back item.");
    }

    public void tapCustomItem() {
        this.itemCustom().click();
        this.log.info("Tap on Custom item.");
    }

    public void tapTapBtn() {
        this.btnTap().click();
        this.log.info("Tap on Tap button.");
    }

    public void tapShowBtn() {
        this.btnShow().click();
        this.log.info("Tap on Show button.");
    }

    public void tapHideBtn() {
        this.btnHide().click();
        this.log.info("Tap on Hide button.");
    }

    public UIElement labelTap() {
        if (this.settings.platform == PlatformType.Android) {
            return this.find.byTextContains(" tap");
        }
        if (this.settings.platform == PlatformType.iOS) {
            int index = 2;
            if (this.settings.platformVersion >= 11) {
                index = 1;
            }
            return this.find.elementsByLocator(this.locators.buttonLocator()).get(index);
        } else {
            return null;
        }
    }

    public UIElement labelCustom() {
        return this.find.byTextContains("custom tap");
    }

    public Boolean loadedActionBarSecondPage() {
        if (this.title() != null) {
            this.log.info("ActionBar Second homePageLoaded.");
            return true;
        } else {
            this.log.error("ActionBar Second NOT homePageLoaded.");
            return false;
        }
    }
}
