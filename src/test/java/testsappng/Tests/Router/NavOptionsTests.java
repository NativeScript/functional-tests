package testsappng.Tests.Router;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.NavOptionsPage;
import testsappng.TestsAppNgBase;

public class NavOptionsTests extends TestsAppNgBase {
    protected NavOptionsPage navOptionsPage;

    @BeforeClass(alwaysRun = true)
    public void beforeClassNavOptionsTests() throws Exception {
        this.navOptionsPage = new NavOptionsPage(this.context);
    }

    @AfterClass(alwaysRun = true)
    public void afterClassNavOptionsTests() throws Exception {
        this.navOptionsPage.waitForPageTransitionToLoadToLoad();
        if (this.settings.platform == PlatformType.iOS) {
            this.navOptionsPage.backToMain();
        } else {
            this.navOptionsPage.navigateBack();
        }
    }

    @Test(groups = {"android", "ios"})
    public void navOption_01_clearHistory_navigateBack() throws Exception {
        this.clearHistoryAndUpdate("0", "1");

        if (this.settings.platform == PlatformType.Android) {
            // Navigate back should go to home screen
            this.navOptionsPage.navigateBack();
            this.wait.waitForVisible(this.locators.byText("Phone"), true);

            this.app.restart();
            this.navOptionsPage.homePageLoaded();

            this.compareScreens(10, 5);

        } else if (this.settings.platform == PlatformType.iOS) {
            this.compareScreens(5);
            this.navOptionsPage.navigateWithBackToMain();
        }

        this.assertImagesResults();
    }

    @Test(groups = {"android"})
    public void navOption_02_clearHistory_backToMain() throws Exception {
        this.navOptionsPage.resetNavigationMainPage();

        this.clearHistoryAndUpdate("0", "1");

        this.navOptionsPage.backToMain();

        this.navOptionsPage.homePageLoaded();
    }

    @Test(groups = {"android", "ios"})
    public void navOption_03_pageTransition() throws Exception {
        double tollerance = 6;
        if (this.settings.platform == PlatformType.Android) {
            this.navOptionsPage.resetNavigationToLastPage();
        } else {
            UIElement btnNavOptions = this.wait.waitForVisible(this.locators.byText(NavOptionsPage.navOptionsPage), 3, true);
            this.navOptionsPage.navigateTo(btnNavOptions);
            tollerance = 19;
        }

        this.navOptionsPage.pageTransitions();

        this.compareScreens(13, tollerance);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void navOption_04_pageTransitionUpdateHistory() throws Exception {
        this.navOptionsPage.waitForFrameStackLabelToLoad();
        this.updateHistory("2", "3");
    }

    @Test(groups = {"android"})
    public void navOption_05_pageTransitionBack() throws Exception {
        this.navOptionsPage.navigateBack();
        this.compareScreens(10, 2000, 6);
        this.navOptionsPage.navOptionsPageLoaded();
        this.assertImagesResults();
    }

    public void clearHistoryAndUpdate(String frameStack, String locationStack) {
        this.navOptionsPage.clearHistory();
        this.assertFrameStack("-1");
        this.assertLocationStack("-1");

        this.updateHistory(frameStack, locationStack);
    }

    public void updateHistory(String frameStack, String locationStack) {
        this.navOptionsPage.update();

        this.assertFrameStack(frameStack);
        this.assertLocationStack(locationStack);
    }


    private void assertFrameStack(String frameStack) {
        String result = this.navOptionsPage.getFrameStack();

        Assert.assertEquals(result, "frameStack: " + frameStack);
    }

    private void assertLocationStack(String locationStack) {
        String result = this.navOptionsPage.getLocationStack();

        Assert.assertEquals(result, "locationStack: " + locationStack);
    }
}
