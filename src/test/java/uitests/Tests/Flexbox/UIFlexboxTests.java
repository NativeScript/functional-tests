package uitests.Tests.Flexbox;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("groupsTestNG")
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
        this.pageFlexbox.btnFlexDirectionRowReverse().click();
        this.waitForScreen();

        // column
        this.pageFlexbox.btnFlexDirectionColumn().click();
        this.waitForScreen();

        // columnReverse
        this.pageFlexbox.btnFlexDirectionColumnReverse().click();
        this.waitForScreen();

        // row
        this.pageFlexbox.btnFlexDirectionRow().click();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // FlexWrap
    @Test(groups = {"android", "ios"})
    public void flexbox_20_flexWrap() throws Exception {
        // wrap
        this.pageFlexbox.btnFlexWrap().click();
        this.waitForScreen();

        // wrapReverse
        this.pageFlexbox.btnFlexWrapReverse().click();
        this.waitForScreen();

        // noWrap
        this.pageFlexbox.btnFlexNowrap().click();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // JustifyContent
    @Test(groups = {"android", "ios"})
    public void flexbox_30_justifyContent() throws Exception {
        this.pageFlexbox.btnFlexWrap().click();

        // flexEnd
        this.pageFlexbox.btnJustifyContentFlexEnd().click();
        this.waitForScreen();

        // center
        this.pageFlexbox.btnJustifyContentCenter().click();
        this.waitForScreen();

        // spaceBetween
        this.pageFlexbox.btnJustifyContentSpaceBetween().click();
        this.waitForScreen();

        // spaceAround
        this.pageFlexbox.btnJustifyContentSpaceAround().click();
        this.waitForScreen();

        // flexStart
        this.pageFlexbox.btnJustifyContentFlexStart().click();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // AlignItems
    @Test(groups = {"android", "ios"})
    public void flexbox_40_alignItems() throws Exception {
        this.pageFlexbox.btnFlexWrap().click();

        // flexStart
        this.pageFlexbox.btnAlignItemsFlexStart().click();
        this.waitForScreen();

        // flexEnd
        this.pageFlexbox.btnAlignItemsFlexEnd().click();
        this.waitForScreen();

        // center
        this.pageFlexbox.btnAlignItemsCenter().click();
        this.waitForScreen();

        // baseline
        this.pageFlexbox.btnAlignItemsBaseline().click();
        this.waitForScreen();

        // stretch
        this.pageFlexbox.btnAlignItemsStretch().click();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // AlignContent
    @Test(groups = {"android", "ios"})
    public void flexbox_50_alignContent() throws Exception {
        this.pageFlexbox.btnFlexWrap().click();

        // flexStart
        this.pageFlexbox.btnAlignContentFlexStart().click();
        this.waitForScreen(DEFAULT_TOLERANCE);

        // flexEnd
        this.pageFlexbox.btnAlignContentFlexEnd().click();
        this.waitForScreen(DEFAULT_TOLERANCE);

        // center
        this.pageFlexbox.btnAlignContentCenter().click();
        this.waitForScreen(DEFAULT_TOLERANCE);

        // spaceBetween
        this.pageFlexbox.btnAlignContentSpaceBetween().click();
        this.waitForScreen(DEFAULT_TOLERANCE);

        // spaceAround
        this.pageFlexbox.btnAlignContentSpaceAround().click();
        this.waitForScreen(DEFAULT_TOLERANCE);

        // stretch
        this.pageFlexbox.btnAlignContentStretch().click();
        this.waitForScreen(DEFAULT_TOLERANCE);
        this.assertImagesResults();
    }

    // Order
    @Test(groups = {"android", "ios"})
    public void flexbox_60_order() throws Exception {
        this.pageFlexbox.btnFlexWrap().click();

        // zero
        this.pageFlexbox.btnItemRowReverseZero().click();
        this.pageFlexbox.btnOrderZero().click();
        this.waitForScreen();

        // three
        this.pageFlexbox.btnOrderThree().click();
        this.waitForScreen();

        // two
        this.pageFlexbox.btnItemRowReverseOne().click();
        this.pageFlexbox.btnOrderTwo().click();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // FlexGrow
    @Test(groups = {"android", "ios"})
    public void flexbox_70_flexGrow() throws Exception {
        this.pageFlexbox.btnFlexWrap().click();

        // one
        this.pageFlexbox.btnItemColumnReverseOne().click();
        this.pageFlexbox.btnFlexGrowOne().click();
        this.waitForScreen();

        // two
        this.pageFlexbox.btnItemColumnOne().click();
        this.pageFlexbox.btnFlexGrowTwo().click();
        this.waitForScreen();

        // three
        this.pageFlexbox.btnItemRowReverseOne().click();
        this.pageFlexbox.btnFlexGrowThree().click();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // FlexShrink
    @Test(groups = {"android", "ios"})
    public void flexbox_80_flexShrink() throws Exception {
        // zero
        this.pageFlexbox.btnItemColumnReverseOne().click();
        this.pageFlexbox.btnFlexShrinkZero().click();
        this.waitForScreen();

        this.pageFlexbox.btnItemColumnReverseZero().click();
        this.pageFlexbox.btnFlexShrinkZero().click();
        this.waitForScreen();

        this.pageFlexbox.btnItemRowReverseOne().click();
        this.pageFlexbox.btnFlexShrinkZero().click();
        this.waitForScreen();

        // one
        // this.pageFlexbox.btnItemRowReverseOne().click();
        this.pageFlexbox.btnFlexShrinkOne().click();
        this.pageFlexbox.btnItemColumnReverseZero().click();
        this.pageFlexbox.btnFlexShrinkOne().click();
        this.waitForScreen();

        // two
        this.pageFlexbox.btnItemColumnReverseZero().click();
        this.pageFlexbox.btnFlexShrinkTwo().click();
        this.waitForScreen();

        // three
        // this.pageFlexbox.btnItemColumnReverseZero().click();
        this.pageFlexbox.btnFlexShrinkThree().click();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // AlignSelf
    @Test(groups = {"android", "ios"})
    public void flexbox_90_alignSelf() throws Exception {
        this.pageFlexbox.btnItemColumnReverseZero().click();

        // flexStart
        this.pageFlexbox.btnAlignSelfFlexStart().click();
        this.waitForScreen();

        // flexEnd
        this.pageFlexbox.btnAlignSelfFlexEnd().click();
        this.waitForScreen();

        // center
        this.pageFlexbox.btnAlignSelfCenter().click();
        this.waitForScreen();

        // baseline
        this.pageFlexbox.btnAlignSelfBaseline().click();
        this.waitForScreen();

        // stretch
        this.pageFlexbox.btnAlignSelfStretch().click();
        this.waitForScreen();

        // auto
        this.pageFlexbox.btnAlignSelfAuto().click();
        this.waitForScreen();
        this.assertImagesResults();
    }

    // FlexWrapBefore
    @Test(groups = {"android", "ios"})
    public void flexbox_100_flexWrapBefore() throws Exception {
        this.pageFlexbox.btnFlexWrap().click();

        // true
        this.pageFlexbox.btnItemColumnReverseZero().click();
        this.pageFlexbox.btnFlexWrapBeforeTrue().click();
        this.waitForScreen(DEFAULT_TOLERANCE);

        // true
        this.pageFlexbox.btnItemRowOne().click();
        this.pageFlexbox.btnFlexWrapBeforeTrue().click();
        this.pageFlexbox.btnItemRowReverseOne().click();
        this.pageFlexbox.btnFlexWrapBeforeTrue().click();
        this.waitForScreen(DEFAULT_TOLERANCE);

        // false
        this.pageFlexbox.btnFlexWrapBeforeFalse().click();
        this.waitForScreen(DEFAULT_TOLERANCE);
        this.assertImagesResults();
    }
}
