package testsappng.Tests.ListView;

import functional.tests.core.enums.PlatformType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.ListViewBasePage;
import testsappng.TestsAppNgBase;

public class ListViewTests extends TestsAppNgBase {

    public final static String LIST_VIEW_EXAMPLES_MAIN_VIEW_NAME = "ListViewExamples";
    public final static String LIST_VIEW_EXAMPLE = "ListView";
    public final static String LIST_VIEW_CUSTOM_TEMPLATE = "ListViewCustomTemplate";
    public final static String LIST_VIEW_ASYNC_PIPE = "ListViewAsyncPipe";
    public final static String LIST_VIEW_NESTED_TEMPLATE = "NestedTemplate";
    public final static String LIST_VIEW_MULTIPLE_TEMPLATES = "MultipleTemplates";

    protected ListViewBasePage listViewBasePage;

    @BeforeClass(alwaysRun = true)
    public void beforeListViewTestClass() throws Exception {
        this.listViewBasePage = new ListViewBasePage(ListViewTests.LIST_VIEW_EXAMPLES_MAIN_VIEW_NAME, this.context);
    }

    @Test(groups = {"android", "ios"})
    public void listViewCommonTemplate_01() throws Exception {
        this.listViewBasePage.navigateTo(ListViewTests.LIST_VIEW_EXAMPLE);
        this.compareImages(5, 0.28);

        this.listViewBasePage.findElementByTextContent("index: 0").click();
        this.compareImages(5, 0.28);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void listViewCustomTemplate_02() throws Exception {
        this.listViewBasePage.navigateTo(ListViewTests.LIST_VIEW_CUSTOM_TEMPLATE);

        this.compareImages(4, 0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void listViewAsyncPipe_03() throws Exception {
        this.listViewBasePage.navigateTo(ListViewTests.LIST_VIEW_ASYNC_PIPE);
        this.listViewBasePage.wait.waitForVisible(this.locators.byText("index: data item 11", false, false), 15, false);
        this.assertScreen(20, 0.3);
    }

    @Test(groups = {"android", "ios"})
    public void listViewNestedTempalet_04() throws Exception {
        this.listViewBasePage.navigateTo(ListViewTests.LIST_VIEW_NESTED_TEMPLATE);
        this.listViewBasePage.wait.waitForVisible(this.locators.byText("item one", false, false), 15, false);
        this.compareScreens("listViewNestedTempalet_04", 20, 0.3);

        this.listViewBasePage.navigateTo(this.listViewBasePage.wait.waitForVisible(this.locators.byText("navigate")));
        this.listViewBasePage.navigateTo(this.listViewBasePage.wait.waitForVisible(this.locators.byText("GO TO SECOND"), 5, true));
        this.compareScreens(20, 0.3);

        this.assertImagesResults();
    }

//    @Test(groups = {"android", "ios"})
//    public void listViewMultipleTemplates_05() throws Exception {
//        this.listViewBasePage.navigateTo(ListViewTests.LIST_VIEW_MULTIPLE_TEMPLATES);
//        this.listViewBasePage.wait.waitForVisible(this.locators.byText("index: data item 11", false, false), 15, false);
//        this.assertScreen(20, 0.3);
//    }

    private void compareImages(int timeOut, double percentTolerance) throws Exception {
        if (checkIfAndoridAndApiLevel24()) {
            this.compareScreens(timeOut, percentTolerance);
        } else {
            this.compareElements(this.listViewBasePage.mainElement(), timeOut, percentTolerance);
        }
    }

    private boolean checkIfAndoridAndApiLevel24() {
        return this.settings.platform == PlatformType.Android && this.settings.platformVersion >= 7;
    }
}

