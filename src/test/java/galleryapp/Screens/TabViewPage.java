package galleryapp.Screens;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Find;
import functional.tests.core.log.Log;
import functional.tests.core.mobile.basetest.MobileSetupManager;
import org.testng.Assert;

public class TabViewPage {
    private Find find;
    private Log log;

    public TabViewPage() {
        MobileContext tc = MobileSetupManager.getTestSetupManager().getContext();
        this.find = tc.find;
        this.log = tc.log;
    }

    private UIElement firstTab() {
        return this.find.byText("First");
    }

    private UIElement secondTab() {
        return this.find.byText("Second");
    }

    public void tapFirstTab() {
        firstTab().tap();
    }

    public void tapSecondTab() {
        secondTab().tap();
    }

    public void loaded() {
        firstTab();
        if (firstTab() != null) {
            this.log.info("TabView page loaded.");
        } else {
            Assert.fail("TabView page NOT loaded.");
        }
    }
}
