package uitests.Tests.ImageView;

import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.mobile.element.UIElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;

public class RoundedViewsTests extends MobileTest {
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

    @Test(groups = {"android", "ios"})
    public void mode_matrix() throws Exception {
        this.homePageExtended.navigateTo("mode-matrix");
        this.assertScreen(10);
    }

    @Test(groups = {"android", "ios"})
    public void stretch_modes() throws Exception {
        this.homePageExtended.navigateTo("stretch-modes");
        this.assertScreen(10);
    }

    @Test(groups = {"android", "ios"})
    public void missing_image() throws Exception {
        this.homePageExtended.navigateTo("missing-image");
        this.assertScreen(10);
    }

    @Test(groups = {"android", "ios"})
    public void image_asset() throws Exception {
        this.homePageExtended.navigateTo("image-asset");
        this.assertScreen(10);
    }
}
