package testsappng.Tests.ActionBar;

import functional.tests.core.enums.PlatformType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.ActionBarSecondPage;
import testsappng.TestsAppNgBase;

public class ActionBarSecondTests extends TestsAppNgBase {
    protected ActionBarSecondPage actionBarSecondPage;

    @BeforeClass(alwaysRun = true)
    public void beforeActionBarSecondTestsClass() throws Exception {
        this.actionBarSecondPage = new ActionBarSecondPage(this.context);
    }

    private String getTextFromLabelTap() {
        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion >= 7) {
            return this.actionBarSecondPage.labelTap().getText().toUpperCase();
        }

        return this.actionBarSecondPage.labelTap().getText();
    }

    private String getTextFromLabelCustom() {
        return this.actionBarSecondPage.labelCustom().getText();
    }

    @Test(groups = {"android", "ios"})
    public void secondActionBar_01_tapItemTap() throws Exception {
        this.actionBarSecondPage.tapTapBtn();
        this.assertScreen(3);
    }

    @Test(groups = {"android", "ios"})
    public void secondActionBar_02_tapItemCustom() throws Exception {
        this.actionBarSecondPage.tapCustomItem();
        Assert.assertEquals(getTextFromLabelCustom(), "1 custom tap");
    }

    @Test(groups = {"android", "ios"})
    public void secondActionBar_03_tapBtnHide() throws Exception {
        this.actionBarSecondPage.tapHideBtn();
        if (this.settings.platform == PlatformType.Android) {
            Assert.assertNull(this.actionBarSecondPage.itemCustom());
        }

        this.assertScreen(5);
    }

    @Test(groups = {"android", "ios"})
    public void secondActionBar_04_tapBtnShow() throws Exception {
        this.actionBarSecondPage.tapShowBtn();
        this.actionBarSecondPage.tapCustomItem();
        Assert.assertEquals(getTextFromLabelCustom(), "2 custom taps");
    }

    @Test(groups = {"android", "ios"})
    public void secondActionBar_05_tapActionBarItems() throws Exception {
        this.actionBarSecondPage.tapTapBtn();
        this.actionBarSecondPage.tapTapBtn();
        this.compareScreens(5);
        this.actionBarSecondPage.tapCustomItem();
        this.compareScreens(5);

        if (this.settings.platform == PlatformType.Android) {
            this.actionBarSecondPage.navigateBack();
        }
        if (this.settings.platform == PlatformType.iOS) {
            this.actionBarSecondPage.tapBackItem();
        }

        this.assertImagesResults();
    }
}
