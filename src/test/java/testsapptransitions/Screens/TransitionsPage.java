package testsapptransitions.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.ClickType;
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
        return createButtonName(flipTrans, goBack, null);
    }

    public static String noTransFlipTransCH() {
        return createButtonName(noTrans, flipTrans, CH);
    }

    public static String flipTransFlipTransCH() {
        return createButtonName(flipTrans, flipTrans, CH);
    }

    public static String slideTransGoBack() {
        return createButtonName(slideTrans, goBack, null);
    }

    public static String noTransSlideTransCH() {
        return createButtonName(noTrans, slideTrans, CH);
    }

    public static String slideTransSlideTransCH() {
        return createButtonName(slideTrans, slideTrans, CH);
    }

    public static String fadeTransGoBack() {
        return createButtonName(fadeTrans, goBack, null);
    }

    public static String noTransFadeCH() {
        return createButtonName(noTrans, fadeTrans, CH);
    }

    public static String fadeTransFadeTransCH() {
        return createButtonName(fadeTrans, fadeTrans, CH);
    }

    public static String customTransGoBack() {
        return createButtonName(customTrans, goBack, null);
    }

    public static String noTransCustomTransCH() {
        return createButtonName(noTrans, customTrans, CH);
    }

    public static String customTransCustomTransCH() {
        return createButtonName(customTrans, customTrans, CH);
    }

    public static String slideCurlTransGoBack() {
        return createButtonName(curlTrans, goBack, null);
    }

    public static String noTransSlideCurlTransCH() {
        return createButtonName(noTrans, curlTrans, CH);
    }

    public static String curlTransCurlTransCH() {
        return createButtonName(curlTrans, curlTrans, CH);
    }

    private static String createButtonName(String firstArg, String secondArg, String additionaArg) {
        if (additionaArg != null) {
            return String.format("%s %s %s %s %s", firstArg, followSign, secondArg, plus, additionaArg);
        } else {
            return String.format("%s %s %s", firstArg, followSign, secondArg);
        }
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
