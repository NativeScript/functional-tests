package uitests.Screens.Layouts;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import uitests.Screens.HomePageExtended;

public class LayoutsPage extends HomePageExtended {
    public LayoutsPage(String example, MobileContext context) {
        super(example, context);
        this.basePageLoaded();
    }

    private void basePageLoaded() {
        UIElement element;
        if (this.settings.platform == PlatformType.Android) {
            element = this.find.byText("pwrap");
        } else {
            element = this.find.byLocator(MobileBy.AccessibilityId("pwrap"));
        }
        Assert.assertNotNull(element, "LayoutsPage is not loaded");
    }

    // Legend:
    //
    // LightBlue color buttons represent the view properties:
    // wh (id="widthHeight") changes its width and height
    // n (id="minWidthMinHeight") changes its minWidth and minHeight
    // m (id="margins") changes its margins
    // a (id="alignments") changes its alignments
    // c (id="collapse") changes its visibility to collapse
    // v (id="visible") changes id="collapse" button visibility to visible
    //
    // LightGray color buttons represent the layout properties:
    // p (id="paddings") changes the layout paddings
    //
    // Aquamarine color buttons represent the view and layout properties:
    // all (id="allProperties") changes all view and layouts properties listed above at once
    //
    // LightGreen color buttons represent the specific layout properties:
    // s (id="setLeftSetTop") set left and top properties of the view in absolute layout
    // tr (id="stretchLastChild") set stretchLastChild property of dock layout
    // 1 (id="addRowColumn") adds new row and column, adds views to them
    //	and set RowSpan and ColumnsSpan
    // 0 (id="removeRowColumn") removes the last row and column
    // o (id="orientation") changes the orientation property of the layout
    // i (id="itemWidthItemHeight") set itemWidth and itemHeight properties of wrap layout

    private UIElement findButton(String byText, String byName) {
        if (this.settings.platform == PlatformType.Android) {
            return this.find.byText(byText);
        } else {
            return this.find.byLocator(By.id(byName));
        }
    }

    public void tapWidthHeightBtn() {
        findButton("wh", "widthHeight").click();
        this.log.info("Top on 'WidthHeight' button.");
    }

    public void tapMinWidthMinHeightBtn() {
        findButton("n", "minWidthMinHeight").click();
        this.log.info("Top on 'MinWidthMinHeight' button.");
    }

    public void tapMarginsBtn() {
        findButton("m", "margins").click();
        this.log.info("Top on 'Margins' button.");
    }

    public void tapAllPropertiesBtn() {
        findButton("all", "allProperties").click();
        this.log.info("Top on 'AllProperties' button.");
    }

    // AbsoluteLayout
    public void tapSetLeftSetTopBtn() {
        findButton("s", "setLeftSetTop").click();
        this.log.info("Top on 'SetLeftSetTop' button.");
    }

    // DockLayout
    public void tapStretchLastChildBtn() {
        findButton("tr", "stretchLastChild").click();
        this.log.info("Top on 'StretchLastChild' button.");
    }

    // GridLayout
    public void tapAddRowColumnBtn() {
        findButton("1", "addRowColumn").click();
        this.log.info("Top on 'AddRowColumn' button.");
    }

    public void tapRemoveRowColumnBtn() {
        findButton("0", "removeRowColumn").click();
        this.log.info("Top on 'RemoveRowColumn' button.");
    }

    // StackLayout, WrapLayout
    public void tapOrientationBtn() {
        findButton("o", "orientation").click();
        this.log.info("Top on 'Orientation' button.");
    }

    public void tapItemWidthItemHeightBtn() {
        findButton("i", "itemWidthItemHeight").click();
        this.log.info("Top on 'ItemWidthItemHeight' button.");
    }

    public void loaded() {
        if (findButton("all", "allProperties") != null) {
            this.log.info("Layouts page loaded.");
        } else {
            Assert.fail("Layouts page not loaded.");
        }
    }
}
