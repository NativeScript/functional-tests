package sdkexamples.Tests;

import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkLocationModuleTests extends SdkBaseTest {

    protected String page = "Location";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Basic location"},
                {"Monitoring location"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkLocationModuleTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
        if (this.settings.platformVersion <= 4.4 && this.settings.platform == PlatformType.Andorid) {
            UIElement el = this.mainPage.wait.waitForVisible(this.locators.byText("RECENT LOCATION REQUESTS", false, false), 6, false);
            if (el != null) {
                this.app.navigateBack();
            }
        } else if (example == "Basic location" && ((this.settings.platform == PlatformType.Andorid && this.settings.platformVersion > 5.1) || settings.platform == PlatformType.iOS)) {
            UIElement btn = this.mainPage.wait.waitForVisible(this.locators.byText("Allow"), 6, false);
            if (btn != null) {
                btn.tap();
            }
        }

        this.mainPage.wait.waitForVisible(this.locators.byText("Start location", false, false), 6, true);
    }
}
