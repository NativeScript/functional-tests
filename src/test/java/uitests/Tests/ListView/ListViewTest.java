package uitests.Tests.ListView;

import functional.tests.core.element.UIElement;
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
        UIElement scroll = this.homePageExtended.wait.waitForVisible(this.locators.byText("scroll", true, false), 5, true);
        this.compareScreens(10, 0.30);

        scroll.tap();
        this.homePageExtended.wait.waitForNotVisible(this.locators.byText("item99", false, false), 3, true);
        this.compareScreens(10);

        scroll.tap();
        this.homePageExtended.wait.waitForNotVisible(this.locators.byText("item1", false, false), 3, true);
        this.compareScreens(10);

        this.assertImagesResults();
    }
}
