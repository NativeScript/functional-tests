package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkApplicationSettingsTests extends SdkBaseTest {

    protected String page = "Application Settings";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Working with values"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkApplicationSettingsTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
