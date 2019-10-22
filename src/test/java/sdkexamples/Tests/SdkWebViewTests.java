package sdkexamples.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import org.springframework.util.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkWebViewTests extends SdkBaseTest {

    private final String pageViewViewUsage = "Usage";
    private final String pageWebViewTips = "Tips & Tricks";
    protected String page = "WebView";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {pageViewViewUsage},
                {pageWebViewTips}
        };
    }

    @Test(dataProvider = "example")
    public void sdkWebViewTest(String example) {
        this.mainPage.navigateTo(example);
        if (example.equalsIgnoreCase(pageViewViewUsage)) {
            if (this.settings.platform == PlatformType.Android) {
                UIElement element = this.find.byText("Get Started");
                Assert.notNull(element, "WebView with {N} docs not loaded.");
            } else {
                UIElement element = this.find.byText("NativeScript Documentation");
                Assert.notNull(element, "WebView with {N} docs not loaded.");
            }
        } else if (example.equalsIgnoreCase(pageWebViewTips)) {
            UIElement element = this.find.byText("My First Heading");
            Assert.notNull(element, "Tips & Tricks web page not loaded.");
        }
    }
}