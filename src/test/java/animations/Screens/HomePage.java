package animations.Screens;

import functional.tests.core.basepage.BasePageExtended;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.exceptions.AppiumException;
import functional.tests.core.helpers.NavigationHelper;
import io.appium.java_client.SwipeElementDirection;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends BasePageExtended {

    public HomePage(String mainTestPage, Context context) {
        super(mainTestPage, context);
        if (mainTestPage != "") {
            this.navigateTo(mainTestPage);
        }
    }

    private UIElement title() {
        return this.find.byText("Animations");
    }

    private UIElement button() {
        return this.find.byText("multiple-properties");
    }

    public void loaded() throws AppiumException {
        if (this.button() != null) {
            this.log.info("Animations app home page loaded.");
        } else {
            Assert.fail("Animations app home page NOT loaded.");
        }
    }

    public void navigateTo(String example, By locator) {
        this.navigationManager.navigateToMainPage();

        UIElement element;
        if (this.settings.platform == PlatformType.Andorid) {
            element = this.gestures.swipeInWindowToElement(SwipeElementDirection.DOWN, this.locators.byText(example), 10, 250, 250);
        } else {
            element = NavigationHelper.scrollTo(example, this.context, 5);
        }

        if (element == null) {
            this.log.error("Example is not found");
        } else {
            this.navigateTo(element, example);
        }
        if (locator != null) {
            this.wait.waitForVisible(locator, this.settings.shortTimeout, true);
        }
    }
}