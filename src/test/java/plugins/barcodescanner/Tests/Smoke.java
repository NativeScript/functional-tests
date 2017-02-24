package plugins.barcodescanner.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import plugins.barcodescanner.Screens.DemoPage;
import plugins.barcodescanner.Screens.DialogRequestPermissions;
import plugins.barcodescanner.Screens.HomePage;

public class Smoke extends MobileTest {
    private HomePage homePage;
    private DemoPage demoPage;
    private DialogRequestPermissions dialogRequestPermissions;

    @BeforeClass(alwaysRun = true)
    public void beforeSmokeTestClass() {
        this.homePage = new HomePage();
        this.demoPage = this.homePage.tapDemo();
    }

    @Test
    public void checkAvailability() throws Exception {
        this.demoPage.checkIfAvailable();
        this.dialogRequestPermissions = new DialogRequestPermissions();
        this.dialogRequestPermissions.assertIsAvailable();

        this.dialogRequestPermissions.submitDialog("OK");
    }

    @Test
    public void scan() throws Exception {
        if (this.settings.platform == PlatformType.iOS) {
            if (this.settings.isRealDevice) {
                this.demoPage.backCameraWithFlip();
                this.dialogRequestPermissions.allowPermissions();
                this.compareScreens(5, 0.15D);
                this.demoPage.exitBarcodeScanner();
            }
        } else if (this.settings.platform == PlatformType.Android) {
            this.demoPage.requestPermissionsButton();
            if (this.settings.platformVersion >= 6) {
                this.dialogRequestPermissions.reuestDialogLoaded();
                this.dialogRequestPermissions.allowPermissions();
                this.dialogRequestPermissions.unloaded();
            }
            this.demoPage.backCameraWithFlip();
            if (this.settings.isRealDevice) {
                this.compareScreens(5, 0.15D);
            } else {
                demoPage.assertBarcodeScannerIsLoaded();
            }
            this.homePage.navigateBack();
        }

        if (this.settings.isRealDevice) {
            this.assertImagesResults();
        }
    }
}