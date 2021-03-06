package uitests.Tests.Css;

import org.testng.annotations.Test;

public class LineHeightTests extends CssBaseTest {

    @Test(groups = {"android", "ios"})
    public void lineHeight_01() throws Exception {
        this.cssBasePage.navigateTo("line-height");
        this.compareScreens(5);
        this.cssBasePage.tapChangeBtn();
        this.compareScreens(5);
        this.cssBasePage.tapChangeBtn();
        this.compareScreens(5);
        this.assertImagesResults();
    }
}
