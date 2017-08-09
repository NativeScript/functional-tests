package uitests.Tests.DatePicker;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

public class DatePickerTest extends UIBaseTests {
    private HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeDatePickerTestClass() {
        this.homePageExtended = new HomePageExtended("date-picker", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void datePicker() throws Exception {
        this.assertScreen(10);
    }
}


