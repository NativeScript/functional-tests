package nativescriptdemo.Tests;

import functional.tests.core.mobile.element.UIRectangle;
import nativescriptdemo.Screens.Browser;
import nativescriptdemo.Screens.Components.SideDrawer;
import nativescriptdemo.Screens.Pages.AboutPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SideDrawerTests extends QsfBaseTest {

    private SideDrawer sideDrawer;
    private AboutPage aboutPage;
    private Browser browser;
    private UIRectangle iosWebBackBtnRect;

    @BeforeClass(groups = {"android", "ios"})
    public void beforeQsfGeneralTestsClass() {
        this.sideDrawer = new SideDrawer(this.context);
        this.aboutPage = new AboutPage(this.context);
        this.browser = new Browser(this.context);
    }

    @Test(groups = {"android", "ios"})
    public void test_01_home() throws Exception {
        this.homePage.tapSideDrawer();
        this.sideDrawer.tapHome();
        this.homePage.loaded();
    }

    @Test(groups = {"android", "ios"})
    public void test_02_about() throws Exception {
        this.homePage.tapSideDrawer();
        this.sideDrawer.tapAbout();
        this.aboutPage.loaded();
        this.log.logScreen("AboutPage", "AboutPage");
        this.aboutPage.navigateBack();
        this.homePage.loaded();
    }

    @Test(groups = {"android", "browser"})
    public void test_03_sideDrawer_gettingStarted() throws Exception {
        this.homePage.loaded();
        this.homePage.tapSideDrawer();
        this.sideDrawer.tapGettingStarted();
        this.browser.handle("docs.nativescript.org", "ExternalLins_GettingStarted");
    }

    @Test(groups = {"android", "browser"})
    public void test_04_sideDrawer_source() throws Exception {
        this.homePage.tapSideDrawer();
        this.sideDrawer.tapSource();
        this.browser.handle("github.com", "ExternalLins_Source");
    }

    @Test(groups = {"android", "browser"})
    public void test_05_sideDrawer_verifiedPlugins() throws Exception {
        this.homePage.tapSideDrawer();
        this.sideDrawer.tapVerifiedPlugins();
        this.browser.handle("market.nativescript.org", "ExternalLins_VerifiedPlugins");
    }

    @Test(groups = {"android", "browser"})
    public void test_06_sideDrawer_documentation() throws Exception {
        this.homePage.tapSideDrawer();
        this.sideDrawer.tapDocumentation();
        this.browser.handle("docs.nativescript.org", "ExternalLins_Documentation");
    }

    @Test(groups = {"android", "browser"})
    public void test_07_sideDrawer_productPage() throws Exception {
        this.homePage.tapSideDrawer();
        this.sideDrawer.tapProductPage();
        this.browser.handle("nativescript.org", "ExternalLins_ProductPage");
    }

    @Test(groups = {"android", "browser"})
    public void test_08_sideDrawer_codeSamples() throws Exception {
        this.homePage.tapSideDrawer();
        this.sideDrawer.tapCodeSamples();
        this.browser.handle("github.com", "ExternalLins_CodedSamples");
    }
}
