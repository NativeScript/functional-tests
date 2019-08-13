package cuteness.Tests;

import cuteness.Screens.AboutPage;
import cuteness.Screens.DetailsPage;
import cuteness.Screens.HomePage;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.enums.SwipeElementDirection;
import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.mobile.find.Wait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@SuppressWarnings("groupsTestNG")
public class CutenessSmokeTests extends MobileTest {

    protected HomePage homePage;

    @BeforeClass(groups = {"android", "ios"})
    public void beforeCutenessSmokeTest() {
        this.homePage = new HomePage();
        this.homePage.loaded();
    }

    @Test(groups = {"android", "ios"})
    public void cuteness_01_home() throws Exception {
        if (this.settings.platform == PlatformType.Android) {
            this.compareScreens("homepage", this.settings.defaultTimeout, 0.1);
        } else if (this.settings.platform == PlatformType.iOS) {
            if (this.settings.platformVersion == 9) {
                this.compareScreens("homepage", this.settings.defaultTimeout, 2.5);
            } else {
                this.compareScreens("homepage", this.settings.defaultTimeout, 0.5);
            }
        }
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void cuteness_02_details() throws Exception {
        if (this.settings.platform == PlatformType.Android) {
            this.homePage.tapListViewItem(2).loaded();
        } else {
            this.homePage.tapListView().loaded();
        }
        this.assertScreen("details", this.settings.shortTimeout, 1.0);
    }

    @Test(groups = {"android", "ios"})
    public void cuteness_03_about() throws Exception {
        AboutPage aboutPage = this.homePage.gotoAboutTab();
        aboutPage.loaded();
        this.assertScreen("about", this.settings.shortTimeout, 0.1);
    }

    @Test(groups = {"android", "ios"})
    public void cuteness_10_home_page_swipe() {
        this.homePage.loaded();
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 300);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 200);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 300);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 500);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 300);
        this.gestures.swipeInWindow(SwipeElementDirection.UP, 200);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 300);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 200);

        this.homePage.loaded();
        this.homePage.gotoAboutTab().loaded();
        this.homePage.gotoHomeTab().loaded();
        this.log.logScreen("home_after_swipe", "Home page after swipe");
    }

    @Test(groups = {"android", "ios"})
    public void cuteness_20_navigation_home_about() throws Exception {
        double homePageTolerance = 1.0;
        if (this.settings.platform == PlatformType.iOS) {
            homePageTolerance = 10.0;
        }
        for (int i = 0; i < 3; i++) {
            this.homePage.gotoAboutTab().loaded();
            this.homePage.gotoHomeTab().loaded();
        }
        this.assertScreen("homepage", this.settings.shortTimeout, homePageTolerance);
    }

    @Test(groups = {"android", "ios"})
    public void cuteness_21_navigation_home_details() {
        DetailsPage detailsPage = new DetailsPage();
        for (int i = 0; i < 3; i++) {
            if (this.settings.platform == PlatformType.Android) {
                this.homePage.tapListViewItem(i);
            } else {
                this.homePage.tapListView();
            }
            detailsPage.loaded();
            Wait.sleep(500);
            detailsPage.navigateBack();
            this.homePage.loaded();
            Wait.sleep(500);
        }
    }

    @Test(groups = {"android"})
    public void cuteness_30_restart() throws Exception {
        this.homePage.gotoAboutTab().loaded();
        this.compareScreens("about", 3, this.settings.shortTimeout);
        this.app.restart();
        this.homePage.loaded();
        this.assertImagesResults();
    }

    @Test(groups = {"android"})
    public void cuteness_31_runInBackground() throws Exception {
        AboutPage aboutPage = this.homePage.gotoAboutTab();
        aboutPage.loaded();
        this.compareScreens("about", 3, this.settings.shortTimeout);
        this.app.runInBackground(10);
        aboutPage.loaded();
        this.homePage.gotoHomeTab().loaded();
        DetailsPage detailsPage = this.homePage.tapListView();
        detailsPage.loaded();
        this.app.runInBackground(10);
        detailsPage.loaded();
        this.assertImagesResults();
    }
}