package groceries.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;

public class GroceriesRecentItemsPage extends BasePage {

    public GroceriesRecentItemsPage() {
        super();
    }

    public MainPage tapOnDone() {
        this.find.byLocator(doneLocator()).click();

        return new MainPage(this.context);
    }

    public UIElement selectItem(int index) {
        UIElement element = this.getListViewItems().get(index);
        element.click();
        return element;
    }

    public java.util.List<UIElement> getListViewItems() {
        return this.find.elementsByLocator((this.locators.listViewItemsLocator()));
    }

    public By doneLocator() {
        return this.locators.byText("Done", false, false);
    }
}
