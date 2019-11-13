package uitests.Tests.Issues;

import functional.tests.core.enums.ClickType;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.enums.SwipeElementDirection;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Wait;
import functional.tests.core.utils.OSUtils;
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
        this.find.byTextContains("Click me 1st").click();

        // Hack to handle keyboard popup dialog
        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion == 8.0) {
            this.client.driver.hideKeyboard();
            this.find.byTextContains("Click me 1st").click();
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
        textFieldSecond.click();
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
            btn3rd.click();
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
        this.find.byTextContains("Click me 1st").click();
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
        textFieldSecond.click();
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
        this.find.byTextContains("hide keyboard").click();
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
        this.compareScreens(5);
        this.issuesBasePage.navigateBack(this.issuesBasePage.findElement("Back"));
        this.compareScreens(5);
        this.assertImagesResults();
    }


    @Test(groups = {"android", "ios"})
    public void issue_3113_backGroundTransparent() throws Exception {
        this.issuesBasePage.navToPage("3113");
        this.compareScreens(5);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void issue_3164_btnBorderWidth() throws Exception {
        this.issuesBasePage.navToPage("3164");
        this.issuesBasePage.find.byTextContains("1.").click();
        this.compareScreens(5);
        this.issuesBasePage.find.byTextContains("2.").click();
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
        this.issuesBasePage.findElement("alert me").click();
        Wait.sleep(1500);
        this.compareScreens(5);
        this.issuesBasePage.findElement("OK").click();
        Wait.sleep(1500);
        this.assertImagesResults();
    }

    @Test(groups = {"ios"})
    public void issue_1657_ios_translucent() throws Exception {
        this.issuesBasePage.navToPage("1657-ios");
        UIElement changeTranslucent = this.issuesBasePage.findElement("changeTranslucent");
        changeTranslucent.click();

        double tolerance = 1D;
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 10) {
            tolerance = 3D;
        }
        UIElement navBar = this.issuesBasePage.find.byLocator(this.locators.navigationBarLocator());
        this.compareElements(navBar, 5, tolerance);
        changeTranslucent.click();
        this.compareElements(navBar, 5, tolerance);

        this.issuesBasePage.findElement("change speed to very slow").click();

        UIElement el = this.issuesBasePage.findElement("go to subPage");
        this.issuesBasePage.navigateTo(el, ClickType.Click, "sub page");
        this.compareScreens(60, 1.00);

        UIElement subPage = this.issuesBasePage.findElement("SUB PAGE");
        this.log.info(subPage.getUIRectangle() + "; " + subPage.getUIRectangle().getX());
        while (subPage.getUIRectangle().x > 0) {
            subPage = this.issuesBasePage.findElement("SUB PAGE");
            this.log.info(subPage.getUIRectangle() + "; " + subPage.getUIRectangle().getX());
        }

        Wait.sleep(35000);
        this.issuesBasePage.navigateBack();
        this.compareScreens(60, 4.0);

        this.issuesBasePage.findElement("default layer speed").click();
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
        this.issuesBasePage.findElement("clear text").click();
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
        this.issuesBasePage.findElement("set").click();
        this.compareScreens(5);
        this.issuesBasePage.findElement("clear").click();
        this.compareScreens(5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void issue_3714() throws Exception {
        this.issuesBasePage.navToPage("3714");

        this.compareScreens(5);

        this.issuesBasePage.findElement("testBtn").click();
        this.compareScreens(5);
        this.issuesBasePage.findElement("OK").click();
        this.issuesBasePage.findElement("testLabel").click();
        this.compareScreens(5);
        this.issuesBasePage.findElement("OK").click();
        this.issuesBasePage.findElement("testStackLayout").click();
        this.compareScreens(5);
        this.issuesBasePage.findElement("OK").click();
        this.compareScreens(5);

        this.issuesBasePage.findElement("toggleUserInteraction").click();

        this.issuesBasePage.findElement("testBtn").click();
        this.compareScreens(5);
        this.issuesBasePage.findElement("testLabel").click();
        this.compareScreens(5);
        this.issuesBasePage.findElement("testStackLayout").click();
        this.compareScreens(5);


        this.issuesBasePage.findElement("toggleUserInteraction").click();

        this.issuesBasePage.findElement("testBtn").click();
        this.compareScreens(5);
        this.issuesBasePage.findElement("OK").click();
        this.issuesBasePage.findElement("testLabel").click();
        this.compareScreens(5);
        this.issuesBasePage.findElement("OK").click();
        this.issuesBasePage.findElement("testStackLayout").click();
        this.compareScreens(5);
        this.issuesBasePage.findElement("OK").click();
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
                    element.click();
                }
            }
            this.issuesBasePage.hideKeyboard();
        }
    }
}
