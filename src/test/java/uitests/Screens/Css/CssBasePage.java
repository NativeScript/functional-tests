package uitests.Screens.Css;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileContext;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import uitests.Screens.HomePageExtended;

public class CssBasePage extends HomePageExtended {

    public CssBasePage(MobileContext context) {
        super("css", context);
    }

    public void navToPage(String page) {
        boolean result = this.navigateTo(page);
        Assert.assertTrue(result, String.format("Failed to navigate to %s", page));
    }

    public void tapChangeBtn() {
        if (this.settings.platform == PlatformType.Android) {
            this.find.byText("Change").click();
        } else {
            this.find.byLocator(MobileBy.AccessibilityId("Change")).click();
        }
    }

    public void waitForElement(String text) {
        By locator = this.locators.byText(text, true, false);
        if (this.settings.platform == PlatformType.iOS) {
            locator = MobileBy.AccessibilityId(text);
        }
        this.wait.waitForVisible(locator, 6, true);
    }
}
