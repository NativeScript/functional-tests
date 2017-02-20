package plugins.firebase.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.settings.Settings;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public HomePage( ) {
        super();
    }

    private By titleLocator() {
        if (this.settings.platform == PlatformType.Android) {
            return this.locators.findByTextLocator("Firebase plugin demo", true);
        } else {
            return By.id("Firebase plugin demo");
        }
    }

    private UIElement demoButton() {
        return this.find.byText("Demo");
    }

    /**
     * Verify the home page has loaded
     **/
    public void loaded() {
        this.wait.waitForVisible(titleLocator(), true);
       this.log.info("Firebase example app loaded.");
    }

    /**
     * Navigate to real demo
     **/
    public void navigateToDemo() {
        this.demoButton().tap(1, Settings.DEFAULT_TAP_DURATION);
       this.log.info("Navigate to demo page.");
    }
}
