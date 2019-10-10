package sdkexamples.Tests;

import functional.tests.core.enums.PlatformType;
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
                {"Usage"},
                {"Styling"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkTextFieldTest(String example) {
        this.mainPage.navigateTo(example);
        if ((this.settings.platform == PlatformType.Android) && (this.settings.platformVersion <= 6.0)) {
            this.app.hideKeyboard();
        }
    }
}
