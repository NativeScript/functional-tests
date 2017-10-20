package uitests.Tests.Events;

import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.find.Wait;
import org.testng.annotations.Test;

public class TouchTests extends GesturesBaseTest {

    @Test(groups = {"android", "ios"})
    public void touch_01_pinch() throws Exception {
        if (this.settings.platformVersion != 4.2
                && !(this.settings.platform == PlatformType.iOS && this.settings.platformVersion >= 10)) {
            this.homePageExtended.navigateTo("touch");

            this.testElement().pinch();
            this.log.info("Before Wait.");
            Wait.sleep(2000);
            this.log.info("After Wait.");
            this.device.assertLogContains("touch action: down");
            this.device.assertLogContains("count: 2 ACTIVE:  p0");
            this.device.assertLogContains("ALL:  p0");
            this.device.assertLogContains("p1");
            this.device.assertLogContains("touch action: move");
            this.device.assertLogContains("touch action: up");
        }
    }

    public UIElement testElement() {
//        if (this.settings.platform == PlatformType.Android) {
//            return this.homePageExtended.find.elementsByLocator(Locators.viewGroupLocator()).get(4);
//        } else if (this.settings.platform == PlatformType.iOS) {
        return this.homePageExtended.find.byText("target");
//        } else {
//            return null;
//        }
    }
}
