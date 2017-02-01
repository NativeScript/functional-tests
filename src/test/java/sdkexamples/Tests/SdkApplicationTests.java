package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkApplicationTests extends SdkBaseTest {

    protected String page = "Application";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Checking Target Platform"},
                {"Using Android Specifics"},
                {"Using iOS Specifics"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkApplicationTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
