package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkAngularRoutingTests extends SdkBaseTest {

    protected String page = "Angular routing";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Nested routers"},
        };
    }

    @Test(dataProvider = "example")
    public void sdkAngularRoutingTest(String example) {
        this.mainPage.navigateTo(example);
        if (example.equalsIgnoreCase("Nested routers")) {
            this.wait.waitForVisible(this.locators.byText("First")).tap();
            this.wait.waitForVisible(this.locators.byText("This is FIRST. Load SECOND"), true);
            this.wait.waitForVisible(this.locators.byText("Second")).tap();
            this.wait.waitForVisible(this.locators.byText("This is SECOND. Load FIRST"), true);
        }
    }
}
