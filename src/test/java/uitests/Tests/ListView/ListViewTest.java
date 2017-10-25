package uitests.Tests.ListView;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.extensions.ScrollableListObject;
import functional.tests.core.mobile.element.UIElement;
import io.appium.java_client.SwipeElementDirection;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

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
        this.compareScreens(5);
        this.device.rotate(ScreenOrientation.LANDSCAPE);
        this.compareScreens(5);
        this.device.rotate(ScreenOrientation.PORTRAIT);
        this.compareScreens(5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void cssListView_01() throws Exception {
        this.homePageExtended.navigateTo("csslv");
        this.compareScreens(this.settings.defaultTimeout, 0.25);

        if (this.settings.platform == PlatformType.Android) {
            ScrollableListObject scrollableListObject = new ScrollableListObject(this.context) {
                @Override
                public String getMainContainerLocatorName() {
                    return context.uiElementClass.listViewLocator();
                }

                @Override
                public String getMainContainerItemsName() {
                    if (settings.platform == PlatformType.Android) {
                        return context.uiElementClass.textViewLocator();
                    } else {
                        return context.uiElementClass.cellLocator();
                    }
                }
            };

            scrollableListObject.scrollTo("NAME99");
        } else {
            this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 10);
            this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 10);
            this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 10);
            this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 10);
        }

        double tolerance = 0.28d;
        if (this.settings.platform == PlatformType.iOS) {
            tolerance = 0.50d;
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
