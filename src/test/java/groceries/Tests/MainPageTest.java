package groceries.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.extensions.ExecutionOrder;
import functional.tests.core.mobile.basetest.MobileTest;
import groceries.Screens.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@SuppressWarnings("groupsTestNG")
@Listeners(ExecutionOrder.class)
public class MainPageTest extends MobileTest {
    private static final String PASSWORD = "password";
    private MainPage mainPage;

    private String getUserName() {
        String userName = "tnstest" + this.settings.platformVersion.toString() + "@tns.com";
        if ((this.settings.platform == PlatformType.iOS) && (this.settings.deviceName.toLowerCase().contains("x"))) {
            userName = userName.replace("@", "x@");
        }
        return userName;
    }

    @BeforeClass(alwaysRun = true)
    public void beforeMainPageTestClass() {
        this.mainPage = new MainPage(this.context);
        this.loadGroceriesItemsPage();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMainPageMethod() {
        if (this.context.lastTestResult > ITestResult.SUCCESS) {
            this.loadGroceriesItemsPage();
        }
    }

    private void loadGroceriesItemsPage() {
        SecondaryLoginPage secondaryLoginPage = new SecondaryLoginPage();
        if (this.settings.platform == PlatformType.iOS) {
            if (!this.mainPage.loaded()) {
                new LoginPage().loaded().login();
            }
        } else {
            new LoginPage().loaded().login();
        }

        if (secondaryLoginPage.loaded()) {
            secondaryLoginPage.login(getUserName(), PASSWORD);
        }
    }

    @Test(groups = {"android", "ios"})
    public void groceries_01_addItem() {
        this.mainPage.clearList(0);
        this.mainPage.insertItem("t123");
        Assert.assertTrue(1 == this.mainPage.getListViewItems().size(), "The item is not successfully added!!! ");
    }

    @Test(groups = {"android", "ios"}, dependsOnMethods = {"groceries_01_addItem"})
    public void groceries_02_removeItem() {
        this.mainPage.clearList(1);
        GroceriesItem groceriesItem = this.mainPage.getGroceriesItem(0);
        groceriesItem.tapOnCheckBox();
        groceriesItem.tapOnDeleteIcon();
        Assert.assertTrue(0 == this.mainPage.getListViewItems().size(), "The item is not successfully removed!!! ");
    }

    @Test(groups = {"android", "ios"}, enabled = false, dependsOnMethods = {"groceries_02_removeItem"})
    public void groceries_03_restoreRemovedItem() {
        GroceriesRecentItemsPage recent = this.mainPage.tapOnResent();

        try {
            this.mainPage.clearList(0);
            this.compareScreens("recent_items", 5, 0.1);
        } catch (Exception e) {
            this.log.info("Failed to remove deleted items");
        }

        recent.selectItem(0);
        this.mainPage = recent.tapOnDone();

        GroceriesItem groceriesItem = this.mainPage.getGroceriesItem(0);
        groceriesItem.tapOnCheckBox();
        groceriesItem.tapOnDeleteIcon();

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"}, dependsOnMethods = {"groceries_02_removeItem"})
    public void groceries_04_logOut() throws Exception {
        this.mainPage.tapOnMenu();
        if (this.settings.platform == PlatformType.Android) {
            this.compareElements("logOffDialog", this.mainPage.logScreen(), 5, 0.5);
        } else {
            this.compareScreens(20, 0.5);
        }

        this.mainPage.tapOnLogOff();
        this.compareScreens(30, 5.0);

        this.assertImagesResults();
    }
}
