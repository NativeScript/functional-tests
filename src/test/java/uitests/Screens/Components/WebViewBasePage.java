package uitests.Screens.Components;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import io.appium.java_client.MobileBy;
import org.testng.Assert;
import uitests.Screens.HomePageExtended;

public class WebViewBasePage extends HomePageExtended {

    public WebViewBasePage(MobileContext context) {
        super("webview", context);
    }

    public void navToPage(String page) {
        boolean result = this.navigateTo(page, true);
        Assert.assertTrue(result, String.format("Failed to navigate to %s page.", page));
    }

    private UIElement findElement(String text) {
        if (this.settings.platform == PlatformType.Android) {
            return this.findElement(text);
        } else {
            return this.wait.waitForVisible(MobileBy.AccessibilityId(text));
        }
    }

    public void tapRelativeBtn() {
        this.findElement("rel").click();
    }

    public void tapAbsoluteBtn() {
        this.findElement("abs").click();
    }

    public void tapFileBtn() {
        this.findElement("file").click();
    }

    public void tapStringBtn() {
        this.findElement("str").click();
    }

    public UIElement srcWebView() {
        return this.findElement("someUrl | pathToLocalFile | htmlString");
    }

    public UIElement strResult() {
        return this.findElement("Result");
    }

    public UIElement strFooBar() {
        return this.find.byTextContains("foo: bar");
    }

    public UIElement strUrlTypeRelative() {
        return this.find.byTextContains("urlType: relative");
    }

    public UIElement strUrlTypeAbsolute() {
        return this.find.byTextContains("urlType: absolute");
    }

    public UIElement strUrlTypeFilePrefix() {
        return this.find.byTextContains("urlType: filePrefix");
    }

    public UIElement str() {
        return this.find.byText("Just a string ...");
    }
}
