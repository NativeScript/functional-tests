package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkProgressTests extends SdkBaseTest {

    protected String page = "Progress";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Create Progress"},
                {"Set up Progress"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkProgressTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
