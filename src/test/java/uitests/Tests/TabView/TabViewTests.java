package uitests.Tests.TabView;

import functional.tests.core.mobile.element.UIRectangle;
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
}
