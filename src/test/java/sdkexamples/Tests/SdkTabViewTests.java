package sdkexamples.Tests;

import org.springframework.util.Assert;
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
        if (example == "Basic TabView") {
            Assert.notNull(this.mainPage.find.byText("NativeScript"));
        } else if (example == "TabView items") {
            Assert.notNull(this.mainPage.find.byText("TabView item with Icon"));
        }
    }
}
