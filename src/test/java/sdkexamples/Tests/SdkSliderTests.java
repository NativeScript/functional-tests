package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkSliderTests extends SdkBaseTest {

    protected String page = "Slider";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Usage"},
                {"Styling"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkSliderTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
