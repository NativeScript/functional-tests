package sdkexamples;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sdkexamples.Screens.SdkPage;

public class SdkExamplesSmokeTests extends MobileTest {

    protected SdkPage homePage;

    @BeforeClass
    public void beforeSdkExampleTestsClass() {
        this.homePage = new SdkPage(this.context);
    }

    @Test(groups = {"android"})
    public void sdkExamples_10_mainMenuLinksCount() {
        this.homePage.getSortedMainMenuLinks();
        int size = homePage.getMainMenuLinksSize();
        Assert.assertEquals(size, 36);
    }
}
