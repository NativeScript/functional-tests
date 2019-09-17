package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkFormattedStringTests extends SdkBaseTest {

    protected String page = "Formatted String";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Usage"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkFormattedStringTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
