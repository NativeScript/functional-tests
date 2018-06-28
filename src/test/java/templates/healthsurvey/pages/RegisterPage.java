package templates.healthsurvey.pages;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Wait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;

public class RegisterPage extends BasePage {

    public RegisterPage() {
        super();
        UIElement home = this.wait.waitForVisible(this.locators.findByTextLocator("Registration", true));
        Assert.assertNotNull(home, "Register page not loaded!");
        this.log.info("Register page loaded.");
    }

    public WelcomePage register(String email, String pass, String firstName, String lastName) {

        this.email().setText(email);
        if (this.settings.platform == PlatformType.Android) {
            this.sendEnterAndTypeText(pass);
            this.sendEnterAndTypeText(pass);

            this.app.hideKeyboard();
            Wait.sleep(500);

            // Hack
            new TouchAction(this.client.driver)
                    .press(PointOption.point(240, 500))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(240, 100))
                    .release()
                    .perform();

            this.sendEnterAndTypeText(firstName);
            this.sendEnterAndTypeText(lastName);
            this.setDate();
            Wait.sleep(500);
        } else {
            this.wait.waitForVisible(this.locators.byText("Enter password")).setText(pass);
            Wait.sleep(250);
            this.wait.waitForVisible(this.locators.byText("Enter password again")).setText(pass);
            Wait.sleep(250);
            this.wait.waitForVisible(this.locators.byText("John")).setText(firstName);

            // Hack
            this.client.driver.hideKeyboard();
            Wait.sleep(250);

            this.wait.waitForVisible(this.locators.byText("Doe")).setText(lastName);
            Wait.sleep(250);
            this.wait.waitForVisible(this.locators.byText("Done")).click();
            Wait.sleep(250);
        }

        // Click register and return new content page
        this.registerButton().click();
        return new WelcomePage();
    }

    private UIElement registerButton() {
        return this.wait.waitForVisible(this.locators.byText("Register"));
    }

    private UIElement email() {
        return this.wait.waitForVisible(this.locators.byText("example@progress.com"));
    }

    private void setDate() {
        this.wait.waitForVisible(this.locators.byText("Pick a date")).click();
        this.wait.waitForVisible(this.locators.byText("OK")).click();
    }

    private void sendEnterAndTypeText(String text) {
        if (this.settings.platform == PlatformType.Android) {
            Wait.sleep(250);
            ((AndroidDriver) this.client.driver).pressKeyCode(66);
            Wait.sleep(250);
            this.client.driver.getKeyboard().sendKeys(text);
            Wait.sleep(250);
        } else {
            this.wait.waitForVisible(By.id("Next keyboard")).click();
        }
    }
}
