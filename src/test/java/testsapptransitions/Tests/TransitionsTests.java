package testsapptransitions.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.find.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testsapptransitions.Screens.TransitionsPage;
import testsapptransitions.TransitionsBaseTest;

public class TransitionsTests extends TransitionsBaseTest {
    private static final int percentTolerance = 10;

    @BeforeMethod(alwaysRun = true)
    public void beforeMehtodTransitionsTests() throws Exception {
        this.compareScreens("mainScreen", 100, 0.2);
        Wait.sleep(2000);
    }

    @Test(groups = {"android", "ios"})
    public void flipTransGoBackTest_01() throws Exception {
        this.compareTransitions(TransitionsPage.flipTransGoBack(), 250, 3000);
        if (this.settings.platform != PlatformType.iOS) {
            this.assertImagesResults();
        }
    }

    @Test(groups = {"android", "ios"})
    public void flipTransFlipTransCHTest_02() throws Exception {
        this.compareTransitions(TransitionsPage.flipTransFlipTransCH(), 150, 3000, 3000);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void noTransFlipTransCH_03() throws Exception {
        this.compareTransitions(TransitionsPage.noTransFlipTransCH(), 250, 3000);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void slideTransGoBack_04() throws Exception {
        this.compareTransitions(TransitionsPage.slideTransGoBack(), 450, 3000);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void noTransSlideTransCH_04() throws Exception {
        this.compareTransitions(TransitionsPage.noTransSlideTransCH(), 1050, 3000);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void slideTransSlideTransCH_05() throws Exception {
        this.compareTransitions(TransitionsPage.noTransSlideTransCH(), 850, 3000);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void fadeTransGoBack_07() throws Exception {
        if (this.settings.platform == PlatformType.iOS) {
            Wait.sleep(2000);
        }

        this.compareTransitions(TransitionsPage.fadeTransGoBack(), 1250, 3000);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void noTransFadeTransCH_08() throws Exception {
        this.compareTransitions(TransitionsPage.noTransFadeCH(), 650, 3000);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void fadeTransFadeTransCH_09() throws Exception {
        this.compareTransitions(TransitionsPage.fadeTransFadeTransCH(), 1550, 3000);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void customTransGoBack_10() throws Exception {
        if (this.settings.platform == PlatformType.iOS) {
            Wait.sleep(5000);
        }
        this.compareTransitions(TransitionsPage.customTransGoBack(), 2050, 3000);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void noTransCustomTransCH_11() throws Exception {
        this.compareTransitions(TransitionsPage.noTransCustomTransCH(), 1250, 3000, 8, 3000);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void customTransCustomTransCH_12() throws Exception {
        this.compareTransitions(TransitionsPage.customTransCustomTransCH(), 1250, 3000);
        this.assertImagesResults();
    }

    @Test(groups = {"ios"})
    public void noTransCurlTransCH_14() throws Exception {
        this.compareTransitions(TransitionsPage.noTransSlideCurlTransCH(), 250, 3000);
        this.assertImagesResults();
    }

    @Test(groups = {"ios"})
    public void curlTransCurlTransCH_15() throws Exception {
        int wait = 250;
        int secondWait = 3000;
        if (this.context.settings.platform == PlatformType.iOS && this.context.settings.platformVersion >= 10) {
            wait = 100;
            secondWait = 200;
        }
        this.compareTransitions(TransitionsPage.curlTransCurlTransCH(), wait, secondWait);
        this.assertImagesResults();
    }


    @Test(groups = {"ios"})
    public void slideCurlTransGoBack_16() throws Exception {
        this.compareTransitions(TransitionsPage.slideCurlTransGoBack(), 250, 3000);
        this.assertImagesResults();
    }
}
