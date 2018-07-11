package sdkexamples.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkCameraTests extends SdkBaseTest {

    protected String page = "Camera";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Using Camera module"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkCameraTest(String example) {
        this.mainPage.navigateTo(example);
        if (example.equalsIgnoreCase("Using Camera module")) {
            // Get permissions
            this.wait.waitForVisible(this.locators.byText("Request permissions")).tap();
            if (this.settings.platform == PlatformType.Android) {
                UIElement popup = this.wait.waitForVisible(this.locators.byText("1 of 2"),
                        this.settings.shortTimeout, false);
                if (popup != null) {
                    this.log.info("Grant permissions...");
                    this.wait.waitForVisible(this.locators.byText("ALLOW")).tap();
                    this.wait.waitForVisible(this.locators.byText("2 of 2"), true);
                    this.wait.waitForVisible(this.locators.byText("ALLOW")).tap();
                } else {
                    this.log.info("Permissions already granted!");
                }
            }

            // Take photo
            this.wait.waitForVisible(this.locators.byText("Take Photo")).tap();
            if (this.settings.platform == PlatformType.Android) {
                this.wait.waitForVisible(By.id("Shutter button")).tap();
                this.log.info("Tap shutter button.");
                this.wait.waitForVisible(By.id("com.android.camera:id/btn_done")).tap();
                this.log.info("Tap done button.");
            } else {
                this.wait.waitForVisible(By.id("Moments")).tap();
                this.wait.waitForVisible(By.xpath("//*[@name='PhotosGridView']//XCUIElementTypeCell[3]")).tap();
            }

            // Assert you are back to demo page and image is visible
            this.wait.waitForVisible(this.locators.byText("Request permissions"), true);
            this.wait.waitForVisible(this.locators.byText("Take Photo"), true);
            if (this.settings.platform == PlatformType.Android) {
                // For unknown reason image is displayed only on Android.
                this.wait.waitForVisible(this.locators.imageLocator(), true);
            }
        }
    }
}
