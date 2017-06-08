package uitests.Tests.Button;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.BeforeClass;
import uitests.Screens.HomePageExtended;

public class ButtonBaseTest extends MobileTest {

    protected final int compareScreens = 5;
    protected HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeButtonBaseTestClass() {
        this.homePageExtended = new HomePageExtended("button", this.context);
    }

}
