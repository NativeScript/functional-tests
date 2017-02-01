package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkGesturesTests extends SdkBaseTest {

    protected String page = "Gestures";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Tap"},
                {"Double tap"},
                {"Long press"},
                {"Swipe"},
                {"Pan"},
                {"Pinch"},
                {"Rotation"},
                {"Touch"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkGesturesTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
