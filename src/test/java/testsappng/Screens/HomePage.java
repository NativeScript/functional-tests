package testsappng.Screens;

import functional.tests.core.mobile.basepage.BasePageExtended;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.helpers.NavigationManager;
import org.testng.Assert;

public class HomePage extends BasePageExtended {

    public HomePage(String mainPage, MobileContext context) {
        super(mainPage, context);
        if (!mainPage.isEmpty()) {
            this.testsAppNgHomeNavigateToPage(mainPage);
        }
    }

    public HomePage(MobileContext context, NavigationManager navigationManager) {
        super(context, navigationManager);
    }

    public HomePage(String testPage, String waitForElement, MobileContext context) {
        super(testPage, context);
        this.testsAppNgHomeNavigateToPage(waitForElement);
    }

    public void testsAppNgHomeNavigateToPage(String element) {
        UIElement btnElement = this.wait.waitForVisible(this.locators.byText(element));
        boolean hasNavigated = this.navigateTo(btnElement);

        if (hasNavigated) {
            this.log.info("UITests app " + element + " page homePageLoaded.");
        } else {
            this.log.info("Failed to navigate to " + element + " page.");
        }
    }

    private UIElement label() {
        return this.find.byText(this.mainPage, 25);
    }

    public void homePageLoaded() {
        if (this.label() != null) {
            this.log.info("Main component homePageLoaded.");
        } else {
            Assert.fail("Main component NOT homePageLoaded.");
        }
    }

    public void resetNavigationMainPage() {
        this.navigationManager.resetNavigationMainPage();
    }

    public void setMainPage(String mainPage) {
        this.navigationManager.setMainPage(mainPage);
    }
}
