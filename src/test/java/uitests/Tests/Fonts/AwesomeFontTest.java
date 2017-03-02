package uitests.Tests.Fonts;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.Fonts.FontPage;

public class AwesomeFontTest extends MobileTest {
    protected FontPage fontPage;

    @BeforeClass(alwaysRun = true)
    public void beforeAwesomeFontTestClass() {
        this.fontPage = new FontPage("fonts", this.context);
        this.fontPage.navigateTo("awesome-3654");
        this.fontPage.context.navigationManager.setMainPage("awesome-3654");
        this.fontPage.context.navigationManager.setCurrentPage("awesome-3654");
    }


    @Test(groups = {"android", "ios"})
    public void fonts_01_awesomefont_3654() throws Exception {
        this.compareScreens(3);
        this.fontPage.find.byLocator(this.locators.byText("font-awesome", false, false)).tap();
        if (this.settings.platform == PlatformType.iOS) {
            this.app.slideBack();
        } else {
            this.fontPage.navigateBack();
        }

        this.compareScreens(3);

        this.assertImagesResults();
    }
}
