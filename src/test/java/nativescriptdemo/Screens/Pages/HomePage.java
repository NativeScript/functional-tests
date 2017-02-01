package nativescriptdemo.Screens.Pages;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.helpers.NavigationHelper;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends BasePage {

    private int waitTimeOut = this.settings.shortTimeout;
    private GetStartedPage getStartedPage;

    public HomePage() {
        super();
        if (this.settings.deviceName.toLowerCase().contains("arm")) {
            this.log.info("Arm device detected. Increase timeouts");
            waitTimeOut = waitTimeOut * 3;
        }
        this.getStartedPage = new GetStartedPage();
    }

    private UIElement btnSideDrawer() {
        if (this.settings.platform == PlatformType.iOS) {
            return this.find.byLocator(By.id("ic_menu_main"));
        } else if (this.settings.platform == PlatformType.Andorid) {
            return this.wait.waitForVisible(this.locators.imageButtonLocator());
        } else {
            return null;
        }
    }

    public void load() {
        this.getStartedPage.loaded();
        this.getStartedPage.tapGetStarted();
        if (this.loaded() == false) {
            Assert.fail("Home page NOT loaded!");
        }
    }

    public Boolean loaded() {
        UIElement element = this.getMenuButton();

        if (element != null) {
            this.log.info("Home page loaded.");
            return true;
        } else {
            this.log.error("Home page NOT loaded!");
            return false;
        }
    }

    public Boolean unloaded() {
        if (this.loaded()) {
            this.log.error("Home page NOT unloaded! It is still visible.");
            return false;
        } else {
            this.log.info("Home page unloaded. It is not visible.");
            return true;
        }
    }

    public void tapSideDrawer() {
        this.btnSideDrawer().tap();
        this.log.info("Tap on SideDrawer button.");
    }

    @Override
    public boolean navigateTo(String example) {
        UIElement element;
        if (this.settings.platform == PlatformType.Andorid) {
            element = this.gestures.swipeInWindowToElement(SwipeElementDirection.DOWN, this.locators.byText(example), 5, 250, 0);
        } else {
            element = NavigationHelper.scrollTo(example, this.context, 5);
        }

        return super.navigateTo(element);
    }

    private UIElement getMenuButton() {
        UIElement element;
        if (this.settings.platform == PlatformType.Andorid) {
            element = this.wait.waitForVisible(this.locators.imageButtonLocator(), waitTimeOut, false);
        } else if (this.settings.platform == PlatformType.iOS) {
            element = this.wait.waitForVisible(By.id("ic_menu_main"), waitTimeOut, false);
        } else {
            element = null;
        }
        return element;
    }
}
