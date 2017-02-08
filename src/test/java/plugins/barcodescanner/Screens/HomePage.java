package plugins.barcodescanner.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import io.appium.java_client.SwipeElementDirection;

import java.awt.*;

public class HomePage extends BasePage {

    public HomePage() {
        super();
        try {
            this.loaded();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public UIElement aboutButton() {
        return this.find.byText("About");
    }

    public UIElement demoButton() {
        return this.wait.waitForVisible(this.locators.byText("Demo", false, false));
    }

    public void tapAbout() {
        this.aboutButton().click();
        this.log.info("Tap About.");
    }

    public DemoPage tapDemo() {
        if (this.settings.platform == PlatformType.iOS) {
            this.demoButton().tap();
            this.log.info("Tap Demo.");
        } else {
            Rectangle window = new Rectangle(2, 200, this.context.getDevice().getWindowSize().width, this.context.getDevice().getWindowSize().height);
            this.gestures.swipeInRectangle(SwipeElementDirection.RIGHT, window, 500, 500);
            this.app.slideBack();
        }
        return new DemoPage();
    }

    /**
     * Verify the home page has loaded
     **/
    public void loaded() throws InterruptedException {
        this.aboutButton();
        this.log.info("BarcodeScanner plugin demo app loaded.");
    }
}
