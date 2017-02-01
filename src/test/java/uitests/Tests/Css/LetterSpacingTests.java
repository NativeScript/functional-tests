package uitests.Tests.Css;

import functional.tests.core.enums.PlatformType;
import org.testng.annotations.Test;

public class LetterSpacingTests extends CssBaseTest {

    @Test(groups = {"android", "ios"})
    public void letterSpacing_01() throws Exception {
        if (this.settings.platform == PlatformType.Andorid && this.settings.platformVersion < 5) {
           this.log.info("Letter-spacing for Android is supported on API level >= 21.");
        } else {
            this.cssBasePage.navigateTo("spacing");
            this.compareScreens(10, 0.5);
            this.assertImagesResults();
        }
    }
}
