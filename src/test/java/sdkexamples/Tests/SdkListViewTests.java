package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkListViewTests extends SdkBaseTest {

    protected String page = "ListView";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Usage"},
                {"Styling"},
                {"Tips and Tricks"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkListViewTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
