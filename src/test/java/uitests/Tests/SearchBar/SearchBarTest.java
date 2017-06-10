package uitests.Tests.SearchBar;

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
        this.compareScreens();

        this.setText(0, "test");
        this.setText(1, "test");
        this.setText(2, "test");
        this.setText(3, "test");
        this.compareScreens();

        this.clearSearchBar(0);
        this.clearSearchBar(1);
        this.clearSearchBar(2);
        this.clearSearchBar(3);
        this.compareScreens();
        this.homePageExtended.navigateBack(this.find.byText("Go Back"));

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
