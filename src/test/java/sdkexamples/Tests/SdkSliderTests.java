package sdkexamples.Tests;

import functional.tests.core.mobile.element.UIElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkSliderTests extends SdkBaseTest {

    protected String page = "Slider";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Basic Slider"},
                {"Access"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkSliderTest(String example) throws Exception {
        UIElement btn = this.find.byTextContains(example);
        this.mainPage.navigateTo(btn);
    }
}
