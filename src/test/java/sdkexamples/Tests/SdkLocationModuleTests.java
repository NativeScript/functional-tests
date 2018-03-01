package sdkexamples.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
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
        // This only works on Google API emulators (and it currently crash on Api26, no idea why)
        if (this.settings.platformVersion == 7.1 || this.settings.platform == PlatformType.iOS) {
            this.mainPage.navigateTo(example);
            if (this.settings.platformVersion <= 4.4 && this.settings.platform == PlatformType.Android) {
                UIElement el = this.mainPage.wait.waitForVisible(this.locators.byText("RECENT LOCATION REQUESTS", false, false), 6, false);
                if (el != null) {
                    this.app.navigateBack();
                }
            } else if (example == "Basic location" && ((this.settings.platform == PlatformType.Android && this.settings.platformVersion > 5.1) || settings.platform == PlatformType.iOS)) {
                UIElement btn = this.mainPage.wait.waitForVisible(this.locators.byText("Allow"), 6, false);
                if (btn != null) {
                    btn.tap();
                    this.log.info("Handle popup by clicking allow.");
                } else {
                    try {
                        this.client.driver.switchTo().alert().accept();
                        this.log.info("Accept alert via driver.");
                    } catch (Exception e) {
                        this.log.info("No alert (or fail to accept it).");
                    }
                }
            }

            if (example == "Basic location") {
                this.mainPage.wait.waitForVisible(this.locators.byText("Get current", false, false), 6, true);
            }
            if (example == "Monitoring location") {
                this.mainPage.wait.waitForVisible(this.locators.byText("Start location", false, false), 6, true);
            }
        } else {
            this.log.warn("This test runs only on Api25 Google API emulator!");
        }
    }
}
