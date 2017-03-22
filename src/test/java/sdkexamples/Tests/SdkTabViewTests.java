package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkTabViewTests extends SdkBaseTest {

    protected String page = "TabView";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Basic TabView"},
                {"TabView items"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkTabViewTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
        if (example == "TabView items") {
            this.mainPage.find.byText("OK", 3).click();
        }
    }
}
