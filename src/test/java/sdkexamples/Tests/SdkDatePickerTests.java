package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkDatePickerTests extends SdkBaseTest {

    protected String page = "DatePicker";

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
    public void sdkDataPickerTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
