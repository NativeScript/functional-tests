package plugins.push.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.settings.Settings;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    private UIElement enableButton() {
        if (this.settings.platform == PlatformType.Andorid) {
            return this.find.byText("Enable Notifications");
        } else {
            return this.find.byLocator(By.id("Enable Notifications"));
        }
    }

    private UIElement disableButton() {
        if (this.settings.platform == PlatformType.Andorid) {
            return this.find.byText("Disable Notifications");
        } else {
            return this.find.byLocator(By.id("Disable Notifications"));
        }
    }

    public void enableNotifications() {
        this.enableButton().tap(1, Settings.DEFAULT_TAP_DURATION);
        this.log.info("Enable push notifications.");
    }

    public void disableNotifications() {
        this.disableButton().tap(1, Settings.DEFAULT_TAP_DURATION);
        this.log.info("Disable push notifications.");
    }

    public void loaded() {
        this.enableButton();
        this.log.info("Push notification home page loaded.");
    }
}
