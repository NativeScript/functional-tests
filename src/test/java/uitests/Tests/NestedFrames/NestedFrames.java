package uitests.Tests.NestedFrames;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

public class NestedFrames extends UIBaseTests {
    private HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeLayoutsTestsClass() {
        this.homePageExtended = new HomePageExtended("nested-frames", this.context);
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"full-screen-n-y"},
                {"full-screen-y-n"},
                {"full-screen-y-y"},
                {"mid-screen-n-n"},
                {"mid-screen-n-y"},
                {"mid-screen-y-n"},
                {"mid-screen-y-y"},
                {"tab-y-y"},
                {"tab-n-y"},
                {"tab-y-n"},
                {"tab-n-n"}
        };
    }

    @Test(dataProvider = "example")
    public void nested_frames_test(String example) throws Exception {
        this.homePageExtended.navigateTo(example);
        this.compareScreens(example, 5);
        this.assertImagesResults();
        this.homePageExtended.getNavigationManager().slideBack();
    }


}
