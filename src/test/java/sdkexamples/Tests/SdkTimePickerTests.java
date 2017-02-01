package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkTimePickerTests extends SdkBaseTest {

    protected String page = "TimePicker";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Configure TimePicker"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkTimePickerTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
