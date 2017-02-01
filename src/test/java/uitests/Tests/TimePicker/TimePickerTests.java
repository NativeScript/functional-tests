package uitests.Tests.TimePicker;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

public class TimePickerTests extends UIBaseTests {
    private HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeSegmentedBarTestsClass() {
        this.homePageExtended = new HomePageExtended("timePicker", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void timePicker_01() throws Exception {
        this.compareElements(this.homePageExtended.find.byTextContains("timePicker"), 2);

        this.assertImagesResults();
    }
}
