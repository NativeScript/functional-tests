package testsappng.Tests.Modals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testsappng.Screens.ModalPageBase;

public class ModalTests extends ModalsBaseTest {

    @DataProvider(name = "examples")
    public Object[][] data() {
        return new Object[][]{
                {ModalPageBase.BTN_MODAL_NAME, ModalPageBase.BTN_SHOW_COMPONENT},
                {ModalPageBase.BTN_MODAL_NAME, ModalPageBase.BTN_SHOW_COMPONENT_ASYNC},
                {ModalPageBase.BTN_MODAL_ON_PUSH_NAME, ModalPageBase.BTN_SHOW_COMPONENT},
                {ModalPageBase.BTN_MODAL_ON_PUSH_NAME, ModalPageBase.BTN_SHOW_COMPONENT_ASYNC}
        };
    }

    @Test(dataProvider = "examples", groups = {"android", "ios"})
    public void modalDialog(String example, String openComponent) throws Exception {
        this.openAndAssertModalDialogs(example, openComponent);
    }

    @Test(groups = {"android", "ios"})
    public void modalDialogLazy() throws Exception {
        this.modalPageBase.navigateTo(ModalPageBase.BTN_MODAL_LAZY);
        this.compareScreens(5);
        this.modalPageBase.wait.waitForVisible(this.locators.byText(ModalPageBase.BTN_LOAD_MODAL)).tap();
        this.compareScreens(5);
        this.modalPageBase.wait.waitForVisible(this.locators.byText("closeModal"), 5, true).tap();
        this.compareScreens(5);
        this.assertScreen();
    }
}
