package nativescriptdemo.Tests;

import functional.tests.core.basetest.UIBaseTest;
import nativescriptdemo.Screens.Pages.GetStartedPage;
import nativescriptdemo.Screens.Pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class QsfBaseTest extends UIBaseTest {

    public GetStartedPage getStartedPage;
    public HomePage homePage;

    @BeforeClass(groups = {"android", "ios"})
    public void beforeQsfBaseTestClass() {
        this.getStartedPage = new GetStartedPage();
        this.homePage = new HomePage();
    }

    @BeforeMethod(groups = {"android", "ios"})
    public void beforeQsfBaseTestMethod() {
        if (this.homePage.loaded() == false) {
            this.homePage.load();
        }
    }
}
