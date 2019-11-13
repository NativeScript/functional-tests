package uitests.Tests.Css;

import functional.tests.core.enums.PlatformType;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
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
