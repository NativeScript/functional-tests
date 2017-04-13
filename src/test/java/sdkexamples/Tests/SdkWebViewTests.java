package sdkexamples.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIRectangle;
import functional.tests.core.mobile.find.Wait;
import org.openqa.selenium.By;
import org.springframework.util.Assert;
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

        Wait.sleep(10000);
        if (example == pageWebViewCode) {
            if (this.settings.platform == PlatformType.iOS) {
                UIRectangle doneBtn = new UIRectangle(new Rectangle(17, 25, 200, 200), this.context);
                doneBtn.tap();
                doneBtn.tap();
            }

           this.wait.waitForVisible(this.locators.byText("WebView finished loading",false,false),true);
        }

        this.log.logScreen(example);
    }
}