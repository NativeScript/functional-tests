package templates.masterdetail.pages;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class DetailsPage extends BasePage {

    public DetailsPage() {
        super();
        UIElement edit = this.wait.waitForVisible(this.locators.findByTextLocator("Edit", true));
        Assert.assertNotNull(edit, "Details page not loaded!");
        this.log.info("Details page loaded.");
    }

    public void navigate(String name) {
        this.find.byText(name).click();
        this.log.info("Navigate to " + name);
    }
}
