package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkSegmentedBarTests extends SdkBaseTest {

    protected String page = "SegmentedBar";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Basic SegmentedBar"},
                {"SegmentedBar view change"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkSegmentedBarTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
