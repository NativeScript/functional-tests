package uitests.Screens.Dialogs;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import org.testng.Assert;
import uitests.Screens.HomePageExtended;

public class DialogsPage extends HomePageExtended {

    public static final String name0 = "Harold Finch";
    public static final String name1 = "John Reese";

    public DialogsPage(String example, MobileContext context) {
        super(example, context);
        this.basePageLoaded();
    }

    public UIElement label() {
        this.wait.waitForVisible(this.locators.labelLocator(), 6, true);
        if (this.settings.platform == PlatformType.Android) {
            return this.find.elementsByLocator(this.locators.labelLocator()).get(1);
        } else if (this.settings.platform == PlatformType.iOS) {
            if (this.settings.deviceName.contains("X")) {
                return this.find.elementsByLocator(this.locators.labelLocator()).get(1);
            } else {
                return this.find.byLocator(this.locators.labelLocator());
            }

        } else {
            return null;
        }
    }

    public void tapActionBtn() {
        this.find.byText("action").tap();
    }

    public void tapAlertBtn() {
        this.find.byText("alert").click();
    }

    public void tapConfirmBtn() {
        this.find.byText("confirm").click();
    }

    public void tapLoginBtn() {
        UIElement el = this.find.byText("login");
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion >= 10) {
            el.tap();
        } else {
            el.click();
        }
        this.log.info("Tap on 'login' button.");
    }

    public void tapPromptTextBtn() {
        this.find.byText("promptText").click();
    }

    public void tapPromptPassBtn() {
        this.find.byText("promptPass").click();
    }

    public void tapPromptEmailBtn() {
        this.find.byText("promptEmail").click();
    }

    public void tapOkBtn() {
        this.find.byText("OK").click();
    }

    public void tapCloseBtn() {
        this.find.byText("Close").tap();
    }

    public void tapCancelBtn() {
        UIElement el = this.find.byText("Cancel");
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion >= 10) {
            el.tap();
        } else {
            el.click();
        }
    }

    public void tapIgnoreBtn() {
        this.find.byText("Ignore").click();
    }

    public void tapYesBtn() {
        UIElement el = this.find.byText("Yes");
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion >= 10) {
            el.tap();
        } else {
            el.click();
        }

        this.log.info("Choose 'Yes' option.");
    }

    public void tapNoBtn() {
        UIElement el = this.find.byText("No");
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion >= 10) {
            el.tap();
        } else {
            el.click();
        }

        this.log.info("Choose 'No' option.");
    }

    public void basePageLoaded() {
        if (this.label() != null) {
            this.log.info("Modals page loaded.");
        } else {
            Assert.fail("Modals page NOT loaded.");
        }
    }
}
