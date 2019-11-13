package uitests.Tests.Layouts;

import org.testng.annotations.Test;

@SuppressWarnings("groupsTestNG")
public class LayoutsTests extends LayoutBaseTest {

    @Test(groups = {"android", "ios"})
    public void layouts_01_absolute() throws Exception {
        this.layoutsPage.navigateTo("absolute");
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_02_absoluteAllProperties() throws Exception {
        this.layoutsPage.tapAllPropertiesBtn();
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_03_absoluteSetLeftSetTop() throws Exception {
        this.layoutsPage.tapSetLeftSetTopBtn();
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_11_dock() throws Exception {
        this.layoutsPage.navigateTo("dock");
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_12_dockAllProperties() throws Exception {
        this.layoutsPage.tapAllPropertiesBtn();
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_13_dockStretchLastChild() throws Exception {
        this.layoutsPage.tapStretchLastChildBtn();
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    // Grid
    @Test(groups = {"android", "ios"})
    public void layouts_21_grid() throws Exception {
        this.layoutsPage.navigateTo("grid");
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_22_gridAllProperties() throws Exception {
        this.layoutsPage.tapAllPropertiesBtn();
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_23_gridAddRowColumn() throws Exception {
        this.layoutsPage.tapAddRowColumnBtn();
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_24_gridRemoveRowColumn() throws Exception {
        this.layoutsPage.tapRemoveRowColumnBtn();
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    // Stack
    @Test(groups = {"android", "ios"})
    public void layouts_31_stack() throws Exception {
        this.layoutsPage.navigateTo("stack");
        this.layoutsPage.loaded();
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_32_stackAllProperties() throws Exception {
        this.layoutsPage.tapAllPropertiesBtn();
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_33_stackOrientation() throws Exception {
        this.layoutsPage.tapOrientationBtn();
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void stack_layouts_6059() throws Exception {
        this.layoutsPage.navigateTo("stacklayout-6059");
        this.compareScreens(5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_41_wrap() throws Exception {
        this.layoutsPage.navigateTo("wrap");
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_42_wrapAllProperties() throws Exception {
        this.layoutsPage.tapAllPropertiesBtn();
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_43_wrapMinWidthMinHeight() throws Exception {
        this.layoutsPage.tapMinWidthMinHeightBtn();
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_44_wrapOrientation() throws Exception {
        this.layoutsPage.tapMinWidthMinHeightBtn();
        this.layoutsPage.tapOrientationBtn();
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_45_wrapItemWidthItemHeight() throws Exception {
        this.layoutsPage.tapItemWidthItemHeightBtn();
        this.waitForScreen(0.1);
        this.assertImagesResults();
    }
}
