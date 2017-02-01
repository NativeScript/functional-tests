package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkTextFieldTests extends SdkBaseTest {

    protected String page = "TextField";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Basic TextField"},
                {"TextField binding"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkTextFieldTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
