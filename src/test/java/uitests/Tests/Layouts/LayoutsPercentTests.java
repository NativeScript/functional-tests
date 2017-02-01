package uitests.Tests.Layouts;

import org.testng.annotations.Test;

public class LayoutsPercentTests extends LayoutBaseTest {

    // Absolute
    @Test(groups = {"android", "ios"})
    public void layouts_51_percentAbsolute() throws Exception {
        this.layoutsPage.navigateTo("pabsolute");
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_52_percentAbsoluteAllProperties() throws Exception {
        this.layoutsPage.tapAllPropertiesBtn();
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    // Dock
    @Test(groups = {"android", "ios"})
    public void layouts_61_percentDock() throws Exception {
        this.layoutsPage.navigateTo("pdock");
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_62_percentDockAllProperties() throws Exception {
        this.layoutsPage.tapAllPropertiesBtn();
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_63_percentDockWidthHeight() throws Exception {
        this.layoutsPage.tapAllPropertiesBtn();
        this.layoutsPage.tapWidthHeightBtn();
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    // Grid
    @Test(groups = {"android", "ios"})
    public void layouts_71_percentGrid() throws Exception {
        this.layoutsPage.navigateTo("pgrid");
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_72_percentGridAllProperties() throws Exception {
        this.layoutsPage.tapAllPropertiesBtn();
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_73_percentGridMargins() throws Exception {
        this.layoutsPage.tapMarginsBtn();
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_74_percentGridAddRemoveRowColumn() throws Exception {
        this.layoutsPage.tapAddRowColumnBtn();
        this.layoutsPage.tapRemoveRowColumnBtn();
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    // Stack
    @Test(groups = {"android", "ios"})
    public void layouts_81_percentStack() throws Exception {
        this.layoutsPage.navigateTo("pstack");
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_82_percentStackAllProperties() throws Exception {
        this.layoutsPage.tapAllPropertiesBtn();
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_83_percentStackMargins() throws Exception {
        this.layoutsPage.tapMarginsBtn();
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    // Wrap
    @Test(groups = {"android", "ios"})
    public void layouts_91_percentWrap() throws Exception {
        this.layoutsPage.navigateTo("pwrap");
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_92_percentWrapAllProperties() throws Exception {
        this.layoutsPage.tapAllPropertiesBtn();
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_93_percentWrapMargins() throws Exception {
        this.layoutsPage.tapMarginsBtn();
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_94_percentWrapItemWidthItemHeight() throws Exception {
        this.layoutsPage.tapItemWidthItemHeightBtn();
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_95_percentWrapOrientation() throws Exception {
        this.layoutsPage.tapOrientationBtn();
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }
}
