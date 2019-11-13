package uitests.Tests.Layouts;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.BeforeClass;
import uitests.Screens.Layouts.LayoutsPage;

public class LayoutBaseTest extends MobileTest {
    LayoutsPage layoutsPage;

    void waitForScreen(double tolerance) throws Exception {
        this.compareScreens(this.settings.shortTimeout, tolerance);
    }

    @BeforeClass(alwaysRun = true)
    public void beforeLayoutsTestsClass() {
        this.layoutsPage = new LayoutsPage("layouts", this.context);
    }
}
