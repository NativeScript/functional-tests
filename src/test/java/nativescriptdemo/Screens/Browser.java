package nativescriptdemo.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.element.UIRectangle;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.find.Wait;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

public class Browser extends BasePage {

    private UIRectangle iosWebBackBtnRect;

    public Browser(MobileContext context) {
        super(context);
    }

    private void loaded(String content) {
        UIElement element;
        if (this.settings.platform == PlatformType.Android) {
            element = this.wait.waitForVisible(this.locators.byText(content, false, false), this.settings.defaultTimeout, false);
        } else {
            element = this.wait.waitForVisible(By.id("URL"), 6, true);
        }
        if (element != null) {
            this.log.info("Browser loaded.");
        } else {
            Assert.fail("Browser NOT loaded!");
        }
    }

    private void unloaded(String content) {
        Boolean isVisible;
        if (this.settings.platform == PlatformType.Android) {
            isVisible = this.wait.waitForNotVisible(this.locators.byText(content, false, false), this.settings.shortTimeout, true);
        } else if (this.settings.platform == PlatformType.iOS) {
            isVisible = this.wait.waitForNotVisible(By.id("URL"), this.settings.shortTimeout, true);
        } else {
            isVisible = null;
        }

        if (isVisible) {
            Assert.fail("Browser NOT unloaded! It is still visible.");
        } else {
            this.log.info("Browser unloaded. It is not visible.");
        }
    }

    private void closeWithBackNavigation() {
        if (this.settings.platform == PlatformType.Android) {
            this.navigateBack();
            Wait.sleep(500);
        } else if (this.settings.platform == PlatformType.iOS) {
            if (iosWebBackBtnRect == null) {
                String element = "XCUIElementTypeWindow";
                if (this.settings.platformVersion < 10) {
                    element = "UIAWindow";
                }
                List<UIElement> windows = this.find.elementsByLocator(By.className(element));
                this.iosWebBackBtnRect = new UIRectangle(windows.get(windows.size() - 1).findElement(this.locators.byText("Return to Examples NativeScript")).getUIRectangle());
                this.iosWebBackBtnRect.extendRectangle(5, 5, 0, 0);
            }

            this.iosWebBackBtnRect.tap();
        }
    }

    public void handle(String elementText, String screenshotName) {
        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion >= 7.1) {
            // Android 7.1 emulator open a dialog that prompt for browser here.
        } else {
            this.loaded(elementText);
        }
        this.log.logScreen(screenshotName, screenshotName);
        this.closeWithBackNavigation();
        // Hack to fix tests on Api17 and Api18 emulators
        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion <= 4.3) {
            this.closeWithBackNavigation();
        }
        this.unloaded(elementText);
    }
}
