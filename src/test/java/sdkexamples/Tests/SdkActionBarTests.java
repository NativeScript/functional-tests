package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkActionBarTests extends SdkBaseTest {

    protected String page = "ActionBar";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Action items"},
                {"Navigation button"},
                {"Title"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkActionBarTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
