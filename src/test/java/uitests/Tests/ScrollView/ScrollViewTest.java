package uitests.Tests.ScrollView;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.enums.SwipeElementDirection;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.ScreenOrientation;
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
        this.compareScreens(10, 0.015);

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
        this.compareScreens(10, 0.015);

        this.assertImagesResults();
    }

    @Test(groups = {"ios"})
    public void safe_area_images() throws Exception {
        this.homePageExtended.navigateTo("safe-area-images");
        this.compareScreens(5);

        this.device.rotate(ScreenOrientation.LANDSCAPE);
        this.compareScreens(5);

        this.device.rotate(ScreenOrientation.PORTRAIT);

        this.homePageExtended.getNavigationManager().slideBack();

        this.assertImagesResults();
    }

    @Test(groups = {"ios"})
    public void safe_area_images_overflow() throws Exception {
        this.homePageExtended.navigateTo("safe-area-images-overflow");
        this.compareScreens(5);

        this.device.rotate(ScreenOrientation.LANDSCAPE);
        this.compareScreens(5);

        this.device.rotate(ScreenOrientation.PORTRAIT);

        this.homePageExtended.getNavigationManager().slideBack();

        this.assertImagesResults();
    }

    @Test(groups = {"ios"})
    public void safe_area_images_root_element() throws Exception {
        this.homePageExtended.navigateTo("safe-area-root-element");
        this.compareScreens(5);

        this.device.rotate(ScreenOrientation.LANDSCAPE);
        this.compareScreens(5);

        this.device.rotate(ScreenOrientation.PORTRAIT);

        this.homePageExtended.getNavigationManager().slideBack();

        this.assertImagesResults();
    }

    @Test(groups = {"ios"})
    public void safe_area_images_sub_element() throws Exception {
        this.homePageExtended.navigateTo("safe-area-sub-element");
        this.compareScreens(5);

        this.device.rotate(ScreenOrientation.LANDSCAPE);
        this.compareScreens(5);

        this.device.rotate(ScreenOrientation.PORTRAIT);

        this.homePageExtended.getNavigationManager().slideBack();

        this.assertImagesResults();
    }

    @Test(groups = {"ios"})
    public void layout_outside_scroll() throws Exception {
        this.homePageExtended.navigateTo("layout-outside-scroll");
        this.compareScreens(5);

        UIElement scrollToBottomBtn = this.context.find.byText("scrollToBottom");
        scrollToBottomBtn.tap();

        this.context.find.byText("changeVisibilityBottom");
        this.compareScreens(5);

        this.context.find.byText("scrollToTop");
        this.compareScreens(5);

        this.context.find.byText("changeVisibilityTop");
        this.compareScreens(5);

        scrollToBottomBtn.tap();
        this.compareScreens(5);

        this.context.find.byText("scrollToTop");
        this.compareScreens(5);

        this.assertImagesResults();

    }

    public void swipeToBottom(java.util.List<UIElement> elements, int index) {
        if ((this.settings.platform == PlatformType.Android) && (this.settings.platformVersion != 4.4)) {
            elements.get(index).findElement(this.locators.viewGroupLocator()).swipeInElement(SwipeElementDirection.UP, 100, 100);
        } else {
            elements.get(index).swipeInElement(SwipeElementDirection.DOWN, 700, 200);
        }
    }

    public void swipeToTop(java.util.List<UIElement> elements, int index) {
        if ((this.settings.platform == PlatformType.Android) && (this.settings.platformVersion != 4.4)) {
            elements.get(index).findElement(this.locators.viewGroupLocator()).swipeInElement(SwipeElementDirection.UP, 100, 100);
        } else {
            elements.get(index).swipeInElement(SwipeElementDirection.DOWN, 700, 200);
        }
    }
}
