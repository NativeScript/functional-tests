package uitests.Tests.SearchBar;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

public class SearchBarTest extends UIBaseTests {

    public HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeSearchBarTestClass() {
        this.homePageExtended = new HomePageExtended("search-bar", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void issue_4147() throws Exception {
        this.homePageExtended.navigateTo("issue-4147");
        this.wait.forVisibleElements(this.locators.searchBoxLocator(), 2, true);
        this.compareScreens(5);

        this.setText(0, "test");
        this.setText(1, "test");
        this.setText(2, "test");
        this.setText(3, "test");
        this.compareScreens(5);

        this.clearSearchBar(0);
        this.clearSearchBar(1);
        this.clearSearchBar(2);
        this.clearSearchBar(3);
        this.compareScreens(5);
        this.app.hideKeyboard();
        if (this.settings.platform == PlatformType.iOS) {
            this.homePageExtended.navigateBack(this.find.byText("Go Back"));
        } else {
            this.homePageExtended.navigateBack(this.find.byLocator(this.locators.imageButtonLocator()));
        }
        this.assertImagesResults();
    }

    private void setText(int index, String text) {
        UIElement searchBar = this.getSearchBar(index);
        searchBar.tap();
        searchBar.sendKeys(text);
    }

    private void clearSearchBar(int index) {
        UIElement clearBtn = this.find.elementsByLocator(this.locators.imageLocator()).get(index);
        clearBtn.tap();
    }

    private UIElement getSearchBar(int index) {
        return this.find.elementsByLocator(this.locators.searchBoxLocator()).get(index);
    }
}
