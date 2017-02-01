package uitests.Tests.TabView;

import functional.tests.core.basetest.UIBaseTest;
import functional.tests.core.enums.PlatformType;
import org.testng.annotations.BeforeClass;
import uitests.Screens.HomePageExtended;

public class TabViewBaseTest extends UIBaseTest {
    protected HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeTabViewBaseTestClass() {
        String tabView = "tab-view";
        if (this.settings.platform == PlatformType.Andorid && this.settings.platformVersion >= 7) {
            tabView = "TAB-VIEW";
        }

        this.homePageExtended = new HomePageExtended(tabView, this.context);
    }
}
