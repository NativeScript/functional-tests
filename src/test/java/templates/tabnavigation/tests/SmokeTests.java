package templates.tabnavigation.tests;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.Test;
import tabnavigation.pages.HomePage;

public class SmokeTests extends MobileTest {

    @Test(description = "Verify home page looks OK.", groups = {"android", "ios"})
    public void test_01_home_page_looks_ok() throws Exception {
        HomePage homePage = new HomePage();
        this.assertScreen("template-tab-navigation-home", this.settings.shortTimeout, 0.1);
    }

    @Test(description = "Verify home page looks OK.", groups = {"android", "ios"})
    public void test_02_Tab_SearchPage_looks_ok() throws Exception {
        HomePage homePage = new HomePage();
        homePage.tabButton("Search");
        this.assertScreen("template-tab-navigation-searchPage", this.settings.shortTimeout, 0.1);
    }
}
