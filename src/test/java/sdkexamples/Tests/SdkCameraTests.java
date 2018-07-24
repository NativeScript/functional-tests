package sdkexamples.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Wait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
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

    @Test(dataProvider = "example", timeOut = 120 * 1000)
    public void sdkCameraTest(String example) {
        this.mainPage.navigateTo(example);
        if (this.settings.platformVersion == 8.0) {
            this.log.info("Skip the test on Emulator-Api26-Google because of emu settings issues.");
        } else {
            if (example.equalsIgnoreCase("Using Camera module")) {
                // Get permissions (this handle Android up to 6.0, after 6.0 permissions are required later).
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
                } else {
                    Wait.sleep(3000);
                    UIElement popup = this.wait.waitForVisible(this.locators.byText("OK"), this.settings.shortTimeout, false);
                    if (popup != null) {
                        this.log.info("Grant permissions...");
                        popup.tap();
                    } else {
                        this.log.info("Permissions already granted!");
                    }
                }

                // Take photo
                this.wait.waitForVisible(this.locators.byText("Take Photo")).tap();
                if (this.settings.platform == PlatformType.Android) {
                    // Handle Android 7.0+
                    if (this.settings.platformVersion == 7.0) {
                        UIElement popup = this.wait.waitForVisible(this.locators.byText("ALLOW"),
                                this.settings.shortTimeout, false);
                        if (popup != null) {
                            this.log.info("Grant permissions...");
                            popup.tap();
                            this.wait.waitForVisible(this.locators.byText("NEXT")).tap();
                        }
                    } else {
                        this.log.info("Permissions already granted!");
                    }

                    By shutterButtonLocator = By.id("Shutter button");
                    By doneButtonLocator = By.id("com.android.camera:id/btn_done");
                    if (this.settings.platformVersion == 7.0) {
                        shutterButtonLocator = By.id("com.android.camera2:id/shutter_button");
                        doneButtonLocator = By.id("com.android.camera2:id/done_button");
                    }
                    if (this.settings.platformVersion == 7.1) {
                        shutterButtonLocator = By.id("com.android.camera:id/shutter_button");
                        doneButtonLocator = By.id("com.android.camera:id/btn_done");
                    }
                    if (this.settings.platformVersion >= 27.0) {
                        // Camera wants location permissions on Api27
                        UIElement popup = this.wait.waitForVisible(this.locators.byText("ALLOW"), this.settings.shortTimeout, false);
                        if (popup != null) {
                            popup.tap();
                        }
                        popup = this.wait.waitForVisible(this.locators.byText("NEXT"), this.settings.shortTimeout, false);
                        if (popup != null) {
                            this.wait.waitForVisible(this.locators.byText("NEXT")).tap();
                        }
                        shutterButtonLocator = By.id("com.android.camera2:id/shutter_button");
                        doneButtonLocator = By.id("com.android.camera2:id/done_button");
                    }
                    this.wait.waitForVisible(shutterButtonLocator).tap();
                    this.log.info("Tap shutter button.");
                    this.wait.waitForVisible(doneButtonLocator).tap();
                    this.log.info("Tap done button.");
                } else {
                    if (this.settings.deviceName.toLowerCase().contains("x")) {
                        Point p = this.wait.waitForVisible(By.id("Moments")).getCenter();
                        new TouchAction(this.client.driver).tap(PointOption.point(p.x, p.y + 10)).perform();
                    } else {
                        this.wait.waitForVisible(By.id("Moments")).tap();
                    }
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
}
