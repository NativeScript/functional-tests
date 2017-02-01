package plugins.barcodescanner.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;

public class DemoPage extends BasePage {

    public DemoPage() {
        super();
        this.loaded();
    }

    public UIElement availableButton() {
        return this.find.byTextContains("available?");
    }

    public UIElement checkPermissionButton() {
        return this.find.byText("has permission?");
    }

    public UIElement requestPermissionsButton() {
        return this.find.byText("request permission");
    }

    public UIElement backCammeraButton() {
        return this.find.byText("back camera, with flip");
    }

    public UIElement frontCammeraButton() {
        return this.find.byText("front camera, no flip (Android)");
    }

    /**
     * Verify the home page has loaded
     **/
    public void loaded() {
        this.availableButton();
        this.log.info("Demo page loaded.");
    }
}
