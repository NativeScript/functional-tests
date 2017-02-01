package sdkexamples;

import functional.tests.core.basetest.UIBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sdkexamples.Screens.SdkHomePage;

public class SdkExamplesSmokeTests extends UIBaseTest {

    protected SdkHomePage homePage;

    @BeforeClass
    public void beforeSdkExampleTestsClass() {
        this.homePage = new SdkHomePage(this.context);
    }

    @Test(groups = {"android"})
    public void sdkExamples_10_mainMenuLinksCount() {
        this.homePage.getSortedMainMenuLinks();
        int size = homePage.getMainMenuLinksSize();
        Assert.assertEquals(size, 36);
    }
}
