package erroractivity.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public HomePage(Context context) {
        super(context);
    }

    private UIElement tapButton() {
        if (this.settings.platform == PlatformType.Andorid) {
            return this.find.byText("TAP");
        } else {
            return this.find.byLocator(By.id("TAP"));
        }
    }

    public UIElement exceptionButton() {
        if (this.settings.platform == PlatformType.Andorid) {
            UIElement exception = this.find.byText("Exception", this.settings.shortTimeout);
            // TODO: Remove this if after {N} 2.3 release.
            if (exception == null) {
                exception = this.find.byText("Unhandled Exception", this.settings.shortTimeout);
            }
            return exception;
        } else {
            return null;
        }
    }

    public void tap() {
        this.tapButton().click();
        this.log.info("Tap \"Tap\" button");
    }

    public void loaded() {
        this.tapButton();
        this.log.info("HelloWorld app home page loaded.");
    }
}