package plugins.barcodescanner.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;

public class DialogRequestPermissions extends BasePage {

    public DialogRequestPermissions( ) {
        super();
        this.loaded();
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

    public void tapAllow() throws InterruptedException {
        this.allowButton().click();
       this.log.info("Tap allow");
    }

    /**
     * Verify the home page has loaded
     **/
    public void loaded() {
        this.title();
       this.log.info("RequestPermissions dialog page loaded.");
    }

    /**
     * Verify the home page has loaded
     **/
    public void unloaded() {
        this.wait.waitForNotVisible(this.locators.findByTextLocator("Allow demo to take pictures and record video?", true), this.settings.shortTimeout, true);
       this.log.info("HasPermissions dialog unloaded.");
    }
}
