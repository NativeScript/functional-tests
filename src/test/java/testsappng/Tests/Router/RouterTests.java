package testsappng.Tests.Router;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.FirstComponentPage;
import testsappng.Screens.HomePage;

public class RouterTests extends RouterBaseTest {
    @BeforeClass(alwaysRun = true)
    public void beforeRouterTestsClass() throws Exception {
        this.homePage = new HomePage("Router", this.context);
        this.firstComponentPage = new FirstComponentPage(this.homePage.context, this.homePage.context.navigationManager);
    }

    @Test(groups = {"android", "ios"})
    public void router_01_firstGoToSecond() throws Exception {
        this.firstComponentPage.loadedFirstComponentPage();
        this.secondComponentPage = this.firstComponentPage.tapGoToSecondBtn();
        this.secondComponentPage.loadedSecondComponentPage();
    }

    @Test(groups = {"android", "ios"})
    public void router_02_secondGoToFirst() throws Exception {
        this.firstComponentPage = this.secondComponentPage.tapGoToFirstBtn();
        this.firstComponentPage.loadedFirstComponentPage();
    }

    @Test(groups = {"android", "ios"})
    public void router_03_second() throws Exception {
        this.secondComponentPage = this.firstComponentPage.tapSecondBtn();
        this.secondComponentPage.loadedSecondComponentPage();
    }

    @Test(groups = {"android", "ios"})
    public void router_04_first() throws Exception {
        this.secondComponentPage.tapFirstBtn();
        this.firstComponentPage.loadedFirstComponentPage();
    }
}
