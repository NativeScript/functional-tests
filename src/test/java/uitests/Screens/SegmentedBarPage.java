package uitests.Screens;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class SegmentedBarPage extends HomePageExtended {

    public SegmentedBarPage(MobileContext context) {
        super("segStyle", context);
        this.loaded();
    }

    public UIElement segmentedBar1() {
        return this.getSegmentedBars().get(0);
    }

    public UIElement segmentedBar2() {
        return this.getSegmentedBars().get(1);
    }


    public void tapGoToCleanPageBtn() {
        this.find.byText("go to cleared page").click();
        this.log.info("Going to cleared page ...");
    }

    public void tapGoToPreviousPageBtn() {
        this.find.byText("go to previous page").click();
        this.log.info("Going to ActionBar page ...");
    }

    public void loaded() {
        if (this.segmentedBar1() != null) {
            this.log.info("SegmentedBar page loaded.");
        } else {
            Assert.fail("SegmentedBar page NOT loaded.");
        }
    }

    private java.util.List<UIElement> getSegmentedBars() {
        if (this.settings.platform == PlatformType.Android) {
            if (this.settings.platformVersion >= 7) {
                this.wait.waitForVisible(this.locators.tabWidgetLocator(), 6, true);
            }
            return this.find.elementsByLocator(this.locators.tabHostLocator());
        } else {
            this.wait.waitForVisible(this.locators.segmentedControlLocator(), 10, true);
            return this.find.elementsByLocator(this.locators.segmentedControlLocator());
        }
    }
}
