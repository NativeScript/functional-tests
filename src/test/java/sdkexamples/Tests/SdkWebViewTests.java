package sdkexamples.Tests;

import org.springframework.util.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkWebViewTests extends SdkBaseTest {

    private final String pageWebViewCode = "Basic WebView";
    private final String pageWebViewHtml = "HTML as source of WebView";
    protected String page = "WebView";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {pageWebViewCode},
                {pageWebViewHtml},
        };
    }

    @Test(dataProvider = "example")
    public void sdkWebViewTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
        if (example == pageWebViewCode) {
            this.wait.waitForVisible(this.locators.webViewLocator(), true);
            if (this.settings.platformVersion != 5.0) {
                this.wait.waitForVisible(this.locators.byText("WebView finished loading of", false, false), true);
            }
        } else if (example == pageWebViewHtml) {
            Assert.notNull(this.find.byText("First WebView"));
        }
        this.log.logScreen(example);
    }
}