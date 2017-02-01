package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkFileSystemTests extends SdkBaseTest {

    protected String page = "File System";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Paths"},
                {"Create"},
                {"Read"},
                {"Update"},
                {"Delete"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkFileSystemTest(String example) throws Exception {
        this.mainPage.navigateTo(example);
    }
}
