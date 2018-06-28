package templates.masterdetailkinvey.pages;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage() {
        super();
        UIElement browse = this.wait.waitForVisible(this.locators.findByTextLocator("Browse", true));
        Assert.assertNotNull(browse, "Home page not loaded!");
        this.log.info("Home page loaded.");
    }

    /**
     * Verify home page loaded.
     */
    public void navigate(String carName) {
        this.find.byText(carName).click();
        this.log.info("Navigate to " + carName);
    }
}
