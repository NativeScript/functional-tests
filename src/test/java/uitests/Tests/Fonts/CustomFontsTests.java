package uitests.Tests.Fonts;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.CustomFontsPage;

public class CustomFontsTests extends MobileTest {
    protected CustomFontsPage customFontsPage;

    protected void waitForScreen(double tolerance) throws Exception {
        this.compareScreens(5, tolerance);
    }

    @BeforeClass(alwaysRun = true)
    public void beforeCustomTestsClass() {
        this.customFontsPage = new CustomFontsPage("fonts", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void fonts_01_custom() throws Exception {
        this.customFontsPage.navigateTo("customfonts");
        this.compareScreens(5, 0.5);

        this.assertImagesResults();

        this.customFontsPage.navigateBack();
    }
}
