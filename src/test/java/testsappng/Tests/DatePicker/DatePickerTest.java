package testsappng.Tests.DatePicker;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.HomePage;
import testsappng.TestsAppNgBase;

public class DatePickerTest extends TestsAppNgBase {
    protected HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeDatePickerTestClass() throws Exception {
        this.homePage = new HomePage("DatePicker", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void issue_649() throws Exception {
        this.homePage.navigateTo("issue-649");
        this.compareScreens(5);
        this.homePage.find.byText("with scroll").tap();
        this.compareScreens(5);
        this.assertImagesResults();
    }
}