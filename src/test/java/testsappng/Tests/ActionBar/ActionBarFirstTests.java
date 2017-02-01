package testsappng.Tests.ActionBar;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.ActionBarFirstPage;
import testsappng.Screens.SecondComponentPage;
import testsappng.TestsAppNgBase;

public class ActionBarFirstTests extends TestsAppNgBase {
    protected ActionBarFirstPage actionBarFirstPage;
    protected SecondComponentPage secondComponentPage;

    @BeforeClass(alwaysRun = true)
    public void beforeActionBarFirstTestClass() throws Exception {
        this.actionBarFirstPage = new ActionBarFirstPage(this.context);
    }

    @Test(groups = {"android", "ios"})
    public void firstActionBar_01_tapItemShare() throws Exception {
        this.actionBarFirstPage.tapShareItem();
        Assert.assertEquals(this.actionBarFirstPage.labelShare().getText(), "1 share tap");
    }

    @Test(groups = {"android", "ios"})
    public void firstActionBar_02_tapPopUpDelete() throws Exception {
        this.actionBarFirstPage.tapDeleteItem();
        Assert.assertEquals(this.actionBarFirstPage.labelDelete().getText(), "1 delete tap");
    }

    @Test(groups = {"android", "ios"})
    public void firstActionBar_03_tapItemAction() throws Exception {
        this.secondComponentPage = this.actionBarFirstPage.navigateToSecondCoponentPage();
        this.secondComponentPage.loadedSecondComponentPage();
        this.actionBarFirstPage = this.secondComponentPage.navigateBackToActionBarFirstPage();
    }

    @Test(groups = {"android", "ios"})
    public void firstActionBar_04_tapActionBarItems() throws Exception {
        this.actionBarFirstPage.tapShareItem();
        this.actionBarFirstPage.tapShareItem();
        Assert.assertEquals(this.actionBarFirstPage.labelShare().getText(), "3 share taps");

        this.actionBarFirstPage.tapDeleteItem();
        this.actionBarFirstPage.tapDeleteItem();
        Assert.assertEquals(this.actionBarFirstPage.labelDelete().getText(), "3 delete taps");
        this.log.logScreen(this.context.getTestName(), this.context.getTestName(), 320, 240);
    }
}
