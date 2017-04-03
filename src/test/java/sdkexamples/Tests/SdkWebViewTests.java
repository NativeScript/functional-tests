package sdkexamples.Tests;

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
                {pageWebViewCode, "OK"},
                {pageWebViewHtml, null},
        };
    }

    @Test(dataProvider = "example")
    public void sdkWebViewTest(String example, String btn) throws Exception {
        this.mainPage.navigateTo(example);
        if (btn != null) {
            this.wait.waitForVisible(this.locators.byText(btn), settings.shortTimeout, false).tap();
            if (!this.wait.waitForNotVisible(this.locators.byText("OK"))) {
                this.wait.waitForVisible(this.locators.byText(btn), settings.shortTimeout, false).tap();

            }
        }
        this.log.logScreen(example);
    }
}
