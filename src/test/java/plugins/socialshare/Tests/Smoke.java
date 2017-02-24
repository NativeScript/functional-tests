package plugins.socialshare.Tests;

import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import plugins.socialshare.Screens.HomePage;

public class Smoke extends MobileTest {
    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeSmokeClass() {
        this.homePage = new HomePage();
    }

    @Test
    public void SocialShare_01_ShareText() throws Exception {
        this.homePage.loaded();
        this.homePage.tapShareTextButton();
        this.homePage.verifyShareTextDialog();
        this.log.logScreen("ShareText", "ShareText");
        if (this.settings.platform == PlatformType.Android) {
            this.homePage.navigateBack();
            if ((this.settings.platformVersion.toString().contains("5.")) || (this.settings.platformVersion.toString().contains("6."))) {
                // Navigate back one more time to hide keyboard
                this.homePage.navigateBack();
                if (this.settings.platformVersion.toString().contains("5.")) {
                    // Click OK
                    UIElement ok = this.find.byLocator(this.locators.findByTextLocator("android.widget.Button", "OK", true, false));
                    ok.click();
                }
            }
            this.homePage.loaded();
        }
    }

    @Test
    public void SocialShare_02_ShareImage() throws Exception {
        this.homePage.tapShareImageButton();
        this.homePage.verifyShareImageDialog();
        this.log.logScreen("ShareImage", "ShareImage");
    }
}
