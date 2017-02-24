package plugins.firebase.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.find.Wait;
import functional.tests.core.settings.Settings;
import org.openqa.selenium.By;

public class DemoPage extends BasePage {

    public DemoPage() {
        super();
    }

    private By initButtonLocator() {
        if (this.settings.platform == PlatformType.Android) {
            return this.locators.findByTextLocator("init firebase - do this first", true);
        } else {
            return By.id("init firebase - do this first");
        }
    }

    private By storeByPushLocator() {
        if (this.settings.platform == PlatformType.Android) {
            return this.locators.findByTextLocator("store by push", true);
        } else {
            return By.id("store by push");
        }
    }

    private By addChildButtonLocator() {
        if (this.settings.platform == PlatformType.Android) {
            return this.locators.findByTextLocator("add childlistener", true);
        } else {
            return By.id("add childlistener");
        }
    }

    private By removePathButtonLocator() {
        if (this.settings.platform == PlatformType.Android) {
            return this.locators.findByTextLocator("remove path", true);
        } else {
            return By.id("remove path");
        }
    }

    private UIElement initButton() {
        UIElement element = this.find.byLocator(initButtonLocator(), this.settings.defaultTimeout);
        Wait.sleep(1000);
        return element;
    }

    private UIElement storeByPushButton() {
        UIElement element = this.find.byLocator(storeByPushLocator(), this.settings.defaultTimeout);
        Wait.sleep(1000);
        return element;
    }

    private UIElement addChildButton() {
        UIElement element = this.find.byLocator(addChildButtonLocator(), this.settings.defaultTimeout);
        Wait.sleep(1000);
        return element;
    }

    private UIElement removePathButton() {
        UIElement element = this.find.byLocator(removePathButtonLocator(), this.settings.defaultTimeout);
        Wait.sleep(1000);
        return element;
    }

    /**
     * Verify the home page has loaded
     **/
    public void loaded() {
        this.wait.waitForVisible(initButtonLocator(), true);
        this.log.info("Demo page of Firebase example loaded.");
    }

    /**
     * Tap init button
     **/
    public void init() {
        this.initButton().tap(1, Settings.DEFAULT_TAP_DURATION);
        this.log.info("Init Firebase.");

        // Handle ready dialog
//        UIElement dialog = find.findByText("Merci!");
//       this.log.info("Ready dialog found.");
//        dialog.tap(1, Settings.DEFAULT_TAP_DURATION);
//       this.log.info("Handle ready dialog.");
    }

    /**
     * Tap init button
     **/
    public void storeByPush() {
        this.storeByPushButton().tap(1, Settings.DEFAULT_TAP_DURATION);
        this.log.info("Store items by push.");
    }

    /**
     * Tap add child
     **/
    public void addChild() {
        this.addChildButton().tap(1, Settings.DEFAULT_TAP_DURATION);
        this.log.info("Tap add child.");
    }

    /**
     * Tap add child
     **/
    public void removePath() {
        this.removePathButton().tap(1, Settings.DEFAULT_TAP_DURATION);
        this.log.info("Tap remove users.");
    }

    public void verifyTextVisible(String childRemoved) {
    }
}
