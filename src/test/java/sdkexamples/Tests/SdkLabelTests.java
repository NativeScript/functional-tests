package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkLabelTests extends SdkBaseTest {

    protected String page = "Label";

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
    public void sdkLabelTest(String example) {
        this.mainPage.navigateTo(example);
    }
}
