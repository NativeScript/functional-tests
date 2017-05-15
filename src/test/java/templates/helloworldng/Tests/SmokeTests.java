package templates.helloworldng.Tests;

import functional.tests.core.mobile.basetest.MobileTest;
import io.appium.java_client.SwipeElementDirection;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import templates.helloworldng.Screens.HomePage;
import templates.helloworldng.Screens.ItemDetailPage;

public class SmokeTests extends MobileTest {

    private HomePage homePage;
    private ItemDetailPage itemDetailPage;
    private String itemFirst = "Ter Stegen";
    private String itemLast = "Masip";
    private String itemToTap = "Umtiti";

    @BeforeClass(alwaysRun = true)
    public void beforeSmokeTestsClass() {
        this.homePage = new HomePage();
        this.itemDetailPage = new ItemDetailPage();
    }

    @Test(groups = {"android", "ios"})
    public void test_01_home() throws Exception {
        this.homePage.loaded();
        this.assertScreen();
    }

    @Test(groups = {"android", "ios"})
    public void test_02_swipeDown() throws Exception {
        this.homePage.loaded();
        this.context.gestures.swipeInWindowToElement(SwipeElementDirection.DOWN, this.locators.byText(itemLast), 3, 250, 0);
    }

    @Test(groups = {"android", "ios"})
    public void test_03_itemDetail() throws Exception {
        this.homePage.loaded();
        this.homePage.tapOnItem(itemToTap);
        this.itemDetailPage.loaded();
        // this.assertScreen();
    }

    @Test(groups = {"android", "ios"})
    public void test_04_back() throws Exception {
        this.itemDetailPage.loaded();
        this.itemDetailPage.navigateBack();
        this.homePage.loaded();
    }

    @Test(groups = {"android", "ios"})
    public void test_05_swipeUp() throws Exception {
        this.homePage.loaded();
        this.context.gestures.swipeInWindowToElement(SwipeElementDirection.UP, this.locators.byText(itemFirst), 3, 250, 0);
    }
}