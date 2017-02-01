package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkTimerModuleTests extends SdkBaseTest {

    protected String page = "Timer Module";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"setInterval example"},
                {"setTimeout example"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkTimerModuleTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
