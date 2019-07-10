package testsapptransitions.Screens;

import functional.tests.core.enums.ClickType;
import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.helpers.NavigationHelper;
import org.openqa.selenium.Point;
import org.testng.Assert;

public class TransitionsPage extends BasePage {

    public final static String FlipTransGoBack = "flip trans -> go back";
    private static final String CH = "CH";
    private static final String plus = "+";
    private static final String followSign = "->";
    private static final String goBack = "go back";
    private static final String noTrans = "no trans";
    private static final String flipTrans = "flip trans";
    private static final String slideTrans = "slide trans";
    private static final String customTrans = "custom trans";
    private static final String fadeTrans = "fade trans";
    private static final String curlTrans = "curl trans";

    public TransitionsPage(MobileContext context) {
        super(context);
    }

    public static String flipTransGoBack() {
        return createButtonName(flipTrans, goBack);
    }

    public static String noTransFlipTransCH() {
        return createButtonName(noTrans, flipTrans);
    }

    public static String flipTransFlipTransCH() {
        return createButtonName(flipTrans, flipTrans);
    }

    public static String slideTransGoBack() {
        return createButtonName(slideTrans, goBack);
    }

    public static String noTransSlideTransCH() {
        return createButtonName(noTrans, slideTrans);
    }

    public static String slideTransSlideTransCH() {
        return createButtonName(slideTrans, slideTrans);
    }

    public static String fadeTransGoBack() {
        return createButtonName(fadeTrans, goBack);
    }

    public static String noTransFadeCH() {
        return createButtonName(noTrans, fadeTrans);
    }

    public static String fadeTransFadeTransCH() {
        return createButtonName(fadeTrans, fadeTrans);
    }

    public static String customTransGoBack() {
        return createButtonName(customTrans, goBack);
    }

    public static String noTransCustomTransCH() {
        return createButtonName(noTrans, customTrans);
    }

    public static String customTransCustomTransCH() {
        return createButtonName(customTrans, customTrans);
    }

    public static String slideCurlTransGoBack() {
        return createButtonName(curlTrans, goBack);
    }

    public static String noTransSlideCurlTransCH() {
        return createButtonName(noTrans, curlTrans);
    }

    public static String curlTransCurlTransCH() {
        return createButtonName(curlTrans, curlTrans);
    }

    private static String createButtonName(String firstArg, String secondArg) {
        return String.format("%s %s %s", firstArg, followSign, secondArg);
    }

    public UIElement mainLayoutContainer() {
        return this.find.byText("container");
    }

    public void executeTransition(String transition) {
        boolean isNavigatedSuccessfully = this.navigateToTransition(transition);
        if (!isNavigatedSuccessfully) {
            Assert.assertTrue(false, String.format("Navigation to %s failed", transition));
        }
    }

    private boolean navigateToTransition(String buttonTextContent) {
        int timeOut = 20000;
        int displayTimeOut = timeOut;
        UIElement button = this.wait.waitForVisible(this.locators.byText(buttonTextContent), timeOut, false);

        if (button != null) {
            Point point = mainLayoutContainer().getLocation();
            this.log.info("Main container location before while cycle is: x = " + point.getX() + " y = " + point.getY());
            this.log.info("The button is visible before while cycle is: " + button.isDisplayed());

            while ((!button.isDisplayed() || point.getX() > 0)
                    && displayTimeOut > 0) {
                this.log.info("The button is visible: " + button.isDisplayed());
                this.log.info("Display retries: " + displayTimeOut);

                point = mainLayoutContainer().getLocation();
                this.log.info("Main container location is: x = " + point.getX() + " y = " + point.getY());
                button = this.find.byText(buttonTextContent, timeOut);
                displayTimeOut -= 1000;
                if (displayTimeOut < 0) {
                    this.log.error("The element is not visible: " + button);
                }
            }

            if (button.isDisplayed()) {
                this.log.info("Navigate to transition: " + buttonTextContent);


                return NavigationHelper.navigateTo(button, ClickType.Click, null, buttonTextContent);
            } else {
                this.log.error("Button is not visible");
                return false;
            }
        }

        return false;
    }
}
