package uitests.Tests.TabView;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.BeforeClass;
import uitests.Screens.HomePageExtended;

public class TabViewBaseTest extends MobileTest {
    protected HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeTabViewBaseTestClass() {
        String tabView = "tab-view";
        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion >= 7) {
            tabView = "TAB-VIEW";
        }

        this.homePageExtended = new HomePageExtended(tabView, this.context);
    }
}
