package uitests.Screens;

import functional.tests.core.element.UIElement;
import functional.tests.core.find.Find;
import functional.tests.core.find.Wait;
import org.testng.Assert;

public class GesturesPage {
    private Find find;
    private HomePageExtended homePageExtended;
    public Wait wait;

    public GesturesPage(HomePageExtended homePageExtended) {
        this.find = homePageExtended.find;
        this.wait = homePageExtended.wait;
        this.homePageExtended = homePageExtended;
    }

    public void navigateToGestures() {
        this.homePageExtended.navigateTo("gestures");
        this.loaded();
    }

    public void navigateToHandlers() {
        this.homePageExtended.navigateTo("handlers");
    }

    public UIElement btnStop() {
        return this.find.byText("Stop Detecting Gestures");
    }

    public UIElement lblTap() {
        return this.find.byText("Tap here");
    }

    public UIElement lblDoubleTap() {
        return this.find.byText("Double Tap here");
    }

    public UIElement lblLongPress() {
        return this.find.byText("Long Press here");
    }

    public UIElement lblSwipe() {
        return this.find.byText("Swipe here");
    }

    public UIElement lblPan() {
        return this.find.byText("Pan here");
    }

    public UIElement lblPinch() {
        return this.find.byText("Pinch here");
    }

    public UIElement lblRotate() {
        return this.find.byText("Rotate here");
    }

    public void tapStopBtn() {
        this.btnStop().click();
        this.homePageExtended.log.info("Tap on 'stop' button.");
    }

    public void loaded() {
        if (this.btnStop() != null) {
            this.homePageExtended.log.info("Gestures page loaded.");
        } else {
            Assert.fail("Gestures page NOT loaded.");
        }
    }
}
