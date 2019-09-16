package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkScrollViewTests extends SdkBaseTest {

    protected String page = "ScrollView";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Horizontal orientation"},
                {"Vertical orientation"},
                {"Scroll event"},
                {"Enable/Disable scroll"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkScrollViewTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
