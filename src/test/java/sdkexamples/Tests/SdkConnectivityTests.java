package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkConnectivityTests extends SdkBaseTest {

    protected String page = "Connectivity";

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
    public void sdkConnectivityTest(String example) {
        this.mainPage.navigateTo(example);
    }
}
