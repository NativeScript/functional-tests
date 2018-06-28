package templates.drawernavigation.pages;

import functional.tests.core.enums.PlatformType;
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

    private UIElement drawerIcon(){
        if (this.settings.platform == PlatformType.Android) {
            return this.find.byLocator(this.locators.imageButtonLocator());
        }
        else{
            return this.find.byLocator(this.locators.buttonLocator());
        }
    }

    public void openDrawer() {
        this.drawerIcon().tap();
        UIElement userName = this.wait.waitForVisible(this.locators.findByTextLocator("User Name", true));
        UIElement userEmail = this.wait.waitForVisible(this.locators.findByTextLocator("username@mail.com", true));
        Assert.assertNotNull(userName);
        Assert.assertNotNull(userEmail);
        this.log.info("Drawer Navigation opened.");
    }

    public void navigate(String pageName){
        this.find.byText(pageName).tap();
        UIElement browse = this.wait.waitForVisible(this.locators.findByTextLocator("Browse", true));
        Assert.assertNotNull(browse);
        this.log.info("Navigate to " + pageName);
    }
}