package templates.masterdetail.pages;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class EditPage extends BasePage {

    public EditPage() {
        super();
        String header = "Edit Car Details";
        if (this.settings.testAppFileName.toLowerCase().contains("vue")) {
            header = "Cancel";
        }
        UIElement edit = this.wait.waitForVisible(this.locators.findByTextLocator(header, true));
        Assert.assertNotNull(edit, "Edit page not loaded!");
        this.log.info("Edit page loaded.");
    }

    public void tapButton(String name) {
        this.find.byText(name).tap();
        this.log.info("Button pressed: " + name);
    }
}