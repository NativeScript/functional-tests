package templates.enterpriseauth.tests;

import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.utils.OSUtils;
import org.testng.annotations.Test;
import templates.enterpriseauth.pages.HomePage;
import templates.enterpriseauth.pages.LoginPage;

@SuppressWarnings("groupsTestNG")
public class SmokeTests extends MobileTest {
    private String userName = OSUtils.getEnvironmentVariable("kinveyUserName", null);
    private String userPass = OSUtils.getEnvironmentVariable("kinveyUserPass", null);
    private LoginPage login;
    private HomePage home;

    @Test(groups = {"android", "ios"})
    public void test_01_loginPage() throws Exception {
        login = new LoginPage();
        this.assertScreen("enterprise-auth-login", this.settings.defaultTimeout, 0.1);
    }

    @Test(groups = {"android", "ios"})
    public void test_02_login() throws Exception {
        // Login
        login.login(userName, userPass);

        // Verify logged in
        home = new HomePage();

        // Verify look and feel
        this.assertScreen("enterprise-auth-home", this.settings.defaultTimeout, 0.1);
    }

    @Test(groups = {"android", "ios"})
    public void test_03_logout() {
        home.logout();
        login = new LoginPage();
    }
}
