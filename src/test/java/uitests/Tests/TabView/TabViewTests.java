package uitests.Tests.TabView;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.enums.SwipeElementDirection;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.element.UIRectangle;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

public class TabViewTests extends TabViewBaseTest {

    @Test(groups = {"android", "ios"})
    public void tabView_01() throws Exception {
        this.homePageExtended.navigateTo("tabStyle");

        this.compareScreens(5, 0.01);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void tabView_02_more() throws Exception {
        this.homePageExtended.navigateTo("tabmore");

        this.compareScreens(5, 0.01);
        this.assertImagesResults();
    }

    @Test(groups = {"ios"})
    public void tabView_03_tabViewIcons() throws Exception {
        this.homePageExtended.navigateTo("tab-view-icons");
        this.compareScreens(5);
        UIRectangle rect = new UIRectangle(this.find.byText("automatic").getUIRectangle());
        rect.extendRectangle(10, 10, 0, 0);
        rect.tap();
        this.compareScreens(5);
        rect.tap();
        this.compareScreens(5);
        rect.tap();
        this.compareScreens(5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void tabView_03_font() throws Exception {
        this.homePageExtended.navigateTo("text-transform");
        this.compareScreens(5);

        this.homePageExtended.find.byText("apply").tap();
        this.compareScreens(5);

        this.homePageExtended.find.byText("reset").tap();
        this.compareScreens(5);

        this.assertImagesResults();
    }


    @Test(groups = {"android", "ios"})
    public void tabView_icon_change() throws Exception {
        this.homePageExtended.navigateTo("tab-view-icon-change");
        By locator = this.context.locators.imageLocator();
        int index = 1;
        if (this.settings.platform == PlatformType.iOS) {
            locator = this.context.locators.buttonLocator();
            if (this.settings.platformVersion >= 11) {
                index = 2;
            } else {
                index = 3;
            }
        }
        this.wait.waitForVisible(locator);

        this.find.elementsByLocator(locator).get(index).tap();
        this.compareScreens(5);
        this.find.elementsByLocator(locator).get(index - 1).tap();

        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android"})
    public void tabView_disable_swipe_android() throws Exception {
        this.homePageExtended.navigateTo("tab-view-android-swipe");
        this.context.gestures.swipeInWindow(SwipeElementDirection.RIGHT, 200);
        this.context.gestures.swipeInWindow(SwipeElementDirection.RIGHT, 200);
        this.context.gestures.swipeInWindow(SwipeElementDirection.RIGHT, 200);

        this.compareScreens(5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void tab_view_tab_text_font_size() throws Exception {
        this.homePageExtended.navigateTo("tab-view-tab-text-font-size");
        this.compareScreens(5);

        UIElement tab2 = this.context.find.byText("Second");
        tab2.tap();
        this.compareScreens(5);

        UIElement tab3 = this.context.find.byText("First");
        tab3.tap();
        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void tab_view_icon_title_placement() throws Exception {
        this.homePageExtended.navigateTo("tab-view-icon-title-placement");
        this.compareScreens(5);

        if (this.settings.platform == PlatformType.Android) {
            List<UIElement> tabsWithText = this.context.find.elementsByLocator(this.locators.byText("Title", false, false));
            tabsWithText.get(1).tap();
            this.compareScreens(5);

            tabsWithText.get(0).tap();
            this.compareScreens(5);

            List<UIElement> middleTabView = this.context.find.elementsByLocator(this.locators.imageLocator());
            middleTabView.get(middleTabView.size() - 1).tap();
            this.compareScreens(5);
        } else {
            List<UIElement> tabItems = this.context.find.elementsByLocator(By.xpath("*//XCUIElementTypeTabBar/XCUIElementTypeButton"));
            tabItems.get(1).tap();
            this.compareScreens(5);

            tabItems.get(0).tap();
            this.compareScreens(5);

            tabItems.get(tabItems.size() - 1).tap();
            this.compareScreens(5);
        }

        this.assertImagesResults();
    }


    @Test(groups = {"android", "ios"})
    public void issue_5470() throws Exception {
        this.homePageExtended.navigateTo("issue-5470");
        this.compareScreens(5);

        UIElement second = this.context.find.byText("Tab2");
        second.tap();
        this.compareScreens(5);

        UIElement first = this.context.find.byText("Tab1");
        first.tap();
        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void tab_view_bottom_position() throws Exception {
        this.homePageExtended.navigateTo("tab-view-bottom-position");
        this.compareScreens(5);

        UIElement second = this.context.find.byText("Second");
        second.tap();
        this.compareScreens(5);

        UIElement first = this.context.find.byText("First");
        first.tap();
        this.compareScreens(5);

        this.assertImagesResults();
    }
}
