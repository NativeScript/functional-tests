package templates.patientcare.pages;

import com.google.common.collect.ImmutableMap;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Wait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
            // Handle keyboard
            if (this.settings.platformVersion > 6.0) {
                Wait.sleep(500);
                ((AndroidDriver) this.client.driver).pressKey(new KeyEvent(AndroidKey.ENTER));
                Wait.sleep(500);
                ((AndroidDriver) this.client.driver).pressKey(new KeyEvent(AndroidKey.ENTER));
                Wait.sleep(500);
            }

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

            this.app.hideKeyboard();
            Wait.sleep(500);

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
            ((AndroidDriver) this.client.driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            Wait.sleep(20);

            List<String> args = Arrays.asList(
                    "text",
                    "\"" + text + "\""
            );
            Map<String, Object> sendTextCmd = ImmutableMap.of(
                    "command", "input",
                    "args", args
            );
            this.client.driver.executeScript("mobile: shell", sendTextCmd);

            Wait.sleep(20);
        } else {
            this.client.driver.findElement(By.id("Next keyboard")).click();
        }
    }
}
