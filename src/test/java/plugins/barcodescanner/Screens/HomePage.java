package plugins.barcodescanner.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;

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
        return this.find.byText("Demo");
    }

    public void tapAbout() {
        this.aboutButton().click();
        this.log.info("Tap About.");
    }

    public DemoPage tapDemo() {
        this.demoButton().click();
        this.log.info("Tap Demo.");

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
