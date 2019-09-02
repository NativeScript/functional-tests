package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkButtonTests extends SdkBaseTest {

    private final String pageButtonTap = "Tap event";
    protected String page = "Button";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Usage"},
                {"Styling"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkButtonTest_01_tap(String example) throws Exception {
        this.mainPage.navigateTo(example);
        if(example == "Usage"){
            this.mainPage.find.byText("Tap me!").click();
            this.mainPage.log.logScreen(pageButtonTap);
            this.mainPage.find.byText("OK").click();
        }

    }
}
