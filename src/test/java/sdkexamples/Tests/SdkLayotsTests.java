package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkLayotsTests extends SdkBaseTest {

    protected String page = "Layouts";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"AbsoluteLayout"},
                {"DockLayout"},
                {"GridLayout"},
                {"StackLayout"},
                {"WrapLayout"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkLayoutsTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
