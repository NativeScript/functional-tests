package sdkexamples.Tests;

import org.openqa.selenium.By;
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
                {pageWebViewCode, this.mainPage.btnOkLocator()},
                {pageWebViewHtml, null},
        };
    }

    @Test(dataProvider = "example")
    public void sdkWebViewTest(String example, By locator) throws Exception {
        this.mainPage.navigateTo(example);
        if (locator != null) {
            this.wait.waitForVisible(locator, settings.shortTimeout, false).tap();
        }
        this.log.logScreen(example);
    }
}
