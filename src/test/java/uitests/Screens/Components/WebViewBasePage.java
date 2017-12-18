package uitests.Screens.Components;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import uitests.Screens.HomePageExtended;

public class WebViewBasePage extends HomePageExtended {

    public WebViewBasePage(MobileContext context) {
        super("webview", context);
    }

    public boolean navToPage(String page) {
        boolean result = this.navigateTo(page, true);
        this.wait.waitForNotVisible(this.locators.byText(page, false, false), 6, false);
        return result;
    }

    public void tapRelativeBtn() {
        this.wait.waitForVisible(this.locators.byText("rel")).click();
    }

    public void tapAbsoluteBtn() {
        this.wait.waitForVisible(this.locators.byText("abs")).click();
    }

    public void tapFileBtn() {
        this.wait.waitForVisible(this.locators.byText("file")).click();
    }

    public void tapStringBtn() {
        this.wait.waitForVisible(this.locators.byText("str")).click();
    }

    public UIElement srcWebView() {
        return this.find.byText("someUrl | pathToLocalFile | htmlString");
    }

    public UIElement strResult() {
        return this.wait.waitForVisible(this.locators.byText("Result", false, false));
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
