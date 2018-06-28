package templates.tabnavigation.pages;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage() {
        super();
        UIElement home = this.wait.waitForVisible(this.locators.findByTextLocator("Home", true));
        Assert.assertNotNull(home, "Home page not loaded!");
        this.log.info("Home page loaded.");
    }


    public void tabButton(String name){
        this.find.byText(name).tap();
        UIElement searchPageTitle = this.wait.waitForVisible(this.locators.findByTextLocator("Search", true));
        Assert.assertNotNull(searchPageTitle);
        this.log.info("Page title pressed: " + name);
    }
}
