package nativescriptdemo.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QsfDemosTests extends QsfBaseTest {

    @AfterMethod(groups = {"android", "ios"})
    public void afterQsfDemosTest() {
        this.homePage.navigateBack();
        if (this.homePage.loaded() == false) {
            Assert.fail("Home page NOT loaded");
        }
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Layouts"},
                {"User profile"},
                {"Conference agenda"},
                {"Bar series"},
                {"Line series"},
                {"Area series"},
                {"Pie series"},
                {"Item layouts"},
                {"Item reorder"},
                {"Selection"},
                {"Reservations"},
        };
    }

    @Test(groups = {"android", "ios"}, dataProvider = "example")
    public void test_example(String example) {
        // Go to demo
        this.homePage.navigateTo(example);

        // Hack for Reservations demo which title ActionBar title is `DataForm`
        if (example.equalsIgnoreCase("Reservations")) {
            example = "DataForm";
        }

        // Verify it is loaded
        By demoLocator = By.xpath("//*[@content-desc='ActionBar']//*[@text='" + example + "']");
        if (this.settings.platform == PlatformType.iOS) {
            demoLocator = By.xpath("//*[@label='ActionBar']//*[@label='" + example + "']");
        }
        UIElement demoTitle = this.wait.waitForVisible(demoLocator, this.settings.shortTimeout, false);
        Assert.assertNotNull(demoTitle, demoTitle + "not loaded.");

        // Log current screen
        this.log.logScreen(example.replace(" ", ""), example);
    }
}
