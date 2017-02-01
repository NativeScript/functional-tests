package testsappng.Tests.Modals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testsappng.Screens.ModalPageBase;

public class ModalTests extends ModalsBaseTest {

    @DataProvider(name = "examples")
    public Object[][] data() {
        return new Object[][]{
                { ModalPageBase.BTN_MODAL_NAME, ModalPageBase.BTN_SHOW_COMPONENT},
                { ModalPageBase.BTN_MODAL_NAME, ModalPageBase.BTN_SHOW_COMPONENT_ASYNC},
                { ModalPageBase.BTN_MODAL_ON_PUSH_NAME, ModalPageBase.BTN_SHOW_COMPONENT},
                { ModalPageBase.BTN_MODAL_ON_PUSH_NAME, ModalPageBase.BTN_SHOW_COMPONENT_ASYNC}
        };
    }

    @Test(dataProvider = "examples",groups = {"android", "ios"})
    public void modalDialog(String example, String openComponent) throws Exception {
        this.openAndAssertModalDialogs(example, openComponent);
    }
}
