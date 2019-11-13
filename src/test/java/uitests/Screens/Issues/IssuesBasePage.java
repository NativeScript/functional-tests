package uitests.Screens.Issues;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import io.appium.java_client.MobileBy;
import org.testng.Assert;
import uitests.Screens.HomePageExtended;

public class IssuesBasePage extends HomePageExtended {

    public IssuesBasePage(MobileContext context) {
        super("issues", context);
    }

    public void navToPage(String page) {
        this.navigateToMainPage();
        boolean result = this.navigateTo(page);
        Assert.assertTrue(result, "Failed to navigate to " + page);
    }

    public UIElement findElement(String text) {
        if (this.settings.platform == PlatformType.Android) {
            return this.find.byText(text);
        } else {
            return this.find.byLocator(MobileBy.AccessibilityId(text));
        }
    }
}
