package uitests.Tests.Layouts;

import functional.tests.core.basetest.UIBaseTest;
import org.testng.annotations.BeforeClass;
import uitests.Screens.Layouts.LayoutsPage;

//@Listeners(ExecutionOrder.class)
public class LayoutBaseTest extends UIBaseTest {
    protected LayoutsPage layoutsPage;

    protected void waitForScreen(double tolerance) throws Exception {
        this.compareScreens(this.settings.shortTimeout, tolerance);
    }

    @BeforeClass(alwaysRun = true)
    public void beforeLayoutsTestsClass() {
        this.layoutsPage = new LayoutsPage("layouts", this.context);
    }
}
