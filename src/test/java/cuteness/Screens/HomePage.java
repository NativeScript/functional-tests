package cuteness.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.settings.Settings;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage() {
        super();
        this.loaded();
    }

    private UIElement listView() {
        return this.find.byLocator(this.locators.listViewLocator());
    }

    private List<UIElement> listViewItems() {
        Assert.assertNotNull(this.listView());
        return this.wait.forVisibleElements(this.locators.listViewItemsLocator(), 5, true);
    }

    private UIElement listTabItem() {
        return this.find.byText("List");
    }

    public void loaded() {
        Assert.assertNotNull(this.listView(), "Cuteness home page NOT loaded.");
        this.log.info("Cuteness home page loaded.");
    }

    private UIElement aboutTabItem() {
        return this.find.byText("About");
    }

    public HomePage gotoHomeTab() {
        this.listTabItem().tap();
        return this;
    }

    public AboutPage gotoAboutTab() {
        this.aboutTabItem().tap();
        return new AboutPage();
    }

    public DetailsPage tapListViewItem(int index) {
        this.listViewItems().get(index).click();
        this.log.info("Tap on ListViewItem with index: " + String.valueOf(index));
        return new DetailsPage();
    }

    public DetailsPage tapListView() {
        this.listView().tap();
        this.log.info("Tap at center of ListView.");
        return new DetailsPage();
    }
}