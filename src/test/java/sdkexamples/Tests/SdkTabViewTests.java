package sdkexamples.Tests;


import org.testng.Assert;
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
                {"Usage"},
                {"Styling"},
                {"Tips and Tricks"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkTabViewTest(String example) {
        this.mainPage.navigateTo(example);
        Assert.assertNotNull(this.mainPage.find.byText("First Tab"));
    }
}
