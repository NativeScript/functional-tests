package groceries.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.extensions.ExecutionOrder;
import functional.tests.core.mobile.basetest.MobileTest;
import groceries.Screens.ErrorDialog;
import groceries.Screens.LoginPage;
import groceries.Screens.SecondaryLoginPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExecutionOrder.class)
public class LoginFormPage extends MobileTest {

    private LoginPage loginPage;
    private SecondaryLoginPage secondaryLoginPage;

    protected void waitForLoginForm(boolean assertIsLoginFormPageLoaded) {
        try {
            boolean result = this.secondaryLoginPage.loaded();

            if (!result && assertIsLoginFormPageLoaded) {
                Assert.assertTrue(result, "Main login form is not loaded or it is not correct");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void loadLoginForm(boolean assertIsLoginFormPageLoaded) {
        if (!new SecondaryLoginPage().loaded()) {
            this.secondaryLoginPage = this.loginPage.login();
            this.waitForLoginForm(assertIsLoginFormPageLoaded);
        }
    }

    @BeforeClass(alwaysRun = true)
    public void beforeLoginFormPageTestsClass() {
        this.loginPage = new LoginPage();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodLoginForm() {
        if (this.context.lastTestResult != ITestResult.SUCCESS) {
            this.loadLoginForm(true);
        }
    }

    @Test(groups = {"android", "ios"})
    public void groceries_01_initPageLoading() throws Exception {
        this.loginPage.loaded();
        this.compareScreens(20, 1.0);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void groceries_02_login() throws Exception {
        this.loadLoginForm(true);
        this.compareScreens(20, 0.8);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void groceries_03_forgotPassword_OK() throws Exception {
        this.secondaryLoginPage.showForgotPasswordDialog();

        this.compareScreens(this.settings.defaultTimeout, 1.0);

        this.secondaryLoginPage.cancel();
        this.waitForLoginForm(true);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void groceries_04_forgotPassword_Cancel() throws Exception {
        this.secondaryLoginPage.showForgotPasswordDialog();
        ErrorDialog errorDialog = this.secondaryLoginPage.ok();

        if (this.settings.platform == PlatformType.Android) {
            try {
                this.secondaryLoginPage.hideKeyboard();
            } catch (Exception e) {
                this.log.info("Failed to hide keyboard. May be it was not visible!");
            }
        }

        this.compareScreens(this.settings.defaultTimeout, 1.0);

        errorDialog.ok();
        this.waitForLoginForm(true);

        //this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void groceries_05_signUp() throws Exception {
        this.secondaryLoginPage.signUp();
        this.compareScreens(20, 0.1);

        this.secondaryLoginPage.backToLogin();
        this.waitForLoginForm(true);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void groceries_06_loginWithWrongCredentials() throws Exception {
        ErrorDialog error = this.secondaryLoginPage.loginWithWrongName("t");
        this.compareScreens(10, 0.1);

        error.ok();
        this.compareScreens(15, 0.8);

        this.app.restart();
        new LoginPage().loaded();

        this.assertImagesResults();
    }
}
