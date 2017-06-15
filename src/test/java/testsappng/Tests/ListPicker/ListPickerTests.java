package testsappng.Tests.ListPicker;

import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.ListViewBasePage;
import testsappng.TestsAppNgBase;

public class ListPickerTests extends TestsAppNgBase {

    public final static String LIST_VIEW_EXAMPLE = "ListPicker";

    protected ListViewBasePage listViewBasePage;

    @BeforeClass(alwaysRun = true)
    public void beforeListViewTestClass() throws Exception {
        this.listViewBasePage = new ListViewBasePage(ListPickerTests.LIST_VIEW_EXAMPLE, this.context);
        this.listViewBasePage.navigateTo(ListPickerTests.LIST_VIEW_EXAMPLE);
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

