package templates.drawernavigation.tests;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.Test;
import templates.drawernavigation.pages.HomePage;

public class SmokeTests extends MobileTest {

    @Test(description = "Verify home page looks OK.", groups = {"android", "ios"})
    public void test_01_home_page_looks_ok() throws Exception {
        HomePage homePage = new HomePage();
        this.assertScreen("template-drawer-navigation-home", this.settings.shortTimeout, 0.1);
    }

    @Test(description = "Verify drawer navigation panel looks OK, navigate to Browse page", groups = {"android", "ios"})
    public void test_02_OpenSideDrawer_NavigateToBrowsePage() throws Exception {
        HomePage homePage = new HomePage();
        homePage.openDrawer();
        this.assertScreen("template-drawer-navigation-sideDrawer", this.settings.shortTimeout, 0.1);
        homePage.navigate("Browse");
        this.assertScreen("template-drawer-navigation-browsePage", this.settings.shortTimeout, 0.1);
    }
}
