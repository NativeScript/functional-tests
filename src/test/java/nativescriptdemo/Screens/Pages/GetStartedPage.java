package nativescriptdemo.Screens.Pages;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GetStartedPage extends BasePage {

    public GetStartedPage() {
        super();
    }

    private UIElement btnGetStarted() {
        return this.find.byLocator(this.getStartedLocator());
    }

    public void loaded() {
        UIElement element = this.wait.waitForVisible(this.getStartedLocator(), 5, false);
        if (element != null) {
            this.log.info("Get Started page loaded.");
        } else {
            Assert.fail("Get Started page NOT loaded!");
        }
    }

    public void unloaded() {
        Boolean isVisible = this.wait.waitForNotVisible(this.getStartedLocator(), 5, true);
        if (isVisible) {
            Assert.fail("Get Started page NOT unloaded! Ils -lat is still visible.");
        } else {
            this.log.info("Get Started page unloaded. It is not visible.");
        }
    }

    public void tapGetStarted() {
        this.btnGetStarted().tap();
    }

    private By getStartedLocator() {
        return this.locators.byText("GET STARTED", false, false);
    }

    public void allowPermissions() {
        if (this.settings.platform == PlatformType.iOS) {
            UIElement btnAllow;
            if (this.settings.platformVersion < 10) {
                btnAllow = this.wait.waitForVisible(By.id("OK"));
            } else {
                btnAllow = this.wait.waitForVisible(this.locators.byText("Allow", false, false));
            }
            if (btnAllow != null) {
                btnAllow.tap();
            }
        }
    }

}
