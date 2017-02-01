package plugins.barcodescanner.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;

public class DialogHasPermissions extends BasePage {

    public DialogHasPermissions() {
        super();
    }

    public UIElement title() {
        return this.find.byText("Permission granted?");
    }

    private UIElement okButton() {
        return this.find.byText("OK");
    }

    public void tapOK() {
        this.okButton().click();
        this.log.info("Tap OK.");
    }

    private UIElement resultTextBox() {
        if (this.settings.platform == PlatformType.Andorid) {
            return this.find.byType("android.widget.ScrollView//android.widget.TextView");
        } else {
            return this.find.byType("UIAScrollView//UIAStaticText");
        }
    }

    public String getResultString() {
        return this.resultTextBox().getText();
    }

    /**
     * Verify the home page has loaded
     **/
    public void loaded() {
        this.title();
        this.log.info("HasPermissions dialog page loaded.");
    }

    /**
     * Verify the home page has loaded
     **/
    public void unloaded() {
        this.wait.waitForNotVisible(this.locators.findByTextLocator("Permission granted?", true), this.settings.shortTimeout, true);
        this.log.info("HasPermissions dialog unloaded.");
    }
}
