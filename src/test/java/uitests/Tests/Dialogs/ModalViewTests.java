package uitests.Tests.Dialogs;

import functional.tests.core.basetest.UIBaseTest;
import functional.tests.core.element.UIElement;
import functional.tests.core.helpers.NavigationHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.Dialogs.ModalViewPage;

public class ModalViewTests extends UIBaseTest {
    protected ModalViewPage modalViewPage;

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
        this.waitForScreen(0.5);

        this.modalViewPage.tapLoginBtn();
        Assert.assertEquals(this.modalViewPage.textView().getText(), "username/password");
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void modalView_02_fullScreen() throws Exception {
        this.modalViewPage.tapFullScreenBtn();
        this.modalViewPage.modalViewLoaded();
        this.waitForScreen(0.5);

        this.modalViewPage.tapLoginBtn();
        Assert.assertEquals(this.modalViewPage.textView().getText(), "username/password");
        this.assertImagesResults();
    }

    @Test(groups = {"android"})
    public void modalView_03_popUpBack() throws Exception {
        this.modalViewPage.tapPopUpBtn();
        NavigationHelper.navigateBack(this.context);
        UIElement el = this.wait.waitForVisible(this.locators.byText("undefined/undefined"));
        if (el == null) {
            NavigationHelper.navigateBack(this.context);
            el = this.wait.waitForVisible(this.locators.byText("undefined/undefined"));
        }
        Assert.assertEquals(el.getText(), "undefined/undefined");
    }

    @Test(groups = {"android"})
    public void modalView_04_fullScreenBack() throws Exception {
        this.modalViewPage.tapFullScreenBtn();
        this.modalViewPage.wait.waitForVisible(this.locators.byText("Login", false, false));

        NavigationHelper.navigateBack(this.context);
        Assert.assertEquals(this.modalViewPage.textView().getText(), "undefined/undefined");
    }
}
