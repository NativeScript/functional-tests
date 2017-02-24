package testsapptransitions;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.find.Wait;
import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.BeforeClass;
import testsapptransitions.Screens.TransitionsPage;

public class TransitionsBaseTest extends MobileTest {
    protected TransitionsPage transitionsPage;
    private int retryCount = 15;
    private int defaultSleep = 1000;
    private double defaultAppTollerance = 18.05;

    @BeforeClass(alwaysRun = true)
    public void beforeClassTransitionsBaseTest() {
        this.transitionsPage = new TransitionsPage(this.context);
    }

    protected void compareTransitions(String transitionName, Integer... values) throws Exception {
        this.transitionsPage.executeTransition(transitionName);
        boolean isIos10 = this.settings.platform == PlatformType.iOS && this.settings.platformVersion >= 10;
        if (this.settings.platform == PlatformType.Android || isIos10) {
            for (int i = 0; i < values.length; i++) {
                int waitTimeBeforeSnapshot = isIos10 ? (values[i] == 0 ? 1500 : values[i]) * 10 : values[i];
                this.log.info("Time to wait before snapshot: " + waitTimeBeforeSnapshot);
                this.client.setWait(waitTimeBeforeSnapshot);

                boolean result = this.compareScreens(retryCount, defaultSleep, defaultAppTollerance);

                int retryCounts = 1;

                // retry first image
                while (!result && retryCounts > 0 && i == 0) {
                    retryCounts--;
                    try {
                        this.app.restart();
                    } catch (Exception e1) {
                        this.log.info("Failed to restart test app. Restart Apppium client/server.");
                    }

                    this.transitionsPage.executeTransition(transitionName);
                    this.clearImagesResults();

                    result = this.compareScreens(retryCount, defaultSleep, defaultAppTollerance);
                }
            }
        } else if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 10) {
            Wait.sleep(defaultSleep * 4);
            this.compareScreens(retryCount * 3, defaultSleep, defaultAppTollerance);
        }
    }
}

