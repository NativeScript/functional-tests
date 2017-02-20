package plugins.imageupload.Tests;

import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.enums.PlatformType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import plugins.imageupload.Screens.HomePage;
import plugins.imageupload.Screens.PickerPage_Android;
import plugins.imageupload.Screens.PickerPage_iOS;

public class Smoke extends MobileTest {
    String sdCardBasePath = "/storage/sdcard/";
    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeSmokeClass() {
        this.homePage = new HomePage(this.context);
    }

    @Test(groups = {"android"})
    public void initGallery() throws Exception {
        // Ensure page is loaded, file push fails if you try to push too early
        this.homePage.loaded();

        this.log.info("Push sample images on device.");

        this.device.pushFile("pictures/7392261.jpeg", sdCardBasePath + "Pictures/pic1.jpeg");
        this.device.pushFile("pictures/7392261.jpeg", sdCardBasePath + "Pictures/pic2.jpeg");
        this.device.pushFile("pictures/7392261.jpeg", sdCardBasePath + "Pictures/pic3.jpeg");
        this.device.pushFile("pictures/7392261.jpeg", sdCardBasePath + "Download/pic1.jpeg");
        this.device.pushFile("pictures/7392261.jpeg", sdCardBasePath + "Download/pic2.jpeg");
        this.device.pushFile("pictures/7392261.jpeg", sdCardBasePath + "Download/pic3.jpeg");
        this.device.pushFile("pictures/7392261.jpeg", sdCardBasePath + "DCIM/pic1.jpeg");
        this.device.pushFile("pictures/7392261.jpeg", sdCardBasePath + "DCIM/pic2.jpeg");
        this.device.pushFile("pictures/7392261.jpeg", sdCardBasePath + "DCIM/pic3.jpeg");

        this.context.client.stopDriver();
        this.context.server.stopServer();
        this.device.stop();
        this.device.start();
        this.context.server.initServer();
        this.context.client.initDriver();

        this.homePage.loaded();
        this.log.logScreen("imagepicker_home", "ImagePicker: Home SdkPage");
    }

    @Test(groups = {"android", "ios"})
    public void pickSingle() throws Exception {
        this.homePage.pickSingleImage();

        if (this.settings.platform == PlatformType.Android) {
            PickerPage_Android pickerPage_android = new PickerPage_Android(this.context);
            pickerPage_android.loaded();
            pickerPage_android.pickImages(1);
            this.homePage.loaded();
            this.homePage.wait.waitForVisible(this.locators.byText("/storage/sdcard/"), false);
        } else if (this.settings.platform == PlatformType.iOS) {
            PickerPage_iOS pickerPage_iOS = new PickerPage_iOS(this.context);
            pickerPage_iOS.loaded();
            pickerPage_iOS.pickImages("Camera Roll", 1);
            this.homePage.loaded();
            this.homePage.wait.waitForVisible(this.locators.byText("IMG_0001.JPG"), false);
        }

        this.log.logScreen("imagepicker_single", "ImagePicker: Single Item");
    }

    @Test(groups = {"android", "ios"})
    public void pickMultiple() throws Exception {
        HomePage homePage = new HomePage(this.context);
        homePage.loaded();
        homePage.pickMultipleImages();

        if (this.settings.platform == PlatformType.Android) {
            PickerPage_Android pickerPage_android = new PickerPage_Android(this.context);
            pickerPage_android.loaded();
            pickerPage_android.pickImages(2);
            homePage.loaded();
            this.homePage.wait.waitForVisible(this.locators.byText("/storage/sdcard/"), false);
        } else if (this.settings.platform == PlatformType.iOS) {
            PickerPage_iOS pickerPage_iOS = new PickerPage_iOS(this.context);
            pickerPage_iOS.loaded();
            pickerPage_iOS.pickImages("Camera Roll", 3);
            homePage.loaded();
            this.homePage.wait.waitForVisible(this.locators.byText("IMG_0001.JPG"), false);
            this.homePage.wait.waitForVisible(this.locators.byText("IMG_0002.JPG"), false);
            this.homePage.wait.waitForVisible(this.locators.byText("IMG_0003.JPG"), false);
        }
        this.log.logScreen("imagepicker_multiple", "ImagePicker: Multiple Item");
    }
}