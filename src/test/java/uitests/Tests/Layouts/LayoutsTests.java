package uitests.Tests.Layouts;

import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.element.UIRectangle;
import org.testng.Assert;
import org.testng.annotations.Test;

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

    // Dock
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

    // Wrap
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

    @Test(groups = {"android", "ios"})
    public void passThroughParent() throws Exception {
        this.layoutsPage.navigateTo("passThroughParent");
//        this.assertScreen(5);

        String onWrapLayoutResult = "on outer wrap layout tap";
        String buttonTapResult = "on button tap";
        String none = "none";

        // First layout
        assertAction("onOuterWrapLayoutTap", onWrapLayoutResult);
        assertAction("stackLayout1", onWrapLayoutResult);
        assertAction("label1", onWrapLayoutResult);
        assertAction("onUserInteractionDisabledThrowTap1", onWrapLayoutResult);
        assertAction("onDisabledThrowTap1", none);
        assertAction("btn1", buttonTapResult);

        // Second layout
        assertAction("stackLayout2", onWrapLayoutResult);
        assertAction("label2", onWrapLayoutResult);
        assertAction("stackLayout3", onWrapLayoutResult);
        assertAction("label3", onWrapLayoutResult);
        assertAction("onUserInteractionDisabledThrowTap2", onWrapLayoutResult);
        assertAction("onDisabledThrowTap2", none);
        assertAction("btn2", buttonTapResult);
    }

    private void assertAction(String buttonId, String expectedText) {
        UIElement btn = this.context.find.byText(buttonId);
        UIRectangle uiRectangle = new UIRectangle(btn.getUIRectangle(), this.context);
        uiRectangle.tap();

        UIElement result = this.context.find.byText(expectedText);
        String resultText = result.getText();
        Assert.assertEquals(resultText, expectedText);

        UIElement clearTextBtn = this.context.find.byText("clearResult");
        clearTextBtn.tap();
    }
}