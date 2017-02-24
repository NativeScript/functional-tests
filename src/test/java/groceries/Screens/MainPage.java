package groceries.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
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

        UIElement addBtn = this.find.elementsByLocator(this.locators.imageLocator()).get(1);
        if (this.settings.platform == PlatformType.Android) {
            addBtn.click();
        } else {
            addBtn.tap();
        }
        Wait.sleep(2000);

        return this.getListViewItem(0);
    }

    public UIElement textFieldAddAGroceryItem() {
        return this.find.byLocator(this.textFiledAddAGroceryItemLocator());
    }

    public UIElement getListViewItem(int index) {
        return this.getListViewItems().get(index);
    }

    public GroceriesItem getGroceriesItem(int index) {
        return new GroceriesItem(this.getListViewItems().get(index).getUIRectangle(), this.context);
    }

    public java.util.List<UIElement> getListViewItems() {
        try {
            return this.find.elementsByLocator((this.locators.listViewItemsLocator()));
        } catch (Exception ex) {
            return null;
        }
    }

    public void clearList() {
        int length = this.getListViewItems() != null ? this.getListViewItems().size() : 0;
        for (int i = length - 1; i > 0; i--) {
            new GroceriesItem(this.getListViewItems().get(0).getUIRectangle(), this.context).tapOnDeleteIcon();
        }
    }

    public boolean loaded() {
        return this.wait.waitForVisible(this.textFiledAddAGroceryItemLocator(), 6, false) != null;
    }

    public GroceriesRecentItemsPage tapOnResent() {
        this.find.byTextContains("Recent").tap();
        this.wait.waitForVisible(this.doneLocator(), 1000, true);

        return new GroceriesRecentItemsPage();
    }

    public void tapOnMenu() {
        if (this.settings.platform == PlatformType.Android) {
            this.find.elementsByLocator(menuLocator()).get(0).click();
        } else {
            this.find.byLocator(menuLocator()).click();
        }
    }

    public void tapOnLogOff() {
        UIElement button;
        this.wait.waitForVisible(btnLogOffLocator());

        if (this.settings.platform == PlatformType.Android) {
            button = this.find.elementsByLocator(this.btnLogOffLocator()).get(2);
        } else {
            button = this.find.byLocator(this.btnLogOffLocator());
        }
        button.tap();
    }

    public By menuLocator() {
        if (this.settings.platform == PlatformType.iOS) {
            return By.id("menu");
        } else if (this.settings.platform == PlatformType.Android) {
            return this.locators.imageLocator();
        }

        return null;
    }

    public UIElement logScreen() {
        return this.find.elementsByLocator(this.locators.frameLayoutLocator()).get(1);
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

    public By doneLocator() {
        return this.locators.byText("Done", false, false);
    }
}
