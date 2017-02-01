package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkAngularDirectivesTests extends SdkBaseTest {

    protected String page = "Angular directives";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Create custom directive"},
                {"*ngFor repeater directive"},
                {"*ngSwitch structural directive"},
                {"*sdkUnless custom directive"},
                {"*ngIf directive - basic example"},
                {"*ngIf directive - platform specific example"},
        };
    }

    @Test(dataProvider = "example")
    public void sdkAngularDirectivesTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
