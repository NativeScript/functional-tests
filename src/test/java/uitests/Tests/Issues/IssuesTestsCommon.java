package uitests.Tests.Issues;

import functional.tests.core.enums.ClickType;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Wait;
import functional.tests.core.utils.OSUtils;
import io.appium.java_client.SwipeElementDirection;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class IssuesTestsCommon extends IssuesBaseTest {

    private int compareScreens = 10;

    @Test(groups = {"android", "ios"})
    public void issue_2911() throws Exception {
        this.issuesBasePage.navToPage("2911");

        this.compareScreens(compareScreens, 5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void issue_2674() throws Exception {
        this.issuesBasePage.navToPage("2674");

        this.compareScreens(compareScreens, 5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void issue_2942_keyBoardFocusInListViewTemplate() throws Exception {
        this.issuesBasePage.navToPage("2942");
        this.find.byTextContains("Click me 1st").tap();
        this.compareScreens(15, 0.22);
        UIElement textFieldSecond = this.find.byTextContains("Click me 2nd");
        textFieldSecond.tap();
        this.compareScreens(15, 0.40);

        UIElement btn3rd = null;
        if (this.settings.platform == PlatformType.Android) {
            btn3rd = this.find.byTextContains("3rd");
            btn3rd.tap();
            this.compareScreens(15, 0.20);
        }

        if (this.settings.isRealDevice) {
            textFieldSecond.tap();
            Wait.sleep(3000);
            textFieldSecond.sendKeys("3");
            this.compareScreens(15, 0.03);

            if (this.settings.platform == PlatformType.Android) {
                btn3rd.tap();
            }
        }

        this.assertImagesResults();
    }

    // appium issue cannot click on element on landscape mode
    @Test(groups = {"android"})
    public void issue_2942_keyBoardFocusInListViewTemplateLandScape() throws Exception {
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 10) {
            this.log.error("This test in not included for ios 8/9 ");
            return;
        }
        this.issuesBasePage.navToPage("2942");
        this.client.getDriver().rotate(ScreenOrientation.LANDSCAPE);
        this.find.byTextContains("Click me 1st").tap();
        this.compareScreens(15, 0.05);
        this.hideKeyBoard();
        UIElement textFieldSecond = this.find.byTextContains("Click me 2nd");
        textFieldSecond.tap();
        this.compareScreens(15, 0.05);
        this.hideKeyBoard();
        this.client.getDriver().rotate(ScreenOrientation.PORTRAIT);

        this.assertImagesResults();
    }

    @Test(groups = {"android"})
    public void issue_2942_hideSoftKeyBoard() throws Exception {
        this.issuesBasePage.navToPage("2942");
        this.find.byTextContains("hide keyboard").tap();
        this.compareScreens(15, 0.05);

        this.assertImagesResults();
    }

    @Test(groups = {"android, ios"})
    public void issue_3007_clipPath() throws Exception {
        this.issuesBasePage.navToPage("3007");
        this.compareScreens(2);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 200, 200);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 200, 200);
        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android, ios"})
    public void issue_2661_actionBar_backGroundColor() throws Exception {
        this.issuesBasePage.navToPage("2661");
        this.issuesBasePage.navigateTo("Forward", false);
        this.compareScreens(2);

        this.issuesBasePage.navigateBack(this.find.byText("Back"));
        this.compareScreens(2);

        this.assertImagesResults();
    }


    @Test(groups = {"android, ios"})
    public void issue_3113_backGroundTransparent() throws Exception {
        this.issuesBasePage.navToPage("3113");
        this.compareScreens(2);

        this.assertImagesResults();
    }

    @Test(groups = {"android, ios"})
    public void issue_3164_btnBorderWidth() throws Exception {
        this.issuesBasePage.navToPage("3164");
        this.issuesBasePage.find.byTextContains("1.").tap();
        this.compareScreens(5);
        this.issuesBasePage.find.byTextContains("2.").tap();
        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android, ios"})
    public void issue_3175_fontsWeightProperty() throws Exception {
        this.issuesBasePage.navToPage("3175");
        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android, ios"})
    public void issue_3211_btnBackgroundInsideDialogs() throws Exception {
        this.issuesBasePage.navToPage("3211");
        this.issuesBasePage.find.byText("alert me").tap();
        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"ios"})
    public void issue_1657_ios_translucent() throws Exception {
        this.issuesBasePage.navToPage("1657-ios");
        UIElement changeTranslucent = this.issuesBasePage.find.byText("changeTranslucent");
        changeTranslucent.tap();

        double tollerance = 1D;
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 10) {
            tollerance = 3D;
        }
        UIElement navBar = this.issuesBasePage.find.byLocator(this.locators.navigationBarLocator());
        this.compareElements(navBar, 5, tollerance);
        changeTranslucent.tap();
        this.compareElements(navBar, 5, tollerance);

        this.issuesBasePage.find.byText("change speed to very slow").tap();
        Wait.sleep(3);

        UIElement el = this.find.byText("go to subPage");
        this.issuesBasePage.navigateTo(el, ClickType.Click, "sub page");
        this.compareScreens(30, 1.00);
        try {
            this.issuesBasePage.navigateBack();
        } catch (Exception e) {
            UIElement subPage = this.issuesBasePage.wait.waitForVisible(this.locators.byText("SUB PAGE"), this.settings.defaultTimeout, false);

            while (subPage.getUIRectangle().x > 0) {
                subPage = this.issuesBasePage.wait.waitForVisible(this.locators.byText("SUB PAGE"));
                this.log.info(subPage.getUIRectangle() + "; " + subPage.getUIRectangle().getX());
            }

            Wait.sleep(this.settings.defaultTimeout * 850);
            this.issuesBasePage.navigateBack();
        }
        double diff = 0D;
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 10) {
            diff = 4.0D;
        }
        this.compareScreens(30, diff);

        this.app.restart();
        this.context.navigationManager.resetNavigationMainPage();

        this.assertImagesResults();
    }

    @Test(groups = {"android, ios"})
    public void issue_1639_customComponents() throws Exception {
        this.issuesBasePage.navToPage("1639");
        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android, ios"})
    public void issue_3354_ios_hint() throws Exception {
        this.issuesBasePage.navToPage("3354-ios");
        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android, ios"})
    public void issue_4283_internet_sharing() throws Exception {

        Robot robot = new Robot();
        robot.setAutoDelay(3000);
        robot.setAutoWaitForIdle(true);

        //OSUtils.runProcess("osascript -e 'activate application \"Simulator\"'");
        OSUtils.runProcess("osascript -e 'activate application \"Simulator\"' 'set frontmost to true'");
        this.sendShareInternetKeys(robot);
        this.compareScreens(5);

        robot.delay(1000);
        this.sendShareInternetKeys(robot);
        this.compareScreens(5);

        this.assertImagesResults();

    }

    private void sendShareInternetKeys(Robot robot) {
        this.log.info("send key cmd + y");
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_Y);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_Y);
    }

    private void hideKeyBoard() {
        if (this.settings.platform != PlatformType.iOS) {
            if (this.settings.platformVersion == 4.4) {
                UIElement element = this.issuesBasePage.wait.waitForVisible(this.locators.byText("Next"), 3, false);
                if (element != null) {
                    element.tap();
                }
            }
            this.issuesBasePage.hideKeyboard();
        }
    }
}
