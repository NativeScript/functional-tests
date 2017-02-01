package uitests.Tests.ImageView;

import functional.tests.core.basetest.UIBaseTest;
import functional.tests.core.element.UIElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;

public class RoundedViewsTests extends UIBaseTest {
    private HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeNordicTestsClass() {
        this.homePageExtended = new HomePageExtended("image-view", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void roundBtn_01() throws Exception {
        this.homePageExtended.navigateToMainPage();
        UIElement el = this.homePageExtended.wait.waitForVisible(this.locators.byText("roundbtn", true, false), 3, true);
        this.homePageExtended.navigateTo(el);
        this.compareScreens(10, 0.2);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void roundImg_01() throws Exception {
        this.homePageExtended.navigateToMainPage();
        UIElement el = this.homePageExtended.wait.waitForVisible(this.locators.byText("roundimg", true, false), 3, true);
        this.homePageExtended.navigateTo(el);
        this.compareScreens(10, 0.1);

        this.assertImagesResults();
    }
}
