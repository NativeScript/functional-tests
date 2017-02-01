package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkImageTests extends SdkBaseTest {

    protected String page = "Image";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Create Image"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkImageTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
