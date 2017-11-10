package uitests.Tests.SearchBar;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import io.appium.java_client.android.AndroidDriver;
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
        final int waitTime = 15;
        this.homePageExtended.navigateTo("issue-4147");
        this.wait.forVisibleElements(this.locators.searchBoxLocator(), 2, true);
        this.compareScreens(waitTime);
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 10) {
            this.log.warn("This test is disabled for iOS under 10");
            this.assertImagesResults();
            return;
        }
        this.setText(0, "test");
        this.setText(1, "test");
        this.setText(2, "test");
        this.setText(3, "test");
        this.compareScreens(waitTime);

        this.clearSearchBar(0);
        this.clearSearchBar(1);
        this.clearSearchBar(2);
        this.clearSearchBar(3);

        this.app.hideKeyboard();

        this.compareScreens(waitTime);

        if (this.settings.platform == PlatformType.iOS) {
            this.homePageExtended.navigateBack(this.find.byText("Go Back"));
        } else {
            this.homePageExtended.navigateBack(this.find.byLocator(this.locators.imageButtonLocator()));
        }
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void search_bar() throws Exception {
        if (this.settings.platformVersion < 10 && this.settings.platform == PlatformType.iOS) {
            return;
        }
        this.homePageExtended.navigateTo(this.find.byText("search-bar"));
        this.app.hideKeyboard();

        this.assertScreen(10);
    }

    @Test(groups = {"android"})
    public void issue_5039() throws Exception {
        this.homePageExtended.navigateTo("issue-5039");

        this.setText(0, "apple");
        ((AndroidDriver) this.client.driver).pressKeyCode(66);
        this.compareScreens(5);

        this.clearSearchBar(0);
        this.setText(0, "apple");
        ((AndroidDriver) this.client.driver).pressKeyCode(66);
        this.compareScreens(5);

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
