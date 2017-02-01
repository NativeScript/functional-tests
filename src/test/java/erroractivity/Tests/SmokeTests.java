package erroractivity.Tests;

import functional.tests.core.basetest.UIBaseTest;
import functional.tests.core.element.UIElement;
import functional.tests.core.find.Locators;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import erroractivity.Screens.HomePage;

public class SmokeTests extends UIBaseTest {

    private UIElement exception;
    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeSmokeTests() {
        this.homePage = new HomePage(this.context);
    }

    @Test(groups = {"debug"})
    public void smoke_debug() throws Exception {
        this.homePage.loaded();
        this.homePage.wait.waitForVisible(this.locators.byText("42 taps left"), false);
        this.homePage.tap();

        exception = this.homePage.exceptionButton();
        Assert.assertNotNull(exception);
        this.log.logScreen(this.context.getTestName(), this.context.getTestName(), 320, 240);
    }

    @Test(groups = {"release"})
    public void smoke_release() throws Exception {
        this.homePage.loaded();
        this.homePage.wait.waitForVisible(this.locators.byText("42 taps left"), false);
        this.homePage.tap();

        exception = this.homePage.exceptionButton();
        Assert.assertNull(exception);
        this.log.logScreen(this.context.getTestName(), this.context.getTestName(), 320, 240);
    }
}
