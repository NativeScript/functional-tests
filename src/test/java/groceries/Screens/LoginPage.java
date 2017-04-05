package groceries.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public final By btnLogin = this.locators.byText("Login", false, false);

    public LoginPage() {
        super();
    }

    public LoginPage loaded() {
        UIElement login = this.wait.waitForVisible(this.btnLogin);
        if (login != null)
            this.log.info("Groceries login page loaded.");

        return this;
    }

    public SecondaryLoginPage login() {
        UIElement login = this.wait.waitForVisible(this.btnLogin);
        login.tap();
        SecondaryLoginPage page = new SecondaryLoginPage();

        return page;
    }
}