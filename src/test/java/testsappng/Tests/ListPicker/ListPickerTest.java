package testsappng.Tests.ListPicker;

import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.HomePage;
import testsappng.TestsAppNgBase;

public class ListPickerTest extends TestsAppNgBase {

    public final static String LIST_PICKER_EXAMPLE = "ListPicker";

    protected HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeListPickerTestClass() throws Exception {
        this.homePage = new HomePage(ListPickerTest.LIST_PICKER_EXAMPLE, this.context);
        UIElement listPicker = this.context.wait.waitForVisible(this.locators.byText(ListPickerTest.LIST_PICKER_EXAMPLE), 3, true);
        this.homePage.navigateTo(listPicker, "list-picker-test-page");
    }

    @Test(groups = {"android", "ios"})
    public void listPickerCommonTemplate_01() throws Exception {
        this.assertScreen(5);
    }

    @Test(groups = {"android", "ios"})
    public void listPickerRotate_02() throws Exception {
        this.context.device.rotate(ScreenOrientation.LANDSCAPE);
        this.compareScreens(5);
        this.context.device.rotate(ScreenOrientation.PORTRAIT);
        this.compareScreens(5);
        this.assertImagesResults();
    }
}

