package uitests.Tests.Fonts;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import uitests.Screens.Fonts.FontPage;

public class AwesomeFontTest extends MobileTest {
    protected FontPage fontPage;

    @BeforeClass(alwaysRun = true)
    public void beforeAwesomeFontTestClass() {
        this.fontPage = new FontPage("fonts", this.context);
        this.fontPage.navigateTo("awesome-3654");
    }

    @Ignore("Ignore because of issue in slideBack()")
    @Test(groups = {"android", "ios"})
    public void fonts_01_awesomefont_3654() throws Exception {
        this.compareScreens(10);
        this.fontPage.navigateTo(this.fontPage.find.byLocator(
                this.locators.byText("font-awesome", false, false)));
        if (this.settings.platform == PlatformType.iOS) {
            this.fontPage.getNavigationManager().slideBack();
        } else {
            this.fontPage.navigateBack();
        }

        this.compareScreens(10);

        this.assertImagesResults();
    }
}
