package groceries.Screens;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Wait;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private UIElement addItemTextEdit;

    public MainPage(MobileContext context) {
        super(context);
    }

    public UIElement insertItem(String text) {
        if (this.addItemTextEdit == null) {
            this.addItemTextEdit = this.textFieldAddAGroceryItem();
        }

        this.addItemTextEdit.tap();
        this.addItemTextEdit.sendKeys(text);

        UIElement addBtn = this.wait
                .forVisibleElements(this.locators.imageLocator(), 10, false)
                .get(1);
        if (this.settings.platform == PlatformType.Android) {
            addBtn.click();
        } else {
            addBtn.tap();
        }
        Wait.sleep(2000);

        return this.getListViewItem(0);
    }

    private UIElement textFieldAddAGroceryItem() {
        return this.wait.waitForVisible(this.textFiledAddAGroceryItemLocator());
    }

    private UIElement getListViewItem(int index) {
        return this.getListViewItems().get(index);
    }

    public GroceriesItem getGroceriesItem(int index) {
        return new GroceriesItem(this.getListViewItems().get(index).getUIRectangle(), this.context);
    }

    public java.util.List<UIElement> getListViewItems() {
        try {
            return this.wait
                    .forVisibleElements(
                            this.locators.listViewItemsLocator(), this.settings.shortTimeout, false
                    );
        } catch (Exception ex) {
            return null;
        }
    }

    public void clearList(int remaining) {
        int listSize = this.getListViewItems().size();
        while (listSize > remaining) {
            GroceriesItem groceriesItem = this.getGroceriesItem(0);
            groceriesItem.tapOnCheckBox();
            groceriesItem.tapOnDeleteIcon();
            listSize = this.getListViewItems().size();
        }
    }

    public boolean loaded() {
        return this.wait.waitForVisible(this.textFiledAddAGroceryItemLocator(), 6, false) != null;
    }

    public GroceriesRecentItemsPage tapOnResent() {
        this.wait.waitForVisible(this.locators.byText("Recent", false, false)).tap();
        this.wait.waitForVisible(this.doneLocator(), 1000, true);

        return new GroceriesRecentItemsPage();
    }

    public void tapOnMenu() {
        if (this.settings.platform == PlatformType.Android) {
            this.find.elementsByLocator(menuLocator()).get(0).click();
        } else {
            this.wait.waitForVisible(menuLocator()).click();
        }
    }

    public void tapOnLogOff() {
        UIElement button;
        this.wait.waitForVisible(btnLogOffLocator());

        if (this.settings.platform == PlatformType.Android) {
            button = this.find.elementsByLocator(this.btnLogOffLocator()).get(2);
        } else {
            button = this.wait.waitForVisible(this.btnLogOffLocator());
        }
        button.tap();
    }

    private By menuLocator() {
        if (this.settings.platform == PlatformType.iOS) {
            if (this.settings.platformVersion < 13.0) {
                return By.id("menu");
            } else {
                return this.locators.imageLocator();
            }
        } else if (this.settings.platform == PlatformType.Android) {
            return this.locators.imageLocator();
        }
        return null;
    }

    public UIElement logScreen() {
        return this.wait
                .forVisibleElements(this.locators.frameLayoutLocator(), this.settings.defaultTimeout, true)
                .get(1);
    }

    private By btnLogOffLocator() {
        if (this.settings.platform == PlatformType.Android) {
            return this.locators.textViewLocator();
        } else if (this.settings.platform == PlatformType.iOS) {
            return this.locators.byText("Log Off", false, false);
        }

        return null;
    }

    private By textFiledAddAGroceryItemLocator() {
        return this.locators.byText("Add a grocery", false, false);//.editTextLocator();
    }

    private By doneLocator() {
        return this.locators.byText("Done", false, false);
    }
}
