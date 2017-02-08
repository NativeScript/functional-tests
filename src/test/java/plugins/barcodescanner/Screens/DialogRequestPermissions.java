package plugins.barcodescanner.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;

public class DialogRequestPermissions extends BasePage {

    public DialogRequestPermissions() {
        super();
    }

    public UIElement title() {
        return this.find.byLocator(this.locators.findByTextLocator("take pictures and record video", false));
    }

    private UIElement denyButton() {
        return this.find.byLocator(this.locators.findByTextLocator("android.widget.Button", "Deny", true, false));
    }

    private UIElement allowButton() {
        return this.find.byLocator(this.locators.findByTextLocator("android.widget.Button", "Allow", true, false));
    }

    public void tapDeny() {
        this.denyButton().click();
        this.log.info("Tap Deny.");
    }

    public void allowPermissions() throws InterruptedException {
        if (settings.platform == PlatformType.Andorid) {
            this.allowButton().click();
        } else {
            UIElement btnOk = this.wait.waitForVisible(this.locators.byText("OK"));
            if (btnOk != null) {
                btnOk.tap();
            }
        }
    }

    public void assertIsAvailable() {
        this.wait.waitForVisible(this.locators.findByTextLocator("YES", true), true);
    }

    public void submitDialog(String bntContent) {
        this.wait.waitForVisible(this.locators.byText(bntContent)).tap();
    }

    /**
     * Verify the home page has loaded
     **/
    public void reuestDialogLoaded() {
        this.title();
        this.log.info("RequestPermissions dialog page loaded.");
    }

    /**
     * Verify the home page has loaded
     **/
    public void unloaded() {
        if (this.settings.platform == PlatformType.Andorid) {
            this.wait.waitForNotVisible(this.locators.findByTextLocator("Allow demo to take pictures and record video?", true), this.settings.shortTimeout, true);
            this.log.info("HasPermissions dialog unloaded.");
        } else {

        }
    }
}
