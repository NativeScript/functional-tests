package sdkexamples.Tests;

import org.openqa.selenium.By;
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
                {pageSpecific, this.mainPage.btnOkLocator()},
                {pageCustom, null}
        };
    }


    @Test(dataProvider = "example")
    public void sdkTraceModuleTest(String example, By locator) throws Exception {
        this.mainPage.navigateTo(example);
        if (locator != null) {
            this.find.byLocator(locator).tap();
        }
    }
}
