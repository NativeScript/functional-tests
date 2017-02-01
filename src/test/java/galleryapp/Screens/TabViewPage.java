package galleryapp.Screens;

import functional.tests.core.basetest.Context;
import functional.tests.core.basetest.TestContextSetupManager;
import functional.tests.core.element.UIElement;
import functional.tests.core.find.Find;
import functional.tests.core.log.Log;
import org.testng.Assert;

public class TabViewPage {
    private Find find;
    private Log log;

    public TabViewPage() {
        Context tc = TestContextSetupManager.getTestSetupManager().context;
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
