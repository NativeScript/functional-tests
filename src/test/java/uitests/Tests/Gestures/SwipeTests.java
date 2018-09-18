package uitests.Tests.Gestures;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.enums.SwipeElementDirection;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwipeTests extends GesturesBaseTest {

    @BeforeClass(alwaysRun = true)
    public void beforeGesturesTestsClass() {
        this.homePageExtended.navigateTo("swipe-passtrough");
    }

    @Test(groups = {"android", "ios"})
    public void swipe_event_passtrough_test() {
        UIElement stack = this.wait.waitForVisible(this.locators.byText("swipeHere"));

        int waitAfterSwipe = 500;
        if (this.settings.platform == PlatformType.Android) {
            stack.swipeInElement(SwipeElementDirection.LEFT, 200, waitAfterSwipe);
            stack.swipeInElement(SwipeElementDirection.DOWN, 250, waitAfterSwipe);
        } else {
            stack.scrollInElement(SwipeElementDirection.LEFT, waitAfterSwipe);
            stack.scrollInElement(SwipeElementDirection.DOWN, waitAfterSwipe);
        }

        stack.tap();

        UIElement output = this.wait.waitForVisible(this.locators.labelLocator());
        String outputText = output.getText();

        String format = "swipe state:%d";
        Assert.assertNotNull(outputText.contains(String.format(format, 2)), "Swipe gesture NOT detected.");
        Assert.assertNotNull(outputText.contains(String.format(format, 4)), "Swipe gesture NOT detected.");
        Assert.assertNotNull(outputText.contains("tapEvent triggered"), "Swipe gesture NOT detected.");
    }
}
