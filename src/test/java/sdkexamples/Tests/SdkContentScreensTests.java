package sdkexamples.Tests;

import functional.tests.core.enums.SwipeElementDirection;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkContentScreensTests extends SdkBaseTest {

    protected String page = "Content Screens";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Content page (auto hide/show image)"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkContentScreenTest(String example) {
        this.mainPage.navigateTo(example);
        if (example.equalsIgnoreCase("Content page (auto hide/show image)")) {
            this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 1000, 100);
            this.gestures.swipeInWindow(SwipeElementDirection.UP, 1000, 100);
        }
    }
}
