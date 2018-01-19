package uitests.Tests.Gestures;

import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import io.appium.java_client.SwipeElementDirection;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.GesturesPage;

public class GesturesTests extends GesturesBaseTest {

    private GesturesPage gesturesPage;

    @BeforeClass(alwaysRun = true)
    public void beforeGesturesTestsClass() {
        this.gesturesPage = new GesturesPage(this.homePageExtended);
        this.gesturesPage.navigateToGestures();
    }

    @Test(groups = {"android", "ios"})
    public void gestures_01_tap() throws Exception {
        this.gesturesPage.lblTap().tap();
        Assert.assertNotNull(this.homePageExtended.find.byText("Tap gesture detected, true", false, 3), "Tap gesture NOT detected.");
    }

    @Test(groups = {"ios"})
    public void gestures_02_doubleTap() throws Exception {
        if (!this.homePageExtended.checkIfPlatfomrVersionIsIos10()) {
            this.gesturesPage.navigateToGestures();
            this.gesturesPage.lblDoubleTap().doubleTap();

            Assert.assertNotNull(this.homePageExtended.find.byText("Double Tap gesture detected, true"), "Double Tap gesture NOT detected.");
        }
    }

    @Test(groups = {"android", "ios"})
    public void gestures_03_longPress() throws Exception {
        this.gesturesPage.navigateToGestures();

        this.gesturesPage.lblLongPress().longPress(3000);
        Assert.assertNotNull(this.homePageExtended.find.byText("Long Press gesture detected, true"), "Long Press gesture NOT detected.");
    }

    @Test(groups = {"android", "ios"})
    public void gestures_04_swipe() throws Exception {
        this.gesturesPage.navigateToGestures();
        this.gesturesPage.lblSwipe().swipeInElement(SwipeElementDirection.LEFT, 250, 1000);

        Assert.assertNotNull(this.homePageExtended.find.byLocator(this.locators.byText("Swipe Direction: 1, true", true, false)), "Swipe gesture NOT detected.");
    }

    @Test(groups = {"android", "ios"})
    public void gestures_05_pan() throws Exception {
        this.gesturesPage.navigateToGestures();

        this.gesturesPage.lblPan().pan(SwipeElementDirection.RIGHT, 3000);
        Assert.assertNotNull(this.homePageExtended.find.byTextContains("Pan deltaX:"), "Pan on left NOT detected.");
        Assert.assertNotNull(this.homePageExtended.find.byTextContains("deltaY:0"), "Pan on left detected, but with wrong Y coordinate.");
        if (this.settings.platform == PlatformType.Android) {
            Assert.assertNotNull(this.homePageExtended.find.byTextContains("Pan deltaX:-"), "Pan on left detected, but with wrong X coordinate.");
        }
        Assert.assertNotNull(this.homePageExtended.find.byTextContains("true"), "Args.object is NOT correct.");
        Assert.assertNotNull(this.homePageExtended.find.byTextContains("states: began,changed,ended"), "States are NOT correct.");
    }

    @Test(groups = {"android", "ios"})
    public void gestures_06_pinch() throws Exception {
        if (!(this.settings.platformVersion.toString()).equals("4.2") && !this.homePageExtended.checkIfPlatfomrVersionIsIos10()) {
            this.gesturesPage.navigateToGestures();

            this.gesturesPage.lblPinch().pinch();
            if (this.settings.platform == PlatformType.Android) {
                Assert.assertNotNull(this.homePageExtended.find.byTextContains("Pinch Scale: 1"), "Pinch NOT detected.");
            }
            if (this.settings.platform == PlatformType.iOS) {
                Assert.assertNotNull(this.homePageExtended.find.byTextContains("Pinch Scale:"), "Pinch NOT detected.");
            }
            Assert.assertNotNull(this.homePageExtended.find.byTextContains("true"), "Args.object is NOT correct.");
            if (!this.settings.deviceName.equals("GalaxyS4")) {
                Assert.assertNotNull(this.homePageExtended.find.byTextContains("states: began,changed,ended"), "States are NOT correct.");
            } else {
                Assert.assertNotNull(this.homePageExtended.find.byTextContains("states: began,ended"), "States are NOT correct.");
            }
        }
    }

    @Test(groups = {"android", "ios"})
    public void gestures_07_rotate() throws Exception {
        if (!(this.settings.platformVersion.toString()).equals("4.2") && !this.homePageExtended.checkIfPlatfomrVersionIsIos10()) {
            this.gesturesPage.navigateToGestures();

            this.gesturesPage.lblRotate().rotate();
            Assert.assertNotNull(this.homePageExtended.find.byTextContains("Rotation: "), "Rotation NOT detected.");
            Assert.assertNotNull(this.homePageExtended.find.byTextContains("true"), "Args.object is NOT correct.");
            Assert.assertNotNull(this.homePageExtended.find.byTextContains("states: began,changed,ended"), "States are NOT correct.");
        }
    }

    @Test(groups = {"android", "ios"})
    public void gestures_08_disconnectObserver() throws Exception {
        this.gesturesPage.navigateToGestures();
        UIElement tapElement = this.gesturesPage.lblTap();
        this.gesturesPage.tapStopBtn();
        Assert.assertNotNull(this.homePageExtended.find.byText("Gestures detection disabled"), "Failed to disable gestures observer.");

        tapElement.tap();
        Assert.assertNull(this.homePageExtended.find.byText("Tap gesture detected"), "Tap gesture detected while gestures observer is disabled");
    }

    @Test(groups = {"android", "ios"})
    public void gestures_09_binding() throws Exception {
        this.gesturesPage.navigateToHandlers();

        this.homePageExtended.find.byText("Handlers as exports").tap();
        if (this.settings.platformVersion < 11 && this.settings.platform == PlatformType.iOS) {
            this.assertScreen(5);
        } else {
            this.device.assertLogContains("tapAction");
        }
    }

    @Test(groups = {"ios"})
    public void gestures_10_swipeBackNavigation() throws Exception {
        this.gesturesPage.navigateToGestures();
        this.gesturesPage.wait.waitForVisible(this.locators.byText("Pan here", false, false), 4, true);
        this.app.slideBack();
        this.gesturesPage.wait.waitForVisible(this.locators.byText("gestures", false, false), 4, true);
    }
}
