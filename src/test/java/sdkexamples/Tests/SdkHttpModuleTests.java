package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkHttpModuleTests extends SdkBaseTest {

    protected String page = "HTTP Module";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"HTTP POST"},
                {"HTTP GET"},
                {"HTTP PUT"},
                {"HTTP DELETE"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkHttpModuleTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
