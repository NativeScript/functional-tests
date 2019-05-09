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
            // Appium crash on get page source -> find by text contains do not work (may be caused by appium@1.9.1).
            if (this.settings.platformVersion > 5.0) {
                // Check default example
                By locator = this.locators.byText("WebView finished loading", false, false);
                UIElement loaded = this.wait.waitForVisible(locator, this.settings.defaultTimeout, false);
                Assert.notNull(loaded, "Failed to find label showing site is loaded!");
                UIElement docsSiteContent = this.find.byTextContains("NativeScript Documentation");
                Assert.notNull(docsSiteContent, "{N} Docs site not loaded!");
                log.info("{N} Docs website loaded!");
            }
            UIElement stillLoading = this.find.byTextContains("WebView is still");
            while (stillLoading != null) {
                Wait.sleep(1000);
                stillLoading = this.find.byTextContains("WebView is still");
            }
            // Navigate to not existing page.
            log.info("Navigate to http://no.site");
            UIElement edit = this.find.byLocator(this.locators.editTextLocator(), this.settings.defaultTimeout);
            Assert.notNull(edit, "Can not find edit text to type url.");
            edit.setText("http://no.site");
            edit.tap();

            // On Android default not found page is displayed.
            if (this.settings.platform == PlatformType.Android) {
                ((AndroidDriver) this.client.driver).pressKeyCode(66);
                By locator = this.locators.byText("Webpage not available", false, false);
                UIElement loaded = this.wait.waitForVisible(locator, this.settings.defaultTimeout, false);
                Assert.notNull(loaded, "Default 'Not found page' not loaded!");
            }
            // On iOS old page is displayed
            if (this.settings.platform == PlatformType.iOS) {
                ((IOSDriver) this.client.driver).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
                Wait.sleep(3000);
                UIElement docsSiteContent = this.find.byTextContains("NativeScript Documentation");
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