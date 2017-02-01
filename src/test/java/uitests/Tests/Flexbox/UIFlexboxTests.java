package uitests.Tests.Flexbox;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UIFlexboxTests extends UIFlexboxBaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeFlexboxTests() {
        this.pageFlexbox.navigateTo("flexboxall");
    }

    @Test(groups = {"android", "ios"})
    public void flexbox_00_default() throws Exception {
        this.waitForScreen();
        this.assertImagesResults();
    }

    // FlexDirection
    @Test(groups = {"android", "ios"})
    public void flexbox_10_flexDirection() throws Exception {
        // rowReverse
        this.pageFlexbox.btnFlexDirectionRowReverse().tap();
        this.waitForScreen();

        // column
        this.pageFlexbox.btnFlexDirectionColumn().tap();
        this.waitForScreen();

        // columnReverse
        this.pageFlexbox.btnFlexDirectionColumnReverse().tap();
        this.waitForScreen();

        // row
        this.pageFlexbox.btnFlexDirectionRow().tap();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // FlexWrap
    @Test(groups = {"android", "ios"})
    public void flexbox_20_flexWrap() throws Exception {
        // wrap
        this.pageFlexbox.btnFlexWrap().tap();
        this.waitForScreen();

        // wrapReverse
        this.pageFlexbox.btnFlexWrapReverse().tap();
        this.waitForScreen();

        // noWrap
        this.pageFlexbox.btnFlexNowrap().tap();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // JustifyContent
    @Test(groups = {"android", "ios"})
    public void flexbox_30_justifyContent() throws Exception {
        this.pageFlexbox.btnFlexWrap().tap();

        // flexEnd
        this.pageFlexbox.btnJustifyContentFlexEnd().tap();
        this.waitForScreen();

        // center
        this.pageFlexbox.btnJustifyContentCenter().tap();
        this.waitForScreen();

        // spaceBetween
        this.pageFlexbox.btnJustifyContentSpaceBetween().tap();
        this.waitForScreen();

        // spaceAround
        this.pageFlexbox.btnJustifyContentSpaceAround().tap();
        this.waitForScreen();

        // flexStart
        this.pageFlexbox.btnJustifyContentFlexStart().tap();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // AlignItems
    @Test(groups = {"android", "ios"})
    public void flexbox_40_alignItems() throws Exception {
        this.pageFlexbox.btnFlexWrap().tap();

        // flexStart
        this.pageFlexbox.btnAlignItemsFlexStart().tap();
        this.waitForScreen();

        // flexEnd
        this.pageFlexbox.btnAlignItemsFlexEnd().tap();
        this.waitForScreen();

        // center
        this.pageFlexbox.btnAlignItemsCenter().tap();
        this.waitForScreen();

        // baseline
        this.pageFlexbox.btnAlignItemsBaseline().tap();
        this.waitForScreen();

        // stretch
        this.pageFlexbox.btnAlignItemsStretch().tap();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // AlignContent
    @Test(groups = {"android", "ios"})
    public void flexbox_50_alignContent() throws Exception {
        this.pageFlexbox.btnFlexWrap().tap();

        // flexStart
        this.pageFlexbox.btnAlignContentFlexStart().tap();
        this.waitForScreen(DEFAULT_TOLERANCE);

        // flexEnd
        this.pageFlexbox.btnAlignContentFlexEnd().tap();
        this.waitForScreen(DEFAULT_TOLERANCE);

        // center
        this.pageFlexbox.btnAlignContentCenter().tap();
        this.waitForScreen(DEFAULT_TOLERANCE);

        // spaceBetween
        this.pageFlexbox.btnAlignContentSpaceBetween().tap();
        this.waitForScreen(DEFAULT_TOLERANCE);

        // spaceAround
        this.pageFlexbox.btnAlignContentSpaceAround().tap();
        this.waitForScreen(DEFAULT_TOLERANCE);

        // stretch
        this.pageFlexbox.btnAlignContentStretch().tap();
        this.waitForScreen(DEFAULT_TOLERANCE);
        this.assertImagesResults();
    }

    // Order
    @Test(groups = {"android", "ios"})
    public void flexbox_60_order() throws Exception {
        this.pageFlexbox.btnFlexWrap().tap();

        // zero
        this.pageFlexbox.btnItemRowReverseZero().tap();
        this.pageFlexbox.btnOrderZero().tap();
        this.waitForScreen();

        // three
        this.pageFlexbox.btnOrderThree().tap();
        this.waitForScreen();

        // two
        this.pageFlexbox.btnItemRowReverseOne().tap();
        this.pageFlexbox.btnOrderTwo().tap();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // FlexGrow
    @Test(groups = {"android", "ios"})
    public void flexbox_70_flexGrow() throws Exception {
        this.pageFlexbox.btnFlexWrap().tap();

        // one
        this.pageFlexbox.btnItemColumnReverseOne().tap();
        this.pageFlexbox.btnFlexGrowOne().tap();
        this.waitForScreen();

        // two
        this.pageFlexbox.btnItemColumnOne().tap();
        this.pageFlexbox.btnFlexGrowTwo().tap();
        this.waitForScreen();

        // three
        this.pageFlexbox.btnItemRowReverseOne().tap();
        this.pageFlexbox.btnFlexGrowThree().tap();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // FlexShrink
    @Test(groups = {"android", "ios"})
    public void flexbox_80_flexShrink() throws Exception {
        // zero
        this.pageFlexbox.btnItemColumnReverseOne().tap();
        this.pageFlexbox.btnFlexShrinkZero().tap();
        this.waitForScreen();

        this.pageFlexbox.btnItemColumnReverseZero().tap();
        this.pageFlexbox.btnFlexShrinkZero().tap();
        this.waitForScreen();

        this.pageFlexbox.btnItemRowReverseOne().tap();
        this.pageFlexbox.btnFlexShrinkZero().tap();
        this.waitForScreen();

        // one
        // this.pageFlexbox.btnItemRowReverseOne().tap();
        this.pageFlexbox.btnFlexShrinkOne().tap();
        this.pageFlexbox.btnItemColumnReverseZero().tap();
        this.pageFlexbox.btnFlexShrinkOne().tap();
        this.waitForScreen();

        // two
        this.pageFlexbox.btnItemColumnReverseZero().tap();
        this.pageFlexbox.btnFlexShrinkTwo().tap();
        this.waitForScreen();

        // three
        // this.pageFlexbox.btnItemColumnReverseZero().tap();
        this.pageFlexbox.btnFlexShrinkThree().tap();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // AlignSelf
    @Test(groups = {"android", "ios"})
    public void flexbox_90_alignSelf() throws Exception {
        this.pageFlexbox.btnItemColumnReverseZero().tap();

        // flexStart
        this.pageFlexbox.btnAlignSelfFlexStart().tap();
        this.waitForScreen();

        // flexEnd
        this.pageFlexbox.btnAlignSelfFlexEnd().tap();
        this.waitForScreen();

        // center
        this.pageFlexbox.btnAlignSelfCenter().tap();
        this.waitForScreen();

        // baseline
        this.pageFlexbox.btnAlignSelfBaseline().tap();
        this.waitForScreen();

        // stretch
        this.pageFlexbox.btnAlignSelfStretch().tap();
        this.waitForScreen();

        // auto
        this.pageFlexbox.btnAlignSelfAuto().tap();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // FlexWrapBefore
    @Test(groups = {"android", "ios"})
    public void flexbox_100_flexWrapBefore() throws Exception {
        this.pageFlexbox.btnFlexWrap().tap();

        // true
        this.pageFlexbox.btnItemColumnReverseZero().tap();
        this.pageFlexbox.btnFlexWrapBeforeTrue().tap();
        this.waitForScreen(DEFAULT_TOLERANCE);

        // true
        this.pageFlexbox.btnItemRowOne().tap();
        this.pageFlexbox.btnFlexWrapBeforeTrue().tap();
        this.pageFlexbox.btnItemRowReverseOne().tap();
        this.pageFlexbox.btnFlexWrapBeforeTrue().tap();
        this.waitForScreen(DEFAULT_TOLERANCE);

        // false
        this.pageFlexbox.btnFlexWrapBeforeFalse().tap();
        this.waitForScreen(DEFAULT_TOLERANCE);
        this.assertImagesResults();
    }
}
