package plugins.cameramodule;

import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class CameraModuleTests extends MobileTest {

    private CameraModulePage cameraModulePage;

    @BeforeClass(alwaysRun = true)
    public void beforeCameraModuleTestsClass() {
        this.cameraModulePage = new CameraModulePage();
    }

    @AfterClass(alwaysRun = true)
    public void afterCameraModuleTestsClass() {
        this.client.getDriver().rotate(ScreenOrientation.PORTRAIT);
    }

    @Test(groups = {"android", "ios"})
    public void snapshot_01_image() {
        this.requestPermissions();
        this.acceptPermissions();
        this.launchCameraRecorder();
        this.snapshot();

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void snapshot_02_cancel() throws Exception {
        this.launchCameraRecorder();
        this.btnCancel().tap();
        if (this.settings.platform == PlatformType.iOS && this.settings.isRealDevice) {
            this.compareScreens(10);
        } else {
            UIElement image = this.getImageOfMainScreen();
            Rectangle rec = image.getUIRectangle();
            Assert.assertTrue(rec.width > 100);
            Assert.assertTrue(rec.height > 100);
            this.log.logScreen(this.context.getTestName(), this.context.getTestName());
        }

        this.assertImagesResults();
    }


    @Test(groups = {"android", "ios"})
    public void snapshot_03_rotate() throws Exception {
        this.context.device.rotate(ScreenOrientation.LANDSCAPE);
        this.launchCameraRecorder();
        this.snapshot();

        this.context.device.rotate(ScreenOrientation.PORTRAIT);
        if (this.settings.isRealDevice) {
            this.compareScreens(20);
            this.assertImagesResults();
        }
        this.log.logScreen(this.context.getTestName(), this.context.getTestName());
    }

    private UIElement getImageOfMainScreen() {
        return this.cameraModulePage.wait.waitForVisible(this.locators.imageLocator(), 3, true);
    }

    private void requestPermissions() {
        this.banRequestPermissions().tap();
    }

    private void acceptPermissions() {
        By locator;
        if (this.settings.platform == PlatformType.iOS) {
            locator = this.locators.byText("OK", false, false);
        } else {
            locator = this.locators.byText("Allow", true, false);
        }
        UIElement allow = this.cameraModulePage.wait.waitForVisible(locator, 6, false);
        if (allow == null) {
            return;
        }
        if (this.settings.platform == PlatformType.Android) {
            allow.tap();
        }

        allow.tap();
    }

    private void snapshot() {
        if (this.settings.platform == PlatformType.Android) {
            UIElement btn = this.cameraModulePage.wait.waitForVisible(this.locators.byText("shutter_button", false, false), 6, false);
            btn.tap();
            //onscreen_scene_indicator
            UIElement acceptBtn = this.cameraModulePage.wait.waitForVisible(this.locators.byText("done", false, false), 6, false);
            acceptBtn.tap();
        } else {
            if (this.settings.isRealDevice) {
                UIElement moments = this.cameraModulePage.wait.waitForVisible(this.locators.byText("Take Picture", true, true), 3, true);
                moments.tap();
                UIElement image = this.cameraModulePage.wait.waitForVisible(this.locators.byText("Use Photo", false, false));
                image.tap();
            } else {
                UIElement moments = this.cameraModulePage.wait.waitForVisible(this.locators.byText("Moments", true, true), 3, true);
                moments.click();
                UIElement image = this.cameraModulePage.find.elementsByLocator(this.locators.buttonLocator()).get(4);
                image.tap();
            }
        }

        if (this.settings.isRealDevice) {
            try {
                this.compareScreens(15);
            } catch (Exception e) {
                this.log.error(e.getMessage());
            }
        } else {
            //java.awt.Rectangle[x=15,y=206,width=450,height=477] android
            UIElement image = this.getImageOfMainScreen();
            Rectangle rec = image.getUIRectangle();
            Assert.assertTrue(rec.width > 100);
            Assert.assertTrue(rec.height > 100);
            //java.awt.Rectangle[x=15,y=206,width=450,height=477]
            this.log.logScreen(this.context.getTestName(), this.context.getTestName());
        }
    }

    private UIElement banRequestPermissions() {
        return this.cameraModulePage.wait.waitForVisible(this.locators.byText("Request Permissions", false, false));
    }

    private UIElement btnTakePicture() {
        return this.find.byLocator(this.locators.byText("Take", false, false));
    }

    private UIElement btnCancel() {
        String cancel = (this.settings.platformVersion >= 7 && this.settings.platform == PlatformType.Android) ? "closeButton" : "Cancel";

        return this.find.byLocator(this.locators.byText(cancel, false, false));
    }

    private void launchCameraRecorder() {
        this.btnTakePicture().tap();
        if (this.settings.platform == PlatformType.iOS) {
            this.acceptPermissions();
        }
    }
}
