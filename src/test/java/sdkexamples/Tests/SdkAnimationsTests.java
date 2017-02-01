package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkAnimationsTests extends SdkBaseTest {

    protected String page = "Animations";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Animate properties"},
                {"Chaining animation"},
                {"Animate multiple views"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkAnimationsTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
