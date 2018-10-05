package sdkexamples.Tests;


import org.openqa.selenium.By;
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
                {"Styling Tab View"},
                {"Navigation"},
                {"Using icon font in TabView"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkTabViewTest(String example) {
        this.mainPage.navigateTo(example);
        if (example.equals("Basic")) {
            Assert.assertNotNull(this.mainPage.find.byText("First Tab"));
        } else if (example.equals("Styling Tab View")) {
            Assert.assertNotNull(this.mainPage.find.byText("First Tab"));
        } else if (example.equals("Navigation")) {
            By locator = this.locators.byText("Change Tab via ngModel", true, false);
            Assert.assertNotNull(this.mainPage.find.byLocator(locator));
        } else if (example.equals("Using icon font in TabView")) {
            Assert.assertNotNull(this.mainPage.find.byText("Icon Font", false, this.settings.shortTimeout));
        }
    }
}
