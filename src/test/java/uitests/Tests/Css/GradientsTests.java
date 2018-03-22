package uitests.Tests.Css;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GradientsTests extends CssBaseTest {

    private int compareScreens = 10;

    @BeforeClass(alwaysRun = true)
    public void beforeGradientsTestsClass() {
    }

    @Test(groups = {"android", "ios"})
    public void gradientBorderTest() throws Exception {
        this.cssBasePage.navigateTo("gradient-border");
    }
}
