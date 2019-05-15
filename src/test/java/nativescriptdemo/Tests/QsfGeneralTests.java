package nativescriptdemo.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QsfGeneralTests extends QsfBaseTest {

    @BeforeMethod(groups = {"android", "ios"})
    public void beforeQsfBaseTestMethod() {
    }

    @Test(groups = {"android", "ios", "api19"})
    public void test_01_home() throws Exception {
        this.getStartedPage.loaded();
        this.compareScreens("GetStartedPage", 10, 0.65);
        this.getStartedPage.tapGetStarted();
        this.homePage.loaded();
        this.compareScreens("HomePage", 10, 1.5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios", "api19"})
    public void test_02_runInBackground() throws Exception {
        if (this.homePage.loaded() == false) {
            Assert.fail("Home page NOT loaded");
        } else {
            this.app.runInBackground(10);
            Assert.assertTrue(this.homePage.loaded());
            this.compareScreens("HomePage", 10, 1.5);
            this.assertImagesResults();
        }
    }
}
