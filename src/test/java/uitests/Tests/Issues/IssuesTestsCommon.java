package uitests.Tests.Issues;

import functional.tests.core.enums.ClickType;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.enums.Position;
import functional.tests.core.enums.SwipeElementDirection;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Wait;
import functional.tests.core.utils.OSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

@SuppressWarnings("groupsTestNG")
public class IssuesTestsCommon extends IssuesBaseTest {

    private int compareScreens = 10;
    private int maxPixelTolerance = 2147483647;

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

        // Hack to handle keyboard popup dialog
        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 8.0) {
            this.client.driver.hideKeyboard();
            this.find.byTextContains("Click me 1st").tap();
        }

        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 27.0) {
            if (this.imageVerification.compareScreens("issue_2942_keyBoardFocusInListViewTemplate_with_suggestions", 5, 0, this.maxPixelTolerance, 0.05)) {
                this.assertScreen("issue_2942_keyBoardFocusInListViewTemplate_with_suggestions", 5, 0.05);
            } else if (this.imageVerification.compareScreens("issue_2942_keyBoardFocusInListViewTemplate_with_suggestions_info", 5, 0, this.maxPixelTolerance, 0.05)) {
                this.assertScreen("issue_2942_keyBoardFocusInListViewTemplate_with_suggestions_info", 5, 0.05);
            } else {
                this.assertScreen("issue_2942_keyBoardFocusInListViewTemplate_without_suggestions", 5, 0.05);
            }
        } else {
            this.compareScreens(15, 0.22);
        }
        UIElement textFieldSecond = this.find.byTextContains("Click me 2nd");
        textFieldSecond.tap();
        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 27.0) {
            if (this.imageVerification.compareScreens("issue_2942_keyBoardFocusInListViewTemplate_2", 5, 0, this.maxPixelTolerance, 0.05)) {
                this.assertScreen("issue_2942_keyBoardFocusInListViewTemplate_2", 5, 0.05);
            } else {
                this.assertScreen("issue_2942_keyBoardFocusInListViewTemplate_without_suggestions", 5, 0.05);
            }
        } else {
            this.compareScreens(15, 0.40);
        }


        UIElement btn3rd;
        if (this.settings.platform == PlatformType.Android) {
            btn3rd = this.find.byTextContains("3rd");
            btn3rd.tap();
            if (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 27.0) {

                if (this.imageVerification.compareScreens("issue_2942_keyBoardFocusInListViewTemplate_3", 5, 0, this.maxPixelTolerance, 0.05)) {
                    this.assertScreen("issue_2942_keyBoardFocusInListViewTemplate_3", 5, 0.05);
                } else {
                    this.assertScreen("issue_2942_keyBoardFocusInListViewTemplate_without_suggestions", 5, 0.05);
                }
            } else {
                this.compareScreens(15, 0.20);
            }
        }

        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 27.0) {
            this.log.info("Skip image verification.");
        } else {
            this.assertImagesResults();
        }
    }

    @Test(groups = {"android"})
    public void issue_2942_keyBoardFocusInListViewTemplateLandScape() throws Exception {
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 10) {
            this.log.error("This test in not included for ios 8/9 ");
            return;
        }
        this.issuesBasePage.navToPage("2942");
        this.client.getDriver().rotate(ScreenOrientation.LANDSCAPE);
        this.find.byTextContains("Click me 1st").tap();
        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 27.0) {
            if (this.imageVerification.compareScreens("issue_2942_keyBoardFocusInListViewTemplateLandScape_with_suggestions", 5, 0, this.maxPixelTolerance, 0.05)) {
                this.assertScreen("issue_2942_keyBoardFocusInListViewTemplateLandScape_with_suggestions", 5, 0.05);
            } else if (this.imageVerification.compareScreens("issue_2942_keyBoardFocusInListViewTemplateLandScape_with_suggestions_info", 5, 0, this.maxPixelTolerance, 0.05)) {
                this.assertScreen("issue_2942_keyBoardFocusInListViewTemplateLandScape_with_suggestions_info", 5, 0.05);
            } else {
                this.assertScreen("issue_2942_keyBoardFocusInListViewTemplateLandScape_without_suggestions", 5, 0.05);
            }
        } else {
            this.compareScreens(15, 0.05, true);
        }
        this.hideKeyBoard();
        UIElement textFieldSecond = this.find.byTextContains("Click me 2nd");
        textFieldSecond.tap();
        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 27.0) {
            this.assertScreen("issue_2942_keyBoardFocusInListViewTemplateLandScape_2", 5, 0.05);
        } else {
            this.compareScreens(15, 0.05, true);
        }
        this.hideKeyBoard();
        this.client.getDriver().rotate(ScreenOrientation.PORTRAIT);
        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 27.0) {
            this.log.info("Skip image verification.");
        } else {
            this.assertImagesResults();
        }
    }

    @Test(groups = {"android"})
    public void issue_2942_hideSoftKeyBoard() throws Exception {
        this.issuesBasePage.navToPage("2942");
        this.find.byTextContains("hide keyboard").tap();
        this.compareScreens(15, 0.05);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void issue_3007_clipPath() throws Exception {
        this.issuesBasePage.navToPage("3007");
        this.compareScreens(10);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 200, 200);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 200, 200);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 200, 200);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 200, 200);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 200, 200);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 200, 200);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 200, 200);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 200, 200);
        this.gestures.swipeInWindow(SwipeElementDirection.DOWN, 200, 200);

        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void issue_2661_actionBar_backGroundColor() throws Exception {
        this.issuesBasePage.navToPage("2661");
        this.issuesBasePage.navigateTo("Forward", false);
        this.compareScreens(2);

        this.issuesBasePage.navigateBack(this.find.byText("Back"));
        this.compareScreens(2);

        this.assertImagesResults();
    }


    @Test(groups = {"android", "ios"})
    public void issue_3113_backGroundTransparent() throws Exception {
        this.issuesBasePage.navToPage("3113");
        this.compareScreens(2);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void issue_3164_btnBorderWidth() throws Exception {
        this.issuesBasePage.navToPage("3164");
        this.issuesBasePage.find.byTextContains("1.").tap();
        this.compareScreens(5);
        this.issuesBasePage.find.byTextContains("2.").tap();
        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void issue_3175_fontsWeightProperty() throws Exception {
        this.issuesBasePage.navToPage("3175");
        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void issue_3211_btnBackgroundInsideDialogs() throws Exception {
        this.issuesBasePage.navToPage("3211");
        this.issuesBasePage.find.byText("alert me").tap();
        Wait.sleep(1500);
        this.compareScreens(5);
        this.find.byText("OK").tap();
        Wait.sleep(1500);
        this.assertImagesResults();
    }

    @Test(groups = {"ios"})
    public void issue_1657_ios_translucent() throws Exception {
        this.issuesBasePage.navToPage("1657-ios");
        UIElement changeTranslucent = this.issuesBasePage.find.byText("changeTranslucent");
        changeTranslucent.tap();

        double tolerance = 1D;
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 10) {
            tolerance = 3D;
        }
        UIElement navBar = this.issuesBasePage.find.byLocator(this.locators.navigationBarLocator());
        this.compareElements(navBar, 5, tolerance);
        changeTranslucent.tap();
        this.compareElements(navBar, 5, tolerance);

        this.issuesBasePage.find.byText("change speed to very slow").tap();

        By goToSubPageLocator = this.locators.byText("go to subPage");
        if (this.settings.platformVersion > 10) {
            goToSubPageLocator = By.id("go to subPage");
        }
        UIElement el = this.find.byLocator(goToSubPageLocator);
        this.issuesBasePage.navigateTo(el, ClickType.Click, "sub page");
        this.compareScreens(60, 1.00);

        By locator = this.locators.byText("SUB PAGE");
        if (this.settings.platformVersion > 10) {
            locator = By.id("SUB PAGE");
        }

        UIElement subPage = this.issuesBasePage.wait.waitForVisible(locator, this.settings.defaultTimeout, false);
        this.log.info(subPage.getUIRectangle() + "; " + subPage.getUIRectangle().getX());
        while (subPage.getUIRectangle().x > 0) {
            subPage = this.issuesBasePage.wait.waitForVisible(locator);
            this.log.info(subPage.getUIRectangle() + "; " + subPage.getUIRectangle().getX());
        }

        Wait.sleep(35000);
        this.issuesBasePage.navigateBack();
        this.compareScreens(60, 4.0);

        this.issuesBasePage.wait.waitForVisible(this.locators.byText("default layer speed"), 10, true).tap();
        this.app.restart();
        this.context.navigationManager.resetNavigationMainPage();

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void issue_1639_customComponents() throws Exception {
        this.issuesBasePage.navToPage("1639");
        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void issue_3354_ios_hint() throws Exception {
        this.issuesBasePage.navToPage("3354-ios");
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion == 11.2) {
            this.assertScreen("issue_3354_ios_hint", 15, 0.02);
        } else {
            this.compareScreens(10, 0.02, true);
        }

        UIElement textField;
        if (this.settings.platform == PlatformType.Android) {
            textField = this.find.byLocator(this.locators.editTextLocator());
        } else {
            textField = this.find.byLocator(this.locators.textViewLocator());
        }

        textField.setText("11111");
        if (this.settings.platform == PlatformType.Android) {
            try {
                Wait.sleep(3000);
                this.client.driver.hideKeyboard();
            } catch (Exception e) {
                this.log.info("Failed to hide keyboard.");
            }
        }
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion == 11.2) {
            if (this.imageVerification.compareScreens("issue_3354_ios_hint_2_with_suggestions", 15, 0, this.maxPixelTolerance, 0.02)) {
                this.assertScreen("issue_3354_ios_hint_2_with_suggestions", 15, 0.02);
            } else {
                this.assertScreen("issue_3354_ios_hint_2_without_suggestions", 15, 0.02);
            }
        } else {
            this.compareScreens(15, 0.02, true);
        }
        this.find.byText("clear text", false, 5).tap();
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion == 11.2) {
            this.assertScreen("issue_3354_ios_hint_3", 15, 0.02);
        } else {
            this.compareScreens(15, 0.02, true);
        }
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion == 11.2) {
            this.log.info("Skip image verification.");
        } else {
            this.assertImagesResults();
        }
    }

    @Test(enabled = false, groups = {"ios"})
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

    @Test(groups = {"ios"})
    public void issue_4450() throws Exception {
        this.issuesBasePage.navToPage("4450");

        this.wait.waitForVisible(this.locators.byText("set")).tap();
        this.compareScreens(5);

        this.find.byText("clear").tap();
        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void issue_3714() throws Exception {
        this.issuesBasePage.navToPage("3714");

        this.compareScreens(5);

        this.wait.waitForVisible(this.locators.byText("testBtn")).tap();
        this.compareScreens(5);
        this.find.byText("OK", false, 5).tap();
        this.find.byText("testLabel", false, 5).tap();
        this.compareScreens(5);
        this.find.byText("OK", false, 5).tap();
        this.find.byText("testStackLayout", false, 5).tap();
        this.compareScreens(5);
        this.find.byText("OK", false, 5).tap();
        this.compareScreens(5);

        this.find.byText("toggleUserInteraction", false, 5).tap();

        this.find.byText("testBtn", false, 5).tap();
        this.compareScreens(5);
        this.find.byText("testLabel", false, 5).tap();
        this.compareScreens(5);
        this.find.byText("testStackLayout", false, 5).tap();
        this.compareScreens(5);


        this.find.byText("toggleUserInteraction", false, 5).tap();

        this.find.byText("testBtn", false, 5).tap();
        this.compareScreens(5);
        this.find.byText("OK", false, 5).tap();
        this.find.byText("testLabel", false, 5).tap();
        this.compareScreens(5);
        this.find.byText("OK", false, 5).tap();
        this.find.byText("testStackLayout", false, 5).tap();
        this.compareScreens(5);
        this.find.byText("OK", false, 5).tap();
        this.compareScreens(5);

        this.assertImagesResults();
    }


    @Test(groups = {"android"})
    public void issue_6895_open_file() throws Exception {
        this.issuesBasePage.navToPage("open-file-6895");
        UIElement openFileBtn = this.context.find.byText("openFile");
        openFileBtn.tap();
        this.compareScreens(5);
        this.context.client.getDriver().navigate().back();
        this.issuesBasePage.navigateBack();

        this.assertImagesResults();
    }

    @Test(groups = {"ios", "android"})
    public void ng_repo_1599() throws Exception {
        this.issuesBasePage.navToPage("ng-repo-1599");

        for (int i = 0; i < 10; i++) {
            this.context.gestures.scrollInWindow(SwipeElementDirection.DOWN, Position.FromQuarter, 100);
        }

        this.compareScreens(5);

        for (int i = 0; i < 10; i++) {
            this.context.gestures.scrollInWindow(SwipeElementDirection.UP, Position.FromQuarter, 100);
        }

        this.compareScreens(5);

        assertImagesResults();
    }

    @Test(groups = {"ios", "android"})
    public void ng_repo_1626() throws Exception {
        this.issuesBasePage.navToPage("ng-repo-1626");

        for (int i = 0; i < 10; i++) {
            this.context.gestures.scrollInWindow(SwipeElementDirection.DOWN, Position.FromQuarter, 100);
        }

        this.compareScreens(5);

        for (int i = 0; i < 10; i++) {
            this.context.gestures.scrollInWindow(SwipeElementDirection.UP, Position.FromQuarter, 100);
        }

        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"ios"})
    public void issue_6439() throws Exception {
        this.issuesBasePage.navToPage("6439");
        for (int i = 0; i < 10; i++) {
            this.context.gestures.scrollInWindow(SwipeElementDirection.DOWN, Position.FromQuarter, 100);
        }

        this.compareScreens(5);

        for (int i = 0; i < 10; i++) {
            this.context.gestures.scrollInWindow(SwipeElementDirection.UP, Position.FromQuarter, 100);
        }

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
