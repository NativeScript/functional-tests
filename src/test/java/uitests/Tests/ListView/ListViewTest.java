package uitests.Tests.ListView;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.enums.SwipeElementDirection;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

@SuppressWarnings("groupsTestNG")
public class ListViewTest extends UIBaseTests {
    private HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeLayoutsTestsClass() {
        this.homePageExtended = new HomePageExtended("list-view", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void listViewItemsTemplate_01() throws Exception {
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 10) {
            this.log.warn("This test is not executing for iOS 9");
            return;
        }
        this.homePageExtended.navigateTo("list-view-templates");

        By scrollBtnLocator = this.locators.byText("SCROLL", false, false);

        By item1Locator = this.locators.byText("item1");
        By item99Locator = this.locators.byText("item99");

        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion > 10) {
            scrollBtnLocator = By.id("SCROLL");
            item1Locator = By.id("item1");
            item99Locator = By.id("item99");
        }

        UIElement scroll = this.homePageExtended.wait.waitForVisible(scrollBtnLocator, 5, true);
        this.compareScreens(10, 0.30);

        scroll.tap();
        this.homePageExtended.wait.waitForNotVisible(item99Locator, 3, true);
        this.compareScreens(10, 0.6);

        scroll.tap();
        this.homePageExtended.wait.waitForNotVisible(item1Locator, 3, true);
        this.compareScreens(10, 0.6);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void listViewRotate() throws Exception {
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 10) {
            this.log.warn("This test is not executing for iOS 9");
            return;
        }
        this.homePageExtended.navigateTo("images-template");
        this.compareScreens(15);
        this.device.rotate(ScreenOrientation.LANDSCAPE);
        this.compareScreens(15);
        this.device.rotate(ScreenOrientation.PORTRAIT);
        this.compareScreens(15);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void cssListView_01() throws Exception {
        this.homePageExtended.navigateTo("csslv");
        this.compareScreens(this.settings.defaultTimeout, 0.25);
        final String lastLocatorText = "NAME99";

        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 100);
        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 100);
        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 100);
        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 100);
        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 100);
        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 100);
        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 100);
        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 100);
        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 100);
        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 100);
        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 100);
        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 100);
        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 100);
        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 100);
        this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 1000);

        By lastItemLocator = this.locators.byText(lastLocatorText);
        if (this.settings.platform == PlatformType.iOS) {
            lastItemLocator = By.id(lastLocatorText);
        }
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion > 10) {

            this.wait.forVisibleElements(lastItemLocator, 5, true);
        }
        double tolerance = 0.28d;
        if (this.settings.platform == PlatformType.iOS) {
            tolerance = 0.60d;
        }
        this.compareScreens(10, tolerance);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void listview_bg_separator_color_3233_3574() throws Exception {
        this.homePageExtended.navigateTo("listview-bg-separator-color");
        this.assertScreen(this.settings.defaultTimeout);
    }
}
