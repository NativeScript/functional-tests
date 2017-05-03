package plugins.imageupload.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.settings.Settings;
import org.openqa.selenium.By;


public class HomePage extends BasePage {

    public HomePage(MobileContext context) {
        super(context);
    }

    private By pickSingleLocator() {
        if (this.settings.platform == PlatformType.Android) {
            return this.locators.findByTextLocator("Pick & Upload Single Image", true);
        } else {
            return By.id("Pick Single");
        }
    }

    private By pickMultipleLocator() {
        if (this.settings.platform == PlatformType.Android) {
            return this.locators.findByTextLocator("Pick & Upload Multiple Images", true);
        } else {
            return By.id("Pick Multiple");
        }
    }

    private UIElement pickSingleButton() {
        return this.find.byLocator(pickSingleLocator());

    }

    private UIElement pickMultipleButton() {
        return this.find.byLocator(pickMultipleLocator());
    }

    /**
     * Verify the home page has loaded
     **/
    public void loaded() {
        this.wait.waitForVisible(pickMultipleLocator(), true);
        this.log.info("ImagePicker example app loaded.");
    }

    /**
     * Pick single image
     **/
    public void pickSingleImage() {
        this.pickSingleButton().tap(1, Settings.DEFAULT_TAP_DURATION);
        this.log.info("Tap pick single.");
    }

    /**
     * Pick multiple images
     **/
    public void pickMultipleImages() {
        this.pickMultipleButton().tap(1, Settings.DEFAULT_TAP_DURATION);
        if (this.settings.platformVersion.toString().contains("6.")) {
            UIElement allow = this.find.byText("Allow");
            allow.tap();
        }
        this.log.info("Tap pick multiple.");
    }
}
