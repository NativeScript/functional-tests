package uitests.Tests.SegmentedStyle;

import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.mobile.element.UIElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.SegmentedBarPage;

public class SegmentedBarTests extends MobileTest {
    private SegmentedBarPage segmentedBarPage;

    @BeforeClass(alwaysRun = true)
    public void beforeSegmentedBarTestsClass() {
        this.segmentedBarPage = new SegmentedBarPage(this.context);
    }

    @Test(groups = {"android", "ios"})
    public void segmentedBar_01() throws Exception {
        this.compareScreens();
        this.assertImagesResults();
    }

    @Test(enabled = false, groups = {"android", "ios"})
    public void segmentedBar_02_clean() throws Exception {
        this.segmentedBarPage.tapGoToCleanPageBtn();
        this.compareElements(this.segmentedBarPage.segmentedBar1(), 5, 0.1);
        this.assertImagesResults();
    }

    @Test(enabled = false, groups = {"android", "ios"})
    public void segmentedBar_03() throws Exception {
        this.segmentedBarPage.tapGoToPreviousPageBtn();
        this.compareElements(this.segmentedBarPage.segmentedBar1(), 5, 0.1);
        this.assertImagesResults();
    }

    //remove for ios because press action is not supported anymore in ios
    @Test(enabled = false, groups = {"android"})
    public void segmentedBar_issue_3137_segmentedBarRippleEffect() throws Exception {
        UIElement element = this.segmentedBarPage.segmentedBar2().findElement(this.locators.byText("Item 1"));
        element.pressAndHold();
        this.compareElements(this.segmentedBarPage.segmentedBar2(), 10, 0d);
        this.assertImagesResults();
    }
}
