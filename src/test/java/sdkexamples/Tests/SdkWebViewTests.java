package sdkexamples.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIRectangle;
import functional.tests.core.mobile.find.Wait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

import java.awt.*;

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
        String msg = "WebView finished loading";
        Wait.sleep(10000);
        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 4.4 && example == pageWebViewCode) {
            this.assertScreen(this.context.getTestName() + "_" + example, 20);
        } else if (this.settings.platform == PlatformType.Android && example == pageWebViewCode && this.settings.platformVersion != 4.4) {
            this.context.getDevice().assertLogContains(msg);
            this.log.logScreen(example);
        } else if (example == pageWebViewCode && this.settings.platform == PlatformType.iOS) {
            UIRectangle doneBtn = new UIRectangle(new Rectangle(17, 25, 200, 200), this.context);
            doneBtn.tap();
            doneBtn.tap();
            this.assertScreen(20);
        }
    }
}
