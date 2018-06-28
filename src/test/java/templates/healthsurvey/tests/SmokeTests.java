package templates.healthsurvey.tests;

import functional.tests.core.mobile.basetest.MobileTest;
import healthsurvey.pages.LoginPage;
import healthsurvey.pages.RegisterPage;
import healthsurvey.pages.WelcomePage;
import org.testng.annotations.Test;

public class SmokeTests extends MobileTest {

    private static LoginPage homePage;
    private static RegisterPage registerPage;
    private static WelcomePage welcomePage;

    private String email;

    @Test(description = "Verify login page looks OK.", groups = {"android", "ios"})
    public void test_01_home_page() throws Exception {
        // Verify login page
        this.homePage = new LoginPage();
        this.assertScreen("healthsurvey-home", this.settings.defaultTimeout, 0.1);
    }

    @Test(description = "Verify login page looks OK.", groups = {"android", "ios"})
    public void test_02_register() throws Exception {
        // Verify register page
        this.registerPage = homePage.register();
        this.assertScreen("healthsurvey-register", this.settings.defaultTimeout, 0.1);

        this.email = String.format("nativescript_%s@telerik.com", System.currentTimeMillis());
        this.welcomePage = this.registerPage.register(email, "123", "N", "S");
    }

    @Test(description = "Verify login page looks OK.", groups = {"android", "ios"})
    public void test_03_welcome() throws Exception {
        // Verify first screen after login
        this.welcomePage = new WelcomePage();
        this.assertScreen("healthsurvey-welcome", this.settings.defaultTimeout, 0.1);

        this.welcomePage.getStarted();
        this.wait.waitForVisible(this.locators.byText("Step 2 of 9", false, false), true);

        this.welcomePage.next();
        this.wait.waitForVisible(this.locators.byText("Step 3 of 9", false, false), true);

        this.welcomePage.next();
        this.wait.waitForVisible(this.locators.byText("Step 4 of 9", false, false), true);

        this.welcomePage.next();
        this.wait.waitForVisible(this.locators.byText("Step 5 of 9", false, false), true);

        this.welcomePage.next();
        this.wait.waitForVisible(this.locators.byText("Step 6 of 9", false, false), true);

        this.welcomePage.next();
        this.wait.waitForVisible(this.locators.byText("Step 7 of 9", false, false), true);

        this.app.navigateBack();
        this.wait.waitForVisible(this.locators.byText("Step 6 of 9", false, false), true);

        this.app.navigateBack();
        this.wait.waitForVisible(this.locators.byText("Step 5 of 9", false, false), true);

        this.app.navigateBack();
        this.wait.waitForVisible(this.locators.byText("Step 4 of 9", false, false), true);

        this.welcomePage.next();
        this.wait.waitForVisible(this.locators.byText("Step 5 of 9", false, false), true);

        this.homePage = this.welcomePage.cancel();
        this.assertScreen("healthsurvey-home", this.settings.defaultTimeout, 0.1);
    }

    @Test(description = "Verify login page looks OK.", groups = {"android", "ios"})
    public void test_04_login() throws Exception {
        this.homePage.login(email, "123");
    }
}
