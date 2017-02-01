package plugins.imageupload.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.settings.Settings;
import org.openqa.selenium.By;


public class HomePage extends BasePage {

    public HomePage(Context context) {
        super(context);
    }

    private By pickSingleLocator() {
        if (this.settings.platform == PlatformType.Andorid) {
            return this.locators.findByTextLocator("Pick Single", true);
        } else {
            return By.id("Pick Single");
        }
    }

    private By pickMultipleLocator() {
        if (this.settings.platform == PlatformType.Andorid) {
            return this.locators.findByTextLocator("Pick Multiple", true);
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
        this.log.info("Tap pick multiple.");
    }
}
