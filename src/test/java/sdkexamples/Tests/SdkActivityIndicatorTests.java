package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkActivityIndicatorTests extends SdkBaseTest {

    protected String page = "ActivityIndicator";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Set busy property"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkActivityIndicatorTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
        this.mainPage.find.byText("Modify Busy property").click();
    }
}
