package uitests.Tests.TabView;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIRectangle;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

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

    @Test(groups = {"android", "ios"})
    public void tabView_bottom() throws Exception {
        this.homePageExtended.navigateTo("tab-view-bottom-position");
        this.compareScreens(5);
        this.context.wait.waitForVisible(this.locators.byText("Second")).tap();
        this.compareScreens(5);
        this.context.wait.waitForVisible(this.locators.byText("First")).tap();
        this.compareScreens(5);
        this.assertImagesResults();
    }
}
