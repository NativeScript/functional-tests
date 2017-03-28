package uitests.Tests.Css;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.extensions.ScrollableListObject;
import io.appium.java_client.SwipeElementDirection;
import org.testng.annotations.Test;

public class ListViewTests extends CssBaseTest {

    @Test(groups = {"android", "ios"})
    public void cssListView_01() throws Exception {
        this.cssBasePage.navigateTo("csslv");
        this.compareScreens(this.settings.defaultTimeout, 0.25);

        if (this.settings.platform == PlatformType.Android) {
            ScrollableListObject scrollableListObject = new ScrollableListObject(this.context) {
                @Override
                public String getMainContainerLocatorName() {
                    return context.uiElementClass.listViewLocator();
                }

                @Override
                public String getMainContainerItemsName() {
                    if (settings.platform == PlatformType.Android) {
                        return context.uiElementClass.textViewLocator();
                    } else {
                        return context.uiElementClass.cellLocator();
                    }
                }
            };

            scrollableListObject.scrollTo("NAME99");
        } else {
            this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 10);
            this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 10);
            this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 10);
            this.context.gestures.swipeInWindow(SwipeElementDirection.DOWN, 700, 10);
        }

        double tolerance = 0.28d;
        if (this.settings.platform == PlatformType.iOS) {
            tolerance = 0.40d;
        }
        this.assertScreen(2, tolerance);
    }

    @Test(groups = {"android", "ios"})
    public void listview_bg_separator_color_3233_3574() throws Exception {
        this.cssBasePage.navigateTo("listview_bg_separator_color");
        this.assertScreen(this.settings.defaultTimeout);
    }
}
