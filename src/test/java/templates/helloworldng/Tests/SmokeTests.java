package templates.helloworldng.Tests;

import functional.tests.core.basetest.UIBaseTest;
import org.testng.annotations.Test;
import templates.helloworldng.Screens.HomePage;

public class SmokeTests extends UIBaseTest {

    @Test(groups = {"android", "ios"})
    public void test_01_home() throws Exception {
        HomePage homePage = new HomePage();
        homePage.loaded();
        this.log.logScreen("hello-world-ng");
        // TODO(): Compare screens after design is final.
        // this.compareScreens();
        // this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void test_02_navigation() throws Exception {
        HomePage homePage = new HomePage();
        homePage.loaded();

        // TODO(): Add navigation tests
    }
}