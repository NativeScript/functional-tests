package uitests.Screens;

import functional.tests.core.basetest.Context;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import org.testng.Assert;

public class FlexboxPage extends HomePageExtended {

    public FlexboxPage(String maingPage, Context context) {
        super(maingPage, context);
        this.loadedMainPage();
    }

    public void loadedMainPage() {
        UIElement element = this.find.byText("flexrepeat");
        if (element == null) {
            Assert.fail("Flexbox main page is NOT loaded!");
        }
    }

    public UIElement btnFlexDirectionRow() {
        return this.find.byText("flexDirection-row");
    }

    public UIElement btnFlexDirectionRowReverse() {
        return this.find.byText("flexDirection-row-reverse");
    }

    public UIElement btnFlexDirectionColumn() {
        return this.find.byText("flexDirection-column");
    }

    public UIElement btnFlexDirectionColumnReverse() {
        return this.find.byText("flexDirection-column-reverse");
    }

    // FlexWrap
    public UIElement btnFlexNowrap() {
        return this.find.byText("flexWrap-nowrap");
    }

    public UIElement btnFlexWrap() {
        return this.find.byText("flexWrap-wrap");
    }

    public UIElement btnFlexWrapReverse() {
        return this.find.byText("flexWrap-wrap-reverse");
    }

    // JustifyContent
    public UIElement btnJustifyContentFlexStart() {
        return this.find.byText("justifyContent-flex-start");
    }

    public UIElement btnJustifyContentFlexEnd() {
        return this.find.byText("justifyContent-flex-end");
    }

    public UIElement btnJustifyContentCenter() {
        return this.find.byText("justifyContent-center");
    }

    public UIElement btnJustifyContentSpaceBetween() {
        return this.find.byText("justifyContent-space-between");
    }

    public UIElement btnJustifyContentSpaceAround() {
        return this.find.byText("justifyContent-space-around");
    }

    // AlignItems
    public UIElement btnAlignItemsFlexStart() {
        return this.find.byText("alignItems-flex-start");
    }

    public UIElement btnAlignItemsFlexEnd() {
        return this.find.byText("alignItems-flex-end");
    }

    public UIElement btnAlignItemsCenter() {
        return this.find.byText("alignItems-center");
    }

    public UIElement btnAlignItemsBaseline() {
        return this.find.byText("alignItems-baseline");
    }

    public UIElement btnAlignItemsStretch() {
        return this.find.byText("alignItems-stretch");
    }

    // AlignContent
    public UIElement btnAlignContentFlexStart() {
        return this.find.byText("alignContent-flex-start");
    }

    public UIElement btnAlignContentFlexEnd() {
        return this.find.byText("alignContent-flex-end");
    }

    public UIElement btnAlignContentCenter() {
        return this.find.byText("alignContent-center");
    }

    public UIElement btnAlignContentSpaceBetween() {
        return this.find.byText("alignContent-space-between");
    }

    public UIElement btnAlignContentSpaceAround() {
        return this.find.byText("alignContent-space-around");
    }

    public UIElement btnAlignContentStretch() {
        return this.find.byText("alignContent-stretch");
    }

    // Order
    public UIElement btnOrderZero() {
        return this.find.byText("order-0");
    }

    public UIElement btnOrderOne() {
        return this.find.byText("order-1");
    }

    public UIElement btnOrderTwo() {
        return this.find.byText("order-2");
    }

    public UIElement btnOrderThree() {
        return this.find.byText("order-3");
    }

    public UIElement btnOrderFour() {
        return this.find.byText("order-4");
    }

    // FlexGrow
    public UIElement btnFlexGrowZero() {
        return this.find.byText("flexGrow-0");
    }

    public UIElement btnFlexGrowOne() {
        return this.find.byText("flexGrow-1");
    }

    public UIElement btnFlexGrowTwo() {
        return this.find.byText("flexGrow-2");
    }

    public UIElement btnFlexGrowThree() {
        return this.find.byText("flexGrow-3");
    }

    public UIElement btnFlexGrowFour() {
        return this.find.byText("flexGrow-4");
    }

    // FlexShrink
    public UIElement btnFlexShrinkZero() {
        return this.find.byText("flexShrink-0");
    }

    public UIElement btnFlexShrinkOne() {
        return this.find.byText("flexShrink-1");
    }

    public UIElement btnFlexShrinkTwo() {
        return this.find.byText("flexShrink-2");
    }

    public UIElement btnFlexShrinkThree() {
        return this.find.byText("flexShrink-3");
    }

    public UIElement btnFlexShrinkFour() {
        return this.find.byText("flexShrink-4");
    }

    // AlignSelf
    public UIElement btnAlignSelfAuto() {
        return this.find.byText("alignSelf-auto");
    }

    public UIElement btnAlignSelfFlexStart() {
        return this.find.byText("alignSelf-flex-start");
    }

    public UIElement btnAlignSelfFlexEnd() {
        return this.find.byText("alignSelf-flex-end");
    }

    public UIElement btnAlignSelfCenter() {
        return this.find.byText("alignSelf-center");
    }

    public UIElement btnAlignSelfBaseline() {
        return this.find.byText("alignSelf-baseline");
    }

    public UIElement btnAlignSelfStretch() {
        return this.find.byText("alignSelf-stretch");
    }

    // AlignSelf
    public UIElement btnFlexWrapBeforeTrue() {
        return this.find.byText("flexWrapBefore-true");
    }

    public UIElement btnFlexWrapBeforeFalse() {
        return this.find.byText("flexWrapBefore-false");
    }

    // Items
    public UIElement btnItemRowZero() {
        return this.find.byText("itemRow-0");
    }

    public UIElement btnItemRowReverseZero() {
        return this.find.byText("itemRowReverse-0");
    }

    public UIElement btnItemColumnZero() {
        return this.find.byText("itemColumn-0");
    }

    public UIElement btnItemColumnReverseZero() {
        return this.find.byText("itemColumnReverse-0");
    }

    public UIElement btnItemRowOne() {
        return this.find.byText("itemRow-1");
    }

    public UIElement btnItemRowReverseOne() {
        return this.find.byText("itemRowReverse-1");
    }

    public UIElement btnItemColumnOne() {
        return this.find.byText("itemColumn-1");
    }

    public UIElement btnItemColumnReverseOne() {
        return this.find.byText("itemColumnReverse-1");
    }

    // CSS
    public UIElement btnCssFlexFlow() {
        return this.find.byText("flexFlow");
    }

    public UIElement btnCssOrder() {
        return this.find.byText("o1");
    }

    public UIElement btnCssFlexGrow() {
        return this.find.byText("g1");
    }

    public UIElement btnCssFlexShrink() {
        return this.find.byText("s1");
    }

    public UIElement btnCssAlignSelf() {
        return this.find.byText("a1");
    }

    public UIElement btnCssFlexZero() {
        return this.find.byText("f0");
    }

    public UIElement btnCssFlexOne() {
        return this.find.byText("f1");
    }

    public UIElement btnCssFlexTwo() {
        return this.find.byText("f2");
    }

    public UIElement container() {
        return this.find.byText("container");
    }
}