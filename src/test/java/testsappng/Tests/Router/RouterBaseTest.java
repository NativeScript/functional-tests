package testsappng.Tests.Router;

import org.testng.annotations.BeforeClass;
import testsappng.Screens.FirstComponentPage;
import testsappng.Screens.HomePage;
import testsappng.Screens.SecondComponentPage;
import testsappng.TestsAppNgBase;

public class RouterBaseTest extends TestsAppNgBase {
    protected HomePage homePage;
    protected SecondComponentPage secondComponentPage;
    protected FirstComponentPage firstComponentPage;

    @BeforeClass(alwaysRun = true)
    public void beforeRouterBaseTestClass() throws Exception {
        if (this.settings.platformVersion.toString().startsWith("4")) {
            this.app.restart();
            this.wait.waitForVisible(this.locators.byText("Router"), 5, false);
        }
    }
}
