package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkCameraTests extends SdkBaseTest {

    protected String page = "Camera";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Using Camera module"}
        };
    }

    @Test(dataProvider = "example", timeOut = 120 * 1000)
    public void sdkCameraTest(String example) {
        this.mainPage.navigateTo(example);
        this.wait.waitForVisible(this.locators.byText("Request permissions"), true);
    }
}
