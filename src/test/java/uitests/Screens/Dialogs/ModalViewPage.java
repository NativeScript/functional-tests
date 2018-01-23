package uitests.Screens.Dialogs;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;
import uitests.Screens.HomePageExtended;

public class ModalViewPage extends HomePageExtended {

    public ModalViewPage(String example, MobileContext context) {
        super(example, context);
        this.basePageLoaded();
    }

    private UIElement btnPopUp() {
        return this.wait.waitForVisible(this.locators.byText("Login (pop-up)"));
    }

    private UIElement btnFullScreen() {
        return this.find.byTextContains("Login (full-screen)");
    }

    public void tapPopUpBtn() {
        this.btnPopUp().tap();
        this.log.info("Tap on 'pop-up' button.");
    }

    public void tapFullScreenBtn() {
        this.btnFullScreen().click();
        this.log.info("Tap on 'full-screen' button.");
    }

    public UIElement textView() {
        if (this.settings.platform == PlatformType.Android) {
            this.wait.waitForVisible(this.locators.textViewLocator());
            return this.find.elementsByLocator(this.locators.textViewLocator()).get(1);
        } else if (this.settings.platform == PlatformType.iOS) {
            return this.find.byLocator(this.locators.labelLocator());
        } else {
            return null;
        }
    }

    private UIElement btnLogin() {
        return this.wait.waitForVisible(this.locators.byText("Login"));
    }

    public void tapLoginBtn() {
        this.btnLogin().click();
        this.log.info("Tap on 'login' button.");
    }

    public void modalViewLoaded() {
        if (this.btnLogin() != null) {
            this.log.info("ModalView loaded.");
        } else {
            Assert.fail("ModalView NOT loaded.");
        }
    }

    public void basePageLoaded() {
        if (this.btnPopUp() != null) {
            this.log.info("ModalView page loaded.");
        } else {
            Assert.fail("ModalView page NOT loaded.");
        }
        if (this.settings.platform != PlatformType.iOS) {
            Assert.assertEquals(this.textView().getText(), "Anonymous");
        }
    }
}