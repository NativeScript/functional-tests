package testsappng.Tests.Router;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.FirstComponentPage;
import testsappng.Screens.HomePage;
import testsappng.Screens.SecondComponentPage;

public class PageRouterTests extends RouterBaseTest {

    @BeforeClass(alwaysRun = true)
    public void beforeClassPageRouterTests() throws Exception {
        this.homePage = new HomePage("First", this.context);
        this.firstComponentPage = new FirstComponentPage(context);
        this.secondComponentPage = new SecondComponentPage(this.context);
    }

    @Test(groups = {"android", "ios"})
    public void pageRouter_01_firstGoToSecond() throws Exception {
        this.firstComponentPage.loadedFirstComponentPage();
        this.homePage.navigateTo(FirstComponentPage.bntGoToSecond, false);
        this.secondComponentPage.loadedSecondComponentPage();
    }

    @Test(groups = {"android", "ios"})
    public void pageRouter_02_secondGoToFirst() throws Exception {
        this.homePage.navigateTo(SecondComponentPage.bntGoToFirst, false);
        this.firstComponentPage.loadedFirstComponentPage();
    }

    @Test(groups = {"android", "ios"})
    public void pageRouter_03_firstBackToSecond() throws Exception {
        this.homePage.navigateBack();
        this.secondComponentPage.loadedSecondComponentPage();
    }

    @Test(groups = {"android", "ios"})
    public void pageRouter_04_secondBackToFirst() throws Exception {
        this.homePage.navigateBack();
        this.firstComponentPage.loadedFirstComponentPage();
        this.homePage.navigateBack();
        this.homePage.homePageLoaded();
    }
}
