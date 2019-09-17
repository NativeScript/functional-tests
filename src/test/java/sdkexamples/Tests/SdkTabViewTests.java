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
                {"Basics"},
                {"Styling Tab View"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkTabViewTest(String example) {
        this.mainPage.navigateTo(example);
        if (example.equals("Basics")) {
            Assert.assertNotNull(this.mainPage.find.byText("First Tab"));
        } else if (example.equals("Styling Tab View")) {
            Assert.assertNotNull(this.mainPage.find.byText("first tab"));

        }
    }
}
