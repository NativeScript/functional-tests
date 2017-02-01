package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkModalPageTests extends SdkBaseTest {

    protected String page = "Modal page";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Modal page example"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkModalPageTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
