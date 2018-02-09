package nativescriptdemo.Screens.Pages;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
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
        UIElement element = this.wait.waitForVisible(this.getStartedLocator(), this.settings.defaultTimeout, false);
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
        this.allowPermissions();
    }

    private By getStartedLocator() {
        return this.locators.byText("GET STARTED", false, false);
    }

    public void allowPermissions() {
        if (this.settings.platform == PlatformType.iOS) {
            UIElement btnAllow = this.find.byText("Allow", this.settings.shortTimeout);
            if (btnAllow != null) {
                btnAllow.tap();
                this.log.info("Popup dialog handled!");
            } else {
                try {
                    this.client.driver.switchTo().alert().accept();
                    this.log.info("Popup dialog handled!");
                } catch (Exception e) {
                    this.log.info("Popup dialog not found.");
                }
            }
        }
    }

}
