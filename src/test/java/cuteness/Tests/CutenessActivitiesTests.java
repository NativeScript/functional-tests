package cuteness.Tests;

import cuteness.Screens.DetailsPage;
import cuteness.Screens.HomePage;
import functional.tests.core.basetest.UIBaseTest;
import functional.tests.core.device.android.Adb;
import functional.tests.core.element.UIElement;
import functional.tests.core.find.Wait;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CutenessActivitiesTests extends UIBaseTest {

    private static String option; // The single quote below is different.
    private static String optionApi19 = "Don't keep activities";
    private static String optionApi23 = "Don’t keep activities";
    private String activity = "com.tns.NativeScriptActivity";
    protected HomePage homePage;

    private void enableOption(String optionName) {
        this.log.info("Swiping to \"" + optionName + "\" option.");
        UIElement optionBtn = this.find.byText(optionName, 3);

        int count = 0;
        while (optionBtn == null) {
            if (count <= 5) {
                optionBtn = this.gestures.scrollToElement(SwipeElementDirection.DOWN, optionName, 5);
            } else {
                Assert.fail("Failed to navigate to \"" + optionName + "\".");
            }
            count++;
        }
        optionBtn.click();
        this.log.info("Tap on '" + optionName + "' option.");
    }

    @Test(groups = {"android"})
    public void cuteness_00_setup() {
        this.homePage = new HomePage();
        this.homePage.loaded();
        this.activity = ((AndroidDriver) this.client.driver).currentActivity();
    }

    // TODO: Uncoment Adb.startDeveloperOptions
    @Test(groups = {"android"})
    public void cuteness_01_enable_do_not_keep_activities() {
        Adb.startDeveloperOptions(this.settings.deviceId, this.settings.deviceBootTimeout);
        if (this.settings.platformVersion < 6) {
            option = optionApi19;
        } else {
            option = optionApi23;
        }
        this.enableOption(option);
        this.log.info(option + " enabled.");
    }

    @Test(groups = {"android"})
    public void cuteness_10_item_run_in_background() throws Exception {
        Adb adb = new Adb(this.settings);
        adb.startApplication(this.settings.packageId, activity);
        Wait.sleep(this.settings.shortTimeout);
        this.homePage.loaded();

        // Open details page
        DetailsPage detailsPage = this.homePage.tapListViewItem(2);
        detailsPage.loaded();
        this.compareScreens("details_before_minimize_before_swipe", this.settings.shortTimeout, 1.0);

        // Swipe down
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 500);
        this.compareScreens("details_before_minimize_after_swipe", this.settings.shortTimeout, 1.0);

        // Run in background
        this.app.runInBackground(10);

        // Restore app
        detailsPage.loaded();
        this.assertScreen("details_after_minimize_after_swipe", this.settings.shortTimeout, 1.0);
    }

    @Test(groups = {"android"})
    public void cuteness_20_home_run_in_background() throws Exception {
        Adb adb = new Adb(this.settings);
        adb.startApplication(this.settings.packageId, activity);
        Wait.sleep(this.settings.shortTimeout);
        this.homePage.loaded();

        // Swipe down
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 500);

        // Run in background
        this.app.runInBackground(10);

        // Restore app
        this.homePage.loaded();
        Wait.sleep(this.settings.shortTimeout);
        boolean areEqual = this.compareScreens("details_before_minimize_after_swipe", this.settings.shortTimeout, 1.0);
        Assert.assertFalse(areEqual, "Page state restarted. List view is in initial state, while it should keep the old state.");
    }
}
