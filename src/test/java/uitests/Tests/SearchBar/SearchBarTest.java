package uitests.Tests.SearchBar;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Wait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

@SuppressWarnings("groupsTestNG")
public class SearchBarTest extends UIBaseTests {

    public HomePageExtended homePageExtended;
    private int maxPixelTolerance = 2147483647;

    @BeforeClass(alwaysRun = true)
    public void beforeSearchBarTestClass() {
        this.homePageExtended = new HomePageExtended("search-bar", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void issue_4147() throws Exception {
        final int waitTime = 15;
        this.homePageExtended.navigateTo("issue-4147");
        this.wait.forVisibleElements(this.locators.searchBoxLocator(), 2, true);
        if ((this.settings.platform == PlatformType.Android && this.settings.platformVersion == 27.0) || (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 8.0)) {
            if (this.imageVerification.compareScreens("issue_4147_without_suggestions", 5, 0, this.maxPixelTolerance, 0.05)) {
                this.assertScreen("issue_4147_without_suggestions", waitTime, 0.05);
            } else if (this.imageVerification.compareScreens("issue_4147_with_suggestions_info", 5, 0, this.maxPixelTolerance, 0.05)) {
                this.assertScreen("issue_4147_with_suggestions_info", waitTime, 0.05);
            } else {
                this.assertScreen("issue_4147_with_suggestions", waitTime, 0.05);
            }
        } else {
            this.compareScreens(waitTime);
        }

        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 10) {
            this.log.warn("This test is disabled for iOS under 10");
            this.assertImagesResults();
            return;
        }
        this.setText(0, "test");
        this.setText(1, "test");
        this.setText(2, "test");
        this.setText(3, "test");
        if ((this.settings.platform == PlatformType.Android && this.settings.platformVersion == 27.0)) {

            if (this.imageVerification.compareScreens("issue_4147_2_with_suggestions", waitTime, 0, this.maxPixelTolerance, 0.05)) {
                this.assertScreen("issue_4147_2_with_suggestions", waitTime, 0.05);
            } else {
                this.assertScreen("issue_4147_2_without_suggestions", waitTime, 0.05);
            }
        } else if ((this.settings.platform == PlatformType.Android && this.settings.platformVersion == 8.0)) {
            this.assertScreen("issue_4147_2", waitTime, 0.05);
        } else {
            this.compareScreens(waitTime, 0.05);
        }

        this.clearSearchBar(0);
        this.clearSearchBar(1);
        this.clearSearchBar(2);
        this.clearSearchBar(3);

        this.app.hideKeyboard();

        if ((this.settings.platform == PlatformType.Android && this.settings.platformVersion == 27.0) || (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 8.0)) {
            this.assertScreen("issue_4147_3", waitTime, 0.05);
        } else {
            this.compareScreens(waitTime);
        }

        if (this.settings.platform == PlatformType.iOS) {
            this.homePageExtended.navigateBack(this.find.byText("Go Back"));
        } else {
            this.homePageExtended.navigateBack(this.find.byLocator(this.locators.imageButtonLocator()));
        }
        if ((this.settings.platform == PlatformType.Android && this.settings.platformVersion == 27.0) || (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 8.0)) {
            this.log.info("Skip image verification.");
        } else {
            this.assertImagesResults();
        }
    }

    @Test(groups = {"android"})
    public void issue_5039() throws Exception {
        this.homePageExtended.navigateTo("issue-5039");

        this.setText(0, "apple");
        ((AndroidDriver) this.client.driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        if ((this.settings.platform == PlatformType.Android && this.settings.platformVersion == 27.0) || (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 8.0)) {

            if (this.imageVerification.compareScreens("issue_5039_with_suggestions", 10, 0, this.maxPixelTolerance, 0.05)) {
                this.assertScreen("issue_5039_with_suggestions", 10, 0.05);
            } else {
                this.assertScreen("issue_5039_without_suggestions", 10, 0.05);
            }
        } else {
            this.compareScreens(10);
        }


        this.clearSearchBar(0);
        this.setText(0, "apple");
        Wait.sleep(1000);
        ((AndroidDriver) this.client.driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        Wait.sleep(1000);

        if ((this.settings.platform == PlatformType.Android && this.settings.platformVersion == 27.0) || (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 8.0)) {
            if (this.imageVerification.compareScreens("issue_5039_2_with_suggestions", 10, 0, this.maxPixelTolerance, 0.05)) {
                this.assertScreen("issue_5039_2_with_suggestions", 10, 0.05);
            } else {
                this.assertScreen("issue_5039_2_without_suggestions", 10, 0.05);
            }
        } else {
            this.compareScreens(10);
        }
        Wait.sleep(1000);
        this.app.hideKeyboard();
        Wait.sleep(1000);
        if ((this.settings.platform == PlatformType.Android && this.settings.platformVersion == 27.0) || (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 8.0)) {
            this.log.info("Skip image verification.");
        } else {
            this.assertImagesResults();
        }
    }

    @Test(groups = {"android", "ios"})
    public void search_bar() throws Exception {
        if (this.settings.platformVersion < 10 && this.settings.platform == PlatformType.iOS) {
            return;
        }
        if (settings.platformVersion >= 8.0) {
            Wait.sleep(1000);
            this.client.driver.navigate().back();
        }
        Wait.sleep(1000);
        this.homePageExtended.navigateToMainPage();
        Wait.sleep(1000);
        this.find.byText("search-bar", false, settings.shortTimeout).click();
        Wait.sleep(3000);
        this.app.hideKeyboard();

        this.assertScreen(10);
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
