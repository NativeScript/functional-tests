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
        if ((this.settings.platform == PlatformType.Android && this.settings.platformVersion != 8.0)
                || settings.platform == PlatformType.iOS) {
            this.mainPage.navigateTo(example);
            if (example.equalsIgnoreCase("Basic location")
                    && ((this.settings.platform == PlatformType.Android && this.settings.platformVersion > 5.1)
                    || settings.platform == PlatformType.iOS)) {
                UIElement btn = this.mainPage.wait.waitForVisible(this.locators.byText("Allow"), 6, false);
                if (btn != null) {
                    btn.tap();
                    this.log.info("Handle popup by clicking allow.");
                    UIElement okbtn = this.mainPage.wait.waitForVisible(this.locators.byText("Ok", false, false), 15, false);
                    if (okbtn != null) {
                        okbtn.tap();
                        this.log.info("Handle popup by clicking ok.");
                    }
                } else {
                    try {
                        this.client.driver.switchTo().alert().accept();
                        this.log.info("Accept alert via driver.");
                    } catch (Exception e) {
                        this.log.info("No alert (or fail to accept it).");
                    }
                }
            } else if (example == "Basic location") {
                UIElement okbtn = this.mainPage.wait.waitForVisible(this.locators.byText("Ok", false, false), 15, false);
                if (okbtn != null) {
                    okbtn.tap();
                    this.log.info("Handle popup by clicking ok.");
                }
            }

            if (example == "Basic location") {
                this.mainPage.wait.waitForVisible(this.locators.byText("Get current location", false, false), 15, true);
            }
            if (example == "Monitoring location") {
                UIElement okbtn = this.mainPage.wait.waitForVisible(this.locators.byText("Ok", false, false), 15, false);
                if (okbtn != null) {
                    okbtn.tap();
                    this.log.info("Handle popup by clicking ok.");
                }
                this.mainPage.wait.waitForVisible(this.locators.byText("Start location monitoring", false, false), 15, true);
            }
        } else {
            this.log.warn("This test don't run on Api26 Google API emulator!");
        }
    }
}
