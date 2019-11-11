package uitests.Screens;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import io.appium.java_client.MobileBy;
import org.testng.Assert;

public class FlexboxPage extends HomePageExtended {

    public FlexboxPage(String maingPage, MobileContext context) {
        super(maingPage, context);
        this.loadedMainPage();
    }

    private void loadedMainPage() {
        UIElement element = this.findElement("flexrepeat");
        if (element == null) {
            Assert.fail("Flexbox main page is NOT loaded!");
        }
    }

    private UIElement findElement(String value) {
        if (this.settings.platform == PlatformType.Android) {
            return this.find.byText(value);
        } else {
            return this.find.byLocator(MobileBy.AccessibilityId(value));
        }

    }

    public UIElement btnFlexDirectionRow() {
        return this.findElement("flexDirection-row");
    }

    public UIElement btnFlexDirectionRowReverse() {
        return this.findElement("flexDirection-row-reverse");
    }

    public UIElement btnFlexDirectionColumn() {
        return this.findElement("flexDirection-column");
    }

    public UIElement btnFlexDirectionColumnReverse() {
        return this.findElement("flexDirection-column-reverse");
    }

    // FlexWrap
    public UIElement btnFlexNowrap() {
        return this.findElement("flexWrap-nowrap");
    }

    public UIElement btnFlexWrap() {
        return this.findElement("flexWrap-wrap");
    }

    public UIElement btnFlexWrapReverse() {
        return this.findElement("flexWrap-wrap-reverse");
    }

    // JustifyContent
    public UIElement btnJustifyContentFlexStart() {
        return this.findElement("justifyContent-flex-start");
    }

    public UIElement btnJustifyContentFlexEnd() {
        return this.findElement("justifyContent-flex-end");
    }

    public UIElement btnJustifyContentCenter() {
        return this.findElement("justifyContent-center");
    }

    public UIElement btnJustifyContentSpaceBetween() {
        return this.findElement("justifyContent-space-between");
    }

    public UIElement btnJustifyContentSpaceAround() {
        return this.findElement("justifyContent-space-around");
    }

    // AlignItems
    public UIElement btnAlignItemsFlexStart() {
        return this.findElement("alignItems-flex-start");
    }

    public UIElement btnAlignItemsFlexEnd() {
        return this.findElement("alignItems-flex-end");
    }

    public UIElement btnAlignItemsCenter() {
        return this.findElement("alignItems-center");
    }

    public UIElement btnAlignItemsBaseline() {
        return this.findElement("alignItems-baseline");
    }

    public UIElement btnAlignItemsStretch() {
        return this.findElement("alignItems-stretch");
    }

    // AlignContent
    public UIElement btnAlignContentFlexStart() {
        return this.findElement("alignContent-flex-start");
    }

    public UIElement btnAlignContentFlexEnd() {
        return this.findElement("alignContent-flex-end");
    }

    public UIElement btnAlignContentCenter() {
        return this.findElement("alignContent-center");
    }

    public UIElement btnAlignContentSpaceBetween() {
        return this.findElement("alignContent-space-between");
    }

    public UIElement btnAlignContentSpaceAround() {
        return this.findElement("alignContent-space-around");
    }

    public UIElement btnAlignContentStretch() {
        return this.findElement("alignContent-stretch");
    }

    // Order
    public UIElement btnOrderZero() {
        return this.findElement("order-0");
    }

    public UIElement btnOrderOne() {
        return this.findElement("order-1");
    }

    public UIElement btnOrderTwo() {
        return this.findElement("order-2");
    }

    public UIElement btnOrderThree() {
        return this.findElement("order-3");
    }

    public UIElement btnOrderFour() {
        return this.findElement("order-4");
    }

    // FlexGrow
    public UIElement btnFlexGrowZero() {
        return this.findElement("flexGrow-0");
    }

    public UIElement btnFlexGrowOne() {
        return this.findElement("flexGrow-1");
    }

    public UIElement btnFlexGrowTwo() {
        return this.findElement("flexGrow-2");
    }

    public UIElement btnFlexGrowThree() {
        return this.findElement("flexGrow-3");
    }

    public UIElement btnFlexGrowFour() {
        return this.findElement("flexGrow-4");
    }

    // FlexShrink
    public UIElement btnFlexShrinkZero() {
        return this.findElement("flexShrink-0");
    }

    public UIElement btnFlexShrinkOne() {
        return this.findElement("flexShrink-1");
    }

    public UIElement btnFlexShrinkTwo() {
        return this.findElement("flexShrink-2");
    }

    public UIElement btnFlexShrinkThree() {
        return this.findElement("flexShrink-3");
    }

    public UIElement btnFlexShrinkFour() {
        return this.findElement("flexShrink-4");
    }

    // AlignSelf
    public UIElement btnAlignSelfAuto() {
        return this.findElement("alignSelf-auto");
    }

    public UIElement btnAlignSelfFlexStart() {
        return this.findElement("alignSelf-flex-start");
    }

    public UIElement btnAlignSelfFlexEnd() {
        return this.findElement("alignSelf-flex-end");
    }

    public UIElement btnAlignSelfCenter() {
        return this.findElement("alignSelf-center");
    }

    public UIElement btnAlignSelfBaseline() {
        return this.findElement("alignSelf-baseline");
    }

    public UIElement btnAlignSelfStretch() {
        return this.findElement("alignSelf-stretch");
    }

    // AlignSelf
    public UIElement btnFlexWrapBeforeTrue() {
        return this.findElement("flexWrapBefore-true");
    }

    public UIElement btnFlexWrapBeforeFalse() {
        return this.findElement("flexWrapBefore-false");
    }

    // Items
    public UIElement btnItemRowZero() {
        return this.findElement("itemRow-0");
    }

    public UIElement btnItemRowReverseZero() {
        return this.findElement("itemRowReverse-0");
    }

    public UIElement btnItemColumnZero() {
        return this.findElement("itemColumn-0");
    }

    public UIElement btnItemColumnReverseZero() {
        return this.findElement("itemColumnReverse-0");
    }

    public UIElement btnItemRowOne() {
        return this.findElement("itemRow-1");
    }

    public UIElement btnItemRowReverseOne() {
        return this.findElement("itemRowReverse-1");
    }

    public UIElement btnItemColumnOne() {
        return this.findElement("itemColumn-1");
    }

    public UIElement btnItemColumnReverseOne() {
        return this.findElement("itemColumnReverse-1");
    }

    // CSS
    public UIElement btnCssFlexFlow() {
        return this.findElement("flexFlow");
    }

    public UIElement btnCssOrder() {
        return this.findElement("o1");
    }

    public UIElement btnCssFlexGrow() {
        return this.findElement("g1");
    }

    public UIElement btnCssFlexShrink() {
        return this.findElement("s1");
    }

    public UIElement btnCssAlignSelf() {
        return this.findElement("a1");
    }

    public UIElement btnCssFlexZero() {
        return this.findElement("f0");
    }

    public UIElement btnCssFlexOne() {
        return this.findElement("f1");
    }

    public UIElement btnCssFlexTwo() {
        return this.findElement("f2");
    }

    public UIElement container() {
        return this.findElement("container");
    }
}