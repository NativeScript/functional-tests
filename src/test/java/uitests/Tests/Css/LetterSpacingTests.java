package uitests.Tests.Css;

import functional.tests.core.enums.PlatformType;
import org.testng.annotations.Test;

public class LetterSpacingTests extends CssBaseTest {

    @Test(groups = {"android", "ios"})
    public void letterSpacing_01() throws Exception {
            this.cssBasePage.navigateTo("spacing");
            this.compareScreens(10);
            this.assertImagesResults();
    }
}
