package uitests.Tests.ScrollView;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.SwipeElementDirection;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

public class ScrollViewTest extends UIBaseTests {

    public HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeScrollViewTestClass() {
        this.homePageExtended = new HomePageExtended("scroll-view", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void scrolling_and_sizing_test() throws Exception {
        this.homePageExtended.navigateTo("scrolling-and-sizing");
        this.compareScreens(5);
        java.util.List<UIElement> elements = this.find.elementsByLocator(this.locators.scrollViewLocator());

        this.swipeToBottom(elements, 0);
        this.swipeToBottom(elements, 0);
        this.swipeToBottom(elements, 1);
        this.swipeToBottom(elements, 1);
        this.swipeToBottom(elements, 2);
        this.swipeToBottom(elements, 2);
        this.swipeToBottom(elements, 3);
        this.swipeToBottom(elements, 3);
        this.swipeToBottom(elements, 4);
        this.swipeToBottom(elements, 4);
        this.compareScreens(5);

        this.swipeToTop(elements, 0);
        this.swipeToTop(elements, 0);
        this.swipeToTop(elements, 1);
        this.swipeToTop(elements, 1);
        this.swipeToTop(elements, 2);
        this.swipeToTop(elements, 2);
        this.swipeToTop(elements, 3);
        this.swipeToTop(elements, 3);
        this.swipeToTop(elements, 4);
        this.swipeToTop(elements, 4);
        this.compareScreens(5);

        this.assertImagesResults();
    }

    public void swipeToBottom(java.util.List<UIElement> elements, int index) {
        if (this.settings.platform == PlatformType.Android) {
            elements.get(index).findElement(this.locators.viewGroupLocator()).swipeInElement(SwipeElementDirection.UP, 100, 100);
        } else {
            elements.get(index).swipeInElement(SwipeElementDirection.DOWN, 700, 200);
        }
    }

    public void swipeToTop(java.util.List<UIElement> elements, int index) {
        if (this.settings.platform == PlatformType.Android) {
            elements.get(index).findElement(this.locators.viewGroupLocator()).swipeInElement(SwipeElementDirection.UP, 100, 100);
        } else {
            elements.get(index).swipeInElement(SwipeElementDirection.DOWN, 700, 200);

        }
    }
}
