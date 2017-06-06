package uitests.Tests.Css;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.Css.CssBasePage;

public class StylesTests extends MobileTest {

    private CssBasePage cssBasePage;

    @BeforeClass(alwaysRun = true)
    public void beforeStylesTestsClass() {
        this.cssBasePage = new CssBasePage(this.context);
    }

    @Test(groups = {"android", "ios"})
    public void styles_02_radius() throws Exception {
        this.cssBasePage.navigateTo("radius");
        this.compareScreens(this.settings.shortTimeout, 1.5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void styles_03_views() throws Exception {
        this.cssBasePage.navigateTo("switch");
        this.compareScreens(this.settings.shortTimeout, 0.01);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void styles_04_label_background_image() throws Exception {
        this.cssBasePage.navigateTo("label-background-image");
        this.compareScreens(5, 0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void styles_05_transform_decoration_color() throws Exception {
        this.cssBasePage.navigateTo("transform-decoration-color");
        this.compareScreens(20, 0.90);
        this.assertImagesResults();
    }
}
