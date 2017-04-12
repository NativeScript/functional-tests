package testsappng.ListPicker;

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
    }

    @Test(groups = {"android", "ios"})
    public void listPickerCommonTemplate_01() throws Exception {
        this.listViewBasePage.navigateTo(ListPickerTests.LIST_VIEW_EXAMPLE);
        this.assertScreen(5);
    }
}

