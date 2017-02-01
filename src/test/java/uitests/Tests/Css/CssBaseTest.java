package uitests.Tests.Css;

import org.testng.annotations.BeforeClass;
import uitests.Screens.Css.CssBasePage;
import uitests.Tests.UIBaseTests;

public class CssBaseTest extends UIBaseTests {

    public CssBasePage cssBasePage;

    @BeforeClass(alwaysRun = true)
    public void beforeCssBaseTestClass() {
        this.cssBasePage = new CssBasePage(this.context);
    }
}
