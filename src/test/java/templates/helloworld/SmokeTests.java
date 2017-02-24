package templates.helloworld;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.Test;

public class SmokeTests extends MobileTest {

    @Test(groups = {"android", "ios"})
    public void test_01_smoke() throws Exception {
        HomePage homePage = new HomePage();
        homePage.loaded();
        this.compareScreens();
        this.assertImagesResults();
        for (int i = 0; i < 10; i++) {
            homePage.button().tap();
        }
        homePage.loaded();
    }
}