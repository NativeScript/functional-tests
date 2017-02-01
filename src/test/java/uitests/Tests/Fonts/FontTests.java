package uitests.Tests.Fonts;

import functional.tests.core.basetest.UIBaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.Fonts.FontPage;

public class FontTests extends UIBaseTest {
    protected FontPage fontPage;

    protected void waitForScreen(double tolerance) throws Exception {
        this.compareScreens(10, tolerance);
    }

    @BeforeClass(alwaysRun = true)
    public void beforeFontsTestsSuit() {
        this.fontPage = new FontPage("fonts", this.context);
    }

    // Button
    @Test(groups = {"android", "ios"})
    public void font_11_button() throws Exception {
        this.fontPage.navigateTo("fontbtn");
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void font_12_buttonClean() throws Exception {
        this.fontPage.tapResetBtn();
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    // Label
    @Test(groups = {"android", "ios"})
    public void font_21_label() throws Exception {
        this.fontPage.navigateTo("fontlbl");
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void font_22_labelClean() throws Exception {
        this.fontPage.tapResetBtn();
        this.waitForScreen(0.1);

        this.assertImagesResults();
    }

    // TextField
    @Test(groups = {"android", "ios"})
    public void font_31_textField() throws Exception {
        this.fontPage.navigateTo("fontfield");
        this.waitForScreen(0.5);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void font_32_textFieldClean() throws Exception {
        this.fontPage.tapResetBtn();
        this.waitForScreen(0.30);

        this.assertImagesResults();
    }

    // TextView
    @Test(groups = {"android", "ios"})
    public void font_41_textView() throws Exception {
        this.fontPage.navigateTo("fontview");
        this.waitForScreen(0.31);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void font_42_textViewClean() throws Exception {
        this.fontPage.tapResetBtn();
        this.waitForScreen(0.5);

        this.assertImagesResults();
    }
}
