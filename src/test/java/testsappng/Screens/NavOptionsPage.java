package testsappng.Screens;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.find.Wait;

public class NavOptionsPage extends HomePage {
    public static String frameStackString = "frameStack";
    public static String navOptionsPage = "nav-options";
    public static String pageTransitions = "page-transitions";

    public NavOptionsPage(MobileContext context) {
        super(navOptionsPage, context);
    }

    public void clearHistory() {
        Wait.sleep(2000);
        UIElement element = this.wait.waitForVisible(this.locators.byText("clear-history"));

        this.log.info("Is clear-history isDisplayed " + element.isDisplayed());
        this.log.info("Is clear-history isEnabled " + element.isEnabled());

        element.tap();
        this.log.info("Click on clear-history");
    }

    public void pageTransitions() {
        Wait.sleep(2000);

        UIElement element = this.wait.waitForVisible(this.locators.byText(pageTransitions));
        this.log.info("pageTransitions isDisplayed " + element.isDisplayed());
        this.navigationManager.setCurrentPage(pageTransitions);
        element.tap();
        this.log.info("Click on " + pageTransitions);
    }

    public void update() {
        UIElement element = this.wait.waitForVisible(this.locators.byText("update"));
        element.click();
        this.log.info("Click on update");
    }

    public void backToMain() {
        this.btnBackToMain().click();
        this.log.info("Click on btnBackToMain");
    }

    public void navigateWithBackToMain() {
        this.navigateBack(this.btnBackToMain());
        this.log.info("Navigate with on btnBackToMain");
    }

    public UIElement btnBackToMain() {
        return this.find.byText("back to main", 25);
    }

    public void waitForFrameStackLabelToLoad() {
        Wait.sleep(20000);
        this.wait.waitForVisible(this.locators.byText(frameStackString, false, false), 20, false);
    }

    public void waitForPageTransitionToLoadToLoad() {
        Wait.sleep(20000);
        this.wait.waitForVisible(this.locators.byText(pageTransitions), 20, false);
    }

    public String getFrameStack() {
        UIElement label =
                this.wait.waitForVisible(this.locators.byText("frameStack", false, false));
        if (this.settings.platform == PlatformType.Android) {
            return label.getText();
        } else {
            return label.getAttribute("value");
        }
    }

    public String getLocationStack() {
        UIElement label =
                this.wait.waitForVisible(this.locators.byText("locationStack", false, false));
        if (this.settings.platform == PlatformType.Android) {
            return label.getText();
        } else {
            return label.getAttribute("value");
        }
    }

    public void navOptionsPageLoaded() {
        this.wait.waitForVisible(this.locators.byText(pageTransitions));
    }
}
