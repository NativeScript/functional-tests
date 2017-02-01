package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkPlatformModuleTests extends SdkBaseTest {

    protected String page = "Platform Module";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Platform module example"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkPlatformModuleTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
