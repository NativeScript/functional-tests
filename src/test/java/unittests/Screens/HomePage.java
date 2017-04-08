package unittests.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends BasePage {

    private static final String strCompleted = "ALL TESTS COMPLETE";
    private static final String strNotFailed = "OK, 0 failed";

    public HomePage() {
        super();
    }

    private By locatorComplete() {
        return this.locators.byText(strCompleted, false, false);
    }

    private By locatorNotFailed() {
        return this.locators.byText(strNotFailed, false, false);
    }

    public boolean waitForTestsToComplete() {

        // Timeout in minutes
        int minutes = 5;
        boolean isAppRunning, result = false;

        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) < minutes * 60 * 1000) {

            // isAppRunning() is implemented only for Android
            isAppRunning = this.context.getDevice().isAppRunning(this.settings.packageId);
            if (isAppRunning == false) {
                String message = "App crashed!";
                this.log.fatal(message);
                Assert.fail(message);
            }

            UIElement element = this.find.byLocator(this.locatorComplete(), 1);

            if (element != null) {
                this.log.info("\'" + strCompleted + "\' found!");
                break;
            }
        }

        this.log.logScreen("unittests", "Final Screen: ", 80 * 4, 60 * 4);

        UIElement notFailed = this.wait.waitForVisible(this.locatorNotFailed(), 3, false);
        if (notFailed != null) {
            this.log.info("\'" + strNotFailed + "\' found!");
            result = true;
        } else {
            this.log.error("\'" + strNotFailed + "\' NOT found!");
        }

        return result;
    }
}
