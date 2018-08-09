package templates.healthsurvey.tests;

import functional.tests.core.mobile.basetest.MobileTest;
import templates.healthsurvey.pages.LoginPage;
import templates.healthsurvey.pages.RegisterPage;
import templates.healthsurvey.pages.WelcomePage;
import org.testng.annotations.Test;

public class SmokeTests extends MobileTest {

    private static LoginPage homePage;
    private static RegisterPage registerPage;
    private static WelcomePage welcomePage;

    private String email;

    @Test(description = "Verify login page looks OK.", groups = {"android", "ios"})
    public void test_01_home_page() throws Exception {
        // Verify login page
        homePage = new LoginPage();
        this.assertScreen("healthsurvey-home", this.settings.defaultTimeout, 0.1);
    }

    @Test(description = "Verify login page looks OK.", groups = {"android", "ios"})
    public void test_02_register() throws Exception {
        // Verify register page
        registerPage = homePage.register();
        this.assertScreen("healthsurvey-register", this.settings.defaultTimeout, 0.1);

        this.email = String.format("nativescript_%s@telerik.com", System.currentTimeMillis());
        welcomePage = registerPage.register(email, "123", "N", "S");
    }

    @Test(description = "Verify login page looks OK.", groups = {"android", "ios"})
    public void test_03_welcome() throws Exception {
        // Verify first screen after login
        welcomePage = new WelcomePage();
        this.assertScreen("healthsurvey-welcome", this.settings.defaultTimeout, 0.1);

        welcomePage.getStarted();
        this.wait.waitForVisible(this.locators.byText("Step 2 of 9", false, false), true);

        welcomePage.next();
        this.wait.waitForVisible(this.locators.byText("Step 3 of 9", false, false), true);

        welcomePage.next();
        this.wait.waitForVisible(this.locators.byText("Step 4 of 9", false, false), true);

        welcomePage.next();
        this.wait.waitForVisible(this.locators.byText("Step 5 of 9", false, false), true);

        welcomePage.next();
        this.wait.waitForVisible(this.locators.byText("Step 6 of 9", false, false), true);

        welcomePage.next();
        this.wait.waitForVisible(this.locators.byText("Step 7 of 9", false, false), true);

        this.app.navigateBack();
        this.wait.waitForVisible(this.locators.byText("Step 6 of 9", false, false), true);

        this.app.navigateBack();
        this.wait.waitForVisible(this.locators.byText("Step 5 of 9", false, false), true);

        this.app.navigateBack();
        this.wait.waitForVisible(this.locators.byText("Step 4 of 9", false, false), true);

        welcomePage.next();
        this.wait.waitForVisible(this.locators.byText("Step 5 of 9", false, false), true);

        homePage = welcomePage.cancel();
        this.assertScreen("healthsurvey-home", this.settings.defaultTimeout, 0.1);
    }

    @Test(description = "Verify login page looks OK.", groups = {"android", "ios"})
    public void test_04_login() {
        homePage.login(email, "123");
    }
}
