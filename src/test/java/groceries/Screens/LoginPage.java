package groceries.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import functional.tests.core.exceptions.AppiumException;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public UIElement btnLogin;

    public LoginPage() {
        super();
    }

    public By loginButtonLocator() {
        return this.locators.byText("Login", false, false);
    }

    public LoginPage loaded() {
        this.btnLogin = this.wait.waitForVisible(loginButtonLocator());
        if (this.btnLogin != null)
            this.log.info("Groceries login page loaded.");

        return this;
    }

    public void unloaded() throws AppiumException {
        this.wait.waitForNotVisible(loginButtonLocator(), this.settings.shortTimeout, true);
        this.log.info("Groceries login page not visible.");
    }

    public SecondaryLoginPage login() {
        if (this.settings.platformVersion == 4.2) {
            this.btnLogin.tap();
        } else {
            this.btnLogin.click();
        }
        SecondaryLoginPage page = new SecondaryLoginPage();

        return page;
    }
}