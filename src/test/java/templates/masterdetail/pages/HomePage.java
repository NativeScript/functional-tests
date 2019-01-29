package templates.masterdetail.pages;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage() {
        super();
        String header = "Browse";
        if (this.settings.testAppFileName.toLowerCase().contains("vue")) {
            header = "Car List";
        }
        UIElement browse = this.wait.waitForVisible(this.locators.findByTextLocator(header, true));
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
