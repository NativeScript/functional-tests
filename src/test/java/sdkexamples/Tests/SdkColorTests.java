package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkColorTests extends SdkBaseTest {

    protected String page = "Color";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Creating Colors"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkColorTest(String example) {
        this.mainPage.navigateTo(example);
    }
}
