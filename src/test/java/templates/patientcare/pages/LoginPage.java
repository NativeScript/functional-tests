package templates.patientcare.pages;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage() {
        super();
        UIElement home = this.wait.waitForVisible(this.locators.findByTextLocator("Login", true));
        Assert.assertNotNull(home, "Login page not loaded!");
        this.log.info("Login page loaded.");
    }


    public void login(String user, String pass) {

    }

    public RegisterPage register() {
        UIElement registerButton = this.wait.waitForVisible(this.locators.findByTextLocator("Register", true));
        registerButton.click();
        return new RegisterPage();
    }
}
