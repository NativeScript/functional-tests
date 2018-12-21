package templates.tabnavigation.tests;

import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.mobile.element.UIElement;
import org.springframework.util.Assert;
import org.testng.annotations.Test;
import templates.tabnavigation.pages.HomePage;

@SuppressWarnings("groupsTestNG")
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

    @Test(description = "Verify home page looks OK.", groups = {"android", "ios"})
    public void test_03_NavigatToHome() throws Exception {
        HomePage homePage = new HomePage();
        homePage.tabButton("Home");
        this.assertScreen("template-tab-navigation-home", this.settings.shortTimeout, 0.1);

        this.find.byText("Item 5").tap();
        UIElement detail = this.find.byText("Description for Item 5");
        Assert.notNull(detail, "Failed to navigate to details page.");

        homePage.navigateBack();
        this.assertScreen("template-tab-navigation-home", this.settings.shortTimeout, 0.1);
    }
}
