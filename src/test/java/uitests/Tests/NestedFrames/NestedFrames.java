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
                {"full-screen-n-n"},
                {"full-screen-n-y"},
                {"full-screen-n-y-flat"},
                {"full-screen-y-n"},
                {"full-screen-y-n-flat"},
                {"full-screen-y-y"},
                {"full-screen-y-y-flat"},
                {"mid-screen-n-n"},
                {"mid-screen-n-y"},
                {"mid-screen-n-y-flat"},
                {"mid-screen-y-n"},
                {"mid-screen-y-n-flat"},
                {"mid-screen-y-y"},
                {"mid-screen-y-y-flat"},
                {"tab-y-y"},
                {"tab-y-y-flat"},
                {"tab-n-y"},
                {"tab-n-y-flat"},
                {"tab-y-n"},
                {"tab-y-n-flat"}
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
