package sdkexamples.Tests;

import functional.tests.core.mobile.element.UIElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkTraceModuleTests extends SdkBaseTest {

    protected String page = "Trace Module";
    private String pageSpecific = "Trace Specific categories";
    private String pageCustom = "Writing a Custom TraceWriter";

    @Override
    protected String subMainPage() {
        return this.page;
    }


    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {pageSpecific},
                {pageCustom}
        };
    }

    @Test(dataProvider = "example")
    public void sdkTraceModuleTest(String example) {
        this.mainPage.navigateTo(example);
        UIElement alert = this.wait.waitForVisible(this.mainPage.btnOkLocator(), 30, false);
        if (alert != null) {
            alert.tap(500);
        }
    }
}
