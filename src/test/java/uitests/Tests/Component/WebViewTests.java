package uitests.Tests.Component;

import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;

public class WebViewTests extends MobileTest {

    @Test(groups = {"android", "ios"})
    public void webView_01() throws Exception {
        String webView = "webview";
        String webTest = "webtest";
        if (this.settings.platformVersion >= 7 && this.settings.platform == PlatformType.Android) {
            webView = "WEBVIEW";
        }
        HomePageExtended homePage = new HomePageExtended(webView, this.context);
        UIElement element = this.find.byTextContains(webTest);
        homePage.navigateTo(element);
        if (this.settings.platform == PlatformType.Android) {
            homePage.wait.waitForVisible(this.locators.webViewLocator(), 6, true);
        } else if (this.settings.platform == PlatformType.iOS) {
            homePage.find.byLocator(this.locators.labelLocator());
        }

        double tolerance = 0.1;
        if (this.settings.platformVersion == 4.2) {
            tolerance = 11;
        }
        this.compareScreens(this.settings.defaultTimeout * 5, tolerance);
        this.assertImagesResults();
    }

//    @Test(groups = {"android", "ios"})
//    public void webView_02() throws Exception {
//        GalleryHomePage.homePageLoaded();
//        GalleryHomePage.navigateTo("webview");
//        WebViewPage.homePageLoaded();
//        ImageVerification.waitForScreen(  0.01, this.settings.shortTimeout);
//        WebViewPage.navigateBack();
//    }
}
