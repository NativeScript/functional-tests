package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkSearchBarTests extends SdkBaseTest {

    protected String page = "SearchBar";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Basic SearchBar"},
                {"Clear SearchBar"},
                {"SearchBar binding"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkSearchBarTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
        this.mainPage.hideKeyboard();
    }
}
