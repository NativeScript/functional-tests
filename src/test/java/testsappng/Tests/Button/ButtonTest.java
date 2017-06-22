package testsappng.Tests.Button;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.HomePage;
import testsappng.TestsAppNgBase;

public class ButtonTest extends TestsAppNgBase {
    protected HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeButtonTestClass() throws Exception {
        this.homePage = new HomePage("Button", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void text_alignment() throws Exception {
        this.homePage.navigateTo("text-alignment");
        this.assertScreen(5);
    }
}