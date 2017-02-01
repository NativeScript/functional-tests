package pods.Tests;

import functional.tests.core.basetest.UIBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pods.Screens.IndicatorPage;

public class IndicatorTests extends UIBaseTest {

    @Test(groups = {"android", "ios"})
    public void homePage() throws Exception {
        IndicatorPage indicatorPage = new IndicatorPage(this.context);
        indicatorPage.loaded();
        String actualTapsLeft = indicatorPage.tapsLeftText().getText();
        Assert.assertTrue(actualTapsLeft.startsWith("300"), "Default number of taps left does not start with '300'");

        indicatorPage.button().tap();
        actualTapsLeft = indicatorPage.tapsLeftText().getText();
        Assert.assertEquals(actualTapsLeft, "41 taps left", "Tap does not change number of taps left");
        this.log.info("Tap TAP button reduces the tap left count.");

        indicatorPage.button().tap();
        actualTapsLeft = indicatorPage.tapsLeftText().getText();
        Assert.assertEquals(actualTapsLeft, "40 taps left", "Tap does not change number of taps left");
        this.log.info("Tap TAP button reduces the tap left count.");
    }
}