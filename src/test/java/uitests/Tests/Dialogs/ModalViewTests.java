package uitests.Tests.Dialogs;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.helpers.NavigationHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.Dialogs.ModalViewPage;

@SuppressWarnings("groupsTestNG")
public class ModalViewTests extends MobileTest {
    private ModalViewPage modalViewPage;

    protected void waitForScreen(double tolerance) throws Exception {
        this.compareScreens(5, tolerance);
    }

    @BeforeClass(alwaysRun = true)
    public void beforeModalViewSuit() {
        this.modalViewPage = new ModalViewPage("modalview", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void modalView_01_popUp() throws Exception {
        this.modalViewPage.tapPopUpBtn();
        this.modalViewPage.modalViewLoaded();
        this.compareScreens(10, 0.5);

        this.modalViewPage.tapLoginBtn();
        if (this.checkIfPlatformVersionIsIsIOS()) {
            this.compareScreens(10);
        } else {
            Assert.assertEquals(this.modalViewPage.textView().getText(), "username/password");
        }
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void modalView_02_fullScreen() throws Exception {
        this.modalViewPage.tapFullScreenBtn();
        this.modalViewPage.modalViewLoaded();
        this.waitForScreen(0.5);

        this.modalViewPage.tapLoginBtn();
        if (this.checkIfPlatformVersionIsIsIOS()) {
            this.compareScreens(5);
        } else {
            Assert.assertEquals(this.modalViewPage.textView().getText(), "username/password");
        }
        this.assertImagesResults();
    }

    @Test(groups = {"android"})
    public void modalView_03_popUpBack() {
        this.modalViewPage.tapPopUpBtn();
        NavigationHelper.navigateBack(this.context);
        UIElement el = this.navigateBackIfElementNotExists("undefined/undefined");
        Assert.assertEquals(el.getText(), "undefined/undefined");
    }

    @Test(groups = {"android"})
    public void modalView_04_fullScreenBack() {
        this.modalViewPage.tapFullScreenBtn();
        this.modalViewPage.wait.waitForVisible(this.locators.byText("Login", false, false));

        NavigationHelper.navigateBack(this.context);

        this.navigateBackIfElementNotExists("undefined/undefined");
        Assert.assertEquals(this.modalViewPage.textView().getText(), "undefined/undefined");
    }

    @Test(groups = {"android", "ios"})
    public void modalView_05_strechedPopup() throws Exception {
        this.modalViewPage.tapPopupStretchedBtn();
        this.modalViewPage.modalViewLoaded();
        this.assertScreen(20);

        this.modalViewPage.tapLoginBtn();
        this.assertScreen(20);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void modalView_06_secondModalInCB() throws Exception {
        this.modalViewPage.tapSecondModalInCBBtn();
        this.modalViewPage.modalViewLoaded();

        // First modal
        Assert.assertNotNull(this.find.byText("First"), "Failed to find popup");
        Assert.assertNotNull(this.find.byText("username"), "Failed to find popup");
        this.modalViewPage.tapLoginBtn();

        // Second modal
        Assert.assertNotNull(this.find.byText("Second"), "Failed to find popup");
        Assert.assertNotNull(this.find.byText("username"), "Failed to find popup");
        this.modalViewPage.tapLoginBtn();

        Assert.assertEquals(this.modalViewPage.textView().getText(), "Second/username/password");
    }

    @Test(groups = {"android"})
    public void modalView_07_secondModalInTimer() throws Exception {
        this.modalViewPage.tapSecondModalInTimerBtn();
        this.modalViewPage.modalViewLoaded();

        // First modal
        Assert.assertNotNull(this.find.byText("Second"), "Failed to find popup");
        Assert.assertNotNull(this.find.byText("username"), "Failed to find popup");
        this.modalViewPage.tapLoginBtn();

        // Second modal
        Assert.assertNotNull(this.find.byText("First"), "Failed to find popup");
        Assert.assertNotNull(this.find.byText("username"), "Failed to find popup");
        this.modalViewPage.tapLoginBtn();

        Assert.assertEquals(this.modalViewPage.textView().getText(), "First/username/password");
    }

    private UIElement navigateBackIfElementNotExists(String text) {
        UIElement el = this.wait.waitForVisible(this.locators.byText(text));
        if (el == null) {
            NavigationHelper.navigateBack(this.context);
            el = this.wait.waitForVisible(this.locators.byText("undefined/undefined"), true);
        }

        return el;
    }

    private boolean checkIfPlatformVersionIsIsIOS() {
        return this.settings.platform == PlatformType.iOS;
    }
}
