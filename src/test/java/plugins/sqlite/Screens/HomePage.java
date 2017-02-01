package plugins.sqlite.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.settings.Settings;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    private By titleLocator() {
        if (this.settings.platform == PlatformType.Andorid) {
            return this.locators.findByTextLocator("NativeScript SQLite Example", true);
        } else {
            return By.id("NativeScript SQLite Example");
        }
    }

    private UIElement listViewItem(String itemName) {
        if (this.settings.platform == PlatformType.Andorid) {
            return this.find.byText(itemName);
        } else {
            return this.find.byLocator(By.id(itemName), this.settings.shortTimeout);
        }
    }

    private UIElement textBox() {
        if (this.settings.platform == PlatformType.Andorid) {
            return this.find.byType("android.widget.EditText");
        } else {
            By textBoxLocator = By.className("UIATextField");
            return this.find.byLocator(textBoxLocator, this.settings.shortTimeout);
        }
    }

    private UIElement addButton() {
        if (this.settings.platform == PlatformType.Andorid) {
            return this.find.byTextContains("Add");
        } else {
            By textBoxLocator = By.id("Add");
            return this.find.byLocator(textBoxLocator);
        }

    }

    /**
     * Verify the home page has loaded
     **/
    public void loaded() {
        this.wait.waitForVisible(titleLocator(), true);
        this.log.info("Sqlite example app loaded.");
    }

    /**
     * Add item to list
     **/
    public void addItem(String item) {
        this.log.info("Adding item: " + item);
        this.textBox().click();
        this.textBox().sendKeys(item);
        hideKeyboard();

        String textBoxText = this.textBox().getText();
        if (textBoxText != null) {
            this.log.info("TextBox text is: " + textBoxText);
        }
        this.addButton().tap(1, Settings.DEFAULT_TAP_DURATION);
        this.log.info("Tap add button.");
    }

    /**
     * Check if item is in the list
     **/
    public void verifyItemInList(String item) {
        UIElement result = this.listViewItem(item);
        Assert.assertNotNull(result, item + " not found in list.");
    }
}
