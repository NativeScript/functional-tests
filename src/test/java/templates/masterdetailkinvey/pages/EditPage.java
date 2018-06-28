package templates.masterdetailkinvey.pages;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class EditPage extends BasePage {

    public EditPage() {
        super();
        UIElement edit = this.wait.waitForVisible(this.locators.findByTextLocator("Edit Car Details", true));
        Assert.assertNotNull(edit, "Edit page not loaded!");
        this.log.info("Edit page loaded.");
    }

    public void tabButton(String name){
        this.find.byText(name).tap();
        this.log.info("Button pressed: " + name);
    }
}