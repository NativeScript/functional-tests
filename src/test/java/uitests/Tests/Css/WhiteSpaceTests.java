package uitests.Tests.Css;

import functional.tests.core.enums.PlatformType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.WhiteSpacePage;

public class WhiteSpaceTests extends CssBaseTest {

    private WhiteSpacePage whiteSpacePage;

    @BeforeClass(alwaysRun = true)
    public void beforeWhiteSpaceTestsClass() {
        this.whiteSpacePage = new WhiteSpacePage(this.cssBasePage);
    }

    @Test(groups = {"android", "ios"})
    public void whiteSpace_01_normal() throws Exception {
        if (this.settings.platform == PlatformType.Android) {
            this.compareElements(this.whiteSpacePage.stackLayout(), 2, 3.0);
        } else {
            this.compareElements(this.whiteSpacePage.stackLayout(), 2, 0.2);
        }
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void whiteSpace_02_nowrap() throws Exception {
        this.whiteSpacePage.tapChangeBtn();
        if (this.settings.platform == PlatformType.Android) {
            this.compareElements(this.whiteSpacePage.stackLayout(), 3, 1.0);
        } else {
            this.compareElements(this.whiteSpacePage.stackLayout(), 3, 0.2);
        }
        this.assertImagesResults();
    }
}
