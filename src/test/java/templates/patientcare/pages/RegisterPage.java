package templates.patientcare.pages;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Wait;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterPage extends BasePage {

    public RegisterPage() {
        super();
        UIElement home = this.wait.waitForVisible(this.locators.findByTextLocator("Registration", true));
        Assert.assertNotNull(home, "Register page not loaded!");
        this.log.info("Register page loaded.");
    }

    public CareContentPage register(String email, String pass, String firstName, String lastName) {
        this.email().setText(email);
        if (this.settings.platform == PlatformType.Android) {
            this.sendEnterAndTypeText(pass);
            this.sendEnterAndTypeText(pass);
            this.sendEnterAndTypeText(firstName);
            this.sendEnterAndTypeText(lastName);
            this.app.hideKeyboard();
            Wait.sleep(10);
            this.setDate();
        } else {
            this.find.byText("Enter password").setText(pass);
            this.find.byText("Enter password again").setText(pass);
            this.find.byText("John").setText(firstName);
            this.client.driver.hideKeyboard();
            this.find.byText("Doe").setText(lastName);
            this.find.byText("Done").click();
        }

        // Click register and return new content page
        this.registerButton().click();
        return new CareContentPage();
    }

    private UIElement registerButton() {
        return find.byText("Register");
    }

    private UIElement email() {
        return find.byText("example@progress.com");
    }

    private void setDate() {
        this.find.byText("Pick a date").click();
        this.find.byText("OK").click();
    }

    private void sendEnterAndTypeText(String text) {
        if (this.settings.platform == PlatformType.Android) {
            Wait.sleep(20);
            ((AndroidDriver) this.client.driver).pressKeyCode(66);
            Wait.sleep(20);
            this.client.driver.getKeyboard().sendKeys(text);
            Wait.sleep(20);
        } else {
            this.client.driver.findElement(By.id("Next keyboard")).click();
        }
    }
}
