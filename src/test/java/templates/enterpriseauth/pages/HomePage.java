package templates.enterpriseauth.pages;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage() {
        super();
        Assert.assertNotNull(welcomeMessage(), "HomePage page not loaded!");
        this.log.info("Home page loaded.");
    }

    public void logout() {
        this.find.byText("Log out", false, this.settings.defaultTimeout).click();
    }

    public UIElement welcomeMessage() {
        return this.find.byText("Welcome", false, this.settings.defaultTimeout);
    }

    public UIElement homeButton() {
        return this.find.byText("Home", false, this.settings.defaultTimeout);
    }

    public UIElement newsButton() {
        return this.find.byText("News", false, this.settings.defaultTimeout);
    }

    public UIElement favouritesButton() {
        return this.find.byText("Favourites", false, this.settings.defaultTimeout);
    }

    public UIElement dettingsButton() {
        return this.find.byText("Settings", false, this.settings.defaultTimeout);
    }
}
