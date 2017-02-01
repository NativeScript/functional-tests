package testsappng.Tests.Modals;

import functional.tests.core.element.UIElement;
import org.testng.annotations.BeforeClass;
import testsappng.Screens.ModalPageBase;
import testsappng.TestsAppNgBase;

public class ModalsBaseTest extends TestsAppNgBase {
    private static int counter = 0;

    protected ModalPageBase modalPageBase;

    @BeforeClass(alwaysRun = true)
    public void beforeModalsBaseTestClass() throws Exception {
        this.modalPageBase = new ModalPageBase(this.context);
        this.wait.waitForVisible(this.locators.byText(ModalPageBase.BTN_MODAL_NAME));
        this.modalPageBase.setMainPage("Modals");
    }

    public void openAndAssertModalDialogs(String navigate, String openComponent) throws Exception {
        this.modalPageBase.navigateToMainPage();
        UIElement navigationButton = this.modalPageBase.wait.waitForVisible(this.locators.byText(navigate, false, false), 6, true);
        this.modalPageBase.navigateTo(navigationButton);

        UIElement optionButton = this.modalPageBase.wait.waitForVisible(this.locators.byText(openComponent, false, false), 6, true);
        this.modalPageBase.navigateTo(optionButton);
        this.compareScreens(this.getImageName(navigate, openComponent), 5);

        this.modalPageBase.navigateBack(this.modalPageBase.btnOk());
        this.compareScreens(5);

        optionButton = this.modalPageBase.find.byTextContains(openComponent);
        this.modalPageBase.navigateTo(optionButton);
        this.compareScreens(this.getImageName(navigate, openComponent), 5);

        this.modalPageBase.navigateBack(this.modalPageBase.btnCancel());
        this.compareScreens(this.getImageName(navigate, openComponent), 5);

        this.assertImagesResults();
    }

    private String getImageName(String navigate, String openComponent) {
        counter += 1;
        return this.context.getTestName() + "_" + navigate + "_" + openComponent + "_" + counter;
    }
}
