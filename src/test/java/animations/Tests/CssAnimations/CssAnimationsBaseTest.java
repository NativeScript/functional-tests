package animations.Tests.CssAnimations;

import animations.Screens.CssAnimationsPage;
import animations.Tests.AnimationsBaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class CssAnimationsBaseTest extends AnimationsBaseTest {

    private static final String cssAnimations = "css-animations";

    @BeforeClass(alwaysRun = true)
    public void beforeCssBaseTestClass() {
        this.cssAnimationsPage = new CssAnimationsPage(cssAnimations, this.context);
    }

    @BeforeMethod
    public void beforeMethod() throws Exception {
        if (this.cssAnimationsPage.loaded() == false) {
            this.cssAnimationsPage.navigateTo("css-animations");
        }
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        cssAnimationsPage.navigateBack();
    }
}
