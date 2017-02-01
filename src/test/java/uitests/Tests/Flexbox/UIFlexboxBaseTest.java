package uitests.Tests.Flexbox;

import org.testng.annotations.BeforeClass;
import uitests.Screens.FlexboxPage;
import uitests.Tests.UIBaseTests;

public class UIFlexboxBaseTest extends UIBaseTests {

    protected FlexboxPage pageFlexbox;
    protected String page = "flexbox";
    protected final double DEFAULT_TOLERANCE = 0.11d;

    protected void waitForElement() throws Exception {
        this.compareElements(this.pageFlexbox.container(), this.settings.shortTimeout);
    }

    protected void waitForScreen() throws Exception {
        this.compareScreens(this.settings.shortTimeout);
    }

    protected void waitForScreen(double tolerance) throws Exception {
        this.compareScreens(this.settings.shortTimeout, tolerance);
    }

    @BeforeClass(alwaysRun = true)
    public void beforeFlexboxTestsClass() {
        this.pageFlexbox = new FlexboxPage(this.page, this.context);
    }
}
