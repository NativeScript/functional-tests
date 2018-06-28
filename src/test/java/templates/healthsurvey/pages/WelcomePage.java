package templates.healthsurvey.pages;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class WelcomePage extends BasePage {

    private String androidTabItemLocator = "//android.widget.HorizontalScrollView//android.widget.TextView";

    public WelcomePage() {
        super();
        UIElement home = this.wait.waitForVisible(this.locators.findByTextLocator("Welcome", true), this.settings.defaultTimeout, false);
        Assert.assertNotNull(home, "Welcome page not loaded!");
        this.log.info("Welcome page loaded.");
    }


    public LoginPage cancel() {
        this.find.byText("Cancel").click();
        this.log.info("Click 'Cancel' button.");
        return new LoginPage();
    }

    public void getStarted() {
        this.find.byText("Get Started").click();
        this.log.info("Click 'Get Started' button.");
    }

    public void next() {
        this.find.byText("Next").click();
        this.log.info("Click 'Next' button.");
    }
}
