package templates.patientcare.tests;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import templates.patientcare.pages.CareContentPage;
import templates.patientcare.pages.LoginPage;
import templates.patientcare.pages.RegisterPage;

public class SmokeTests extends MobileTest {

    private static LoginPage homePage;
    private static RegisterPage registerPage;
    private static CareContentPage careContentPage;

    @Test(description = "Verify login page looks OK.", groups = {"android", "ios"})
    public void test_01_home_page() throws Exception {
        // Verify login page
        this.homePage = new LoginPage();
        this.assertScreen("patientcare-home", this.settings.defaultTimeout);
    }

    @Test(description = "Verify login page looks OK.", groups = {"android", "ios"})
    public void test_02_register() throws Exception {
        // Verify register page
        this.registerPage = this.homePage.register();
        this.assertScreen("patientcare-register", this.settings.defaultTimeout);

        String email = String.format("nativescript_%s@telerik.com", System.currentTimeMillis());
        this.careContentPage = this.registerPage.register(email, "123", "N", "S");
    }

    @Test(description = "Verify login page looks OK.", groups = {"android", "ios"})
    public void test_03_carecontent() throws Exception {
        // Verify first screen after login
        this.careContentPage = new CareContentPage();
        this.assertScreen("patientcare-care-content", this.settings.defaultTimeout, 5.0);

        // Navigate to second tab.
        this.careContentPage.openConnect();
        this.assertScreen("patientcare-connect", this.settings.defaultTimeout);
        Assert.assertEquals(careContentPage.getCurrentTab().toLowerCase(), "connect");

        // Run in background should restore the app on same tab.
        this.app.runInBackground(10);
        Assert.assertEquals(careContentPage.getCurrentTab().toLowerCase(), "connect");

        // Restart should start it from default (first) tab.
        this.app.restart();
        this.assertScreen("patientcare-care-content", this.settings.defaultTimeout, 5.0);
        Assert.assertEquals(careContentPage.getCurrentTab().toLowerCase(), "care contents");
    }
}
