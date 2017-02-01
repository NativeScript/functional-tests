package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkStyleTests extends SdkBaseTest {

    protected String page = "Style";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Add Style via CSS file"},
                {"Apply Style using code"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkStyleTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
