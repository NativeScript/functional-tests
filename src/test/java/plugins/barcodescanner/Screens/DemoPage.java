package plugins.barcodescanner.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import io.appium.java_client.SwipeElementDirection;

public class DemoPage extends BasePage {

    public DemoPage() {
        super();
        this.loaded();
    }

    public void checkIfAvailable() {
        this.find.byTextContains("available?").tap();
    }

    public UIElement checkPermissionButton() {
        return this.find.byText("has permission?");
    }

    public DialogRequestPermissions requestPermissionsButton() {
        this.find.byText("request permission").tap();
        return new DialogRequestPermissions();
    }

    public void backCameraWithFlip() {
        this.gestures.swipeInWindowToElement(SwipeElementDirection.DOWN, this.locators.byText("back camera, with flip"), 1, 800, 50).tap();
    }

    public UIElement frontCammeraButton() {
        return this.find.byText("front camera, no flip (Android)");
    }

    /**
     * Verify the home page has loaded
     **/
    public void loaded() {
        this.log.info("Demo page loaded.");
    }

    public void exitBarcodeScanner() {
        this.wait.waitForVisible(this.locators.findByTextLocator("EXIT", false), true).tap();
    }

    public void assertBarcodeScannerIsLoaded() {
        this.wait.waitForVisible(this.locators.findByTextLocator("Use the volume buttons for extra light", false), true);
    }
}
