package galleryapp.Screens;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Find;
import functional.tests.core.log.Log;

public class SegmentedBarPage {
    private Find find;
    private Log log;

    public SegmentedBarPage(MobileContext context) {
        this.find = context.find;
        this.log = context.log;
    }

    public UIElement item1() {
        return this.find.byText("Item 1");
    }

    public UIElement item2() {
        return this.find.byText("Item 2");
    }

    public UIElement item3() {
        return this.find.byText("Item 3");
    }

    public void loaded() {
        this.item3();
        this.log.info("SegmentedBar page loaded.");
    }
}
