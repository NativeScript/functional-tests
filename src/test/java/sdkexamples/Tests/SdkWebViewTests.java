package sdkexamples.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Wait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.openqa.selenium.By;
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
    public void sdkWebViewTest(String example) {
        this.mainPage.navigateTo(example);
        if (example.equalsIgnoreCase(pageWebViewCode)) {
            // Check default example
            By locator = this.locators.byText("WebView finished loading", false, false);
            UIElement loaded = this.wait.waitForVisible(locator, this.settings.defaultTimeout, false);
            Assert.notNull(loaded, "Failed to find label showing site is loaded!");
            UIElement docsSiteContent = this.find.byTextContains("NativeScript Documentation");
            Assert.notNull(docsSiteContent, "{N} Docs site not loaded!");
            log.info("{N} Docs website loaded!");

            // Navigate to not existing page.
            log.info("Navigate to http://no.site");
            this.find.byLocator(this.locators.editTextLocator()).setText("http://no.site");
            this.find.byLocator(this.locators.editTextLocator()).tap();

            // On Android default not found page is displayed.
            if (this.settings.platform == PlatformType.Android) {
                ((AndroidDriver) this.client.driver).pressKeyCode(66);
                UIElement notFoundMessage = this.find.byTextContains("Webpage not available");
                Assert.notNull(notFoundMessage, "{N} Docs site not loaded!");
            }
            // On iOS old page is displayed
            if (this.settings.platform == PlatformType.iOS) {
                ((IOSDriver) this.client.driver).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
                Wait.sleep(3000);
                docsSiteContent = this.find.byTextContains("NativeScript Documentation");
                Assert.notNull(docsSiteContent, "{N} Docs site not loaded!");
            }
        } else if (example.equalsIgnoreCase(pageWebViewHtml)) {
            By locator = this.locators.byText("First WebView", false, false);
            UIElement inlineWV = this.wait.waitForVisible(locator, this.settings.defaultTimeout, false);
            Assert.notNull(inlineWV, "WebView with inline source not displayed.");
            UIElement webViewFromFile = this.find.byTextContains("Firstname");
            Assert.notNull(webViewFromFile, "WebView from local html file not displayed.");
        }
        this.log.logScreen(example);
    }
}