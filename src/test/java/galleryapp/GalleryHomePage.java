package galleryapp;

import functional.tests.core.mobile.basepage.BasePageExtended;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.helpers.NavigationHelper;
import io.appium.java_client.SwipeElementDirection;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GalleryHomePage extends BasePageExtended {

    public GalleryHomePage(String homePage, MobileContext context) {
        super(homePage, context);
        loaded();

    }

    public void navigateTo(String example, By locator) {
        this.navigationManager.navigateToMainPage();

        UIElement element;
        if (this.settings.platform == PlatformType.Android) {
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

    private void loaded() {
        UIElement element = null;
        if (this.settings.platform == PlatformType.Android) {
            element = this.find.byText("TestApp");
        } else {
            element = this.find.byLocator(this.locators.scrollViewLocator());
        }
        if (element != null) {
            this.log.info("Gallery app loaded.");
        } else {
            this.log.info("Gallery app NOT loaded!");
            Assert.fail("Gallery app NOT loaded!");
        }
    }
}
