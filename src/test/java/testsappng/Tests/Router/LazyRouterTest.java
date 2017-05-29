package testsappng.Tests.Router;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.TestsAppNgBasePage;
import testsappng.TestsAppNgBase;

public class LazyRouterTest extends TestsAppNgBase {

    private static String mainPage = "Lazy Router";
    private TestsAppNgBasePage testsAppNgBasePage;

    @BeforeClass(alwaysRun = true)
    public void beforeLazyRouterTestClass() throws Exception {
        this.testsAppNgBasePage = new TestsAppNgBasePage(mainPage, this.context);
    }

    @Test(groups = {"android", "ios"})
    public void lazy_router() throws Exception {
        this.testsAppNgBasePage.navigateTo("Lazy module", false);
        this.compareScreens(5);
        this.testsAppNgBasePage.navigateBack();
        this.compareScreens();
        this.testsAppNgBasePage.navigateTo("Lazy module", false);
        this.compareScreens();
    }
}
