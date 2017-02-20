package uitests.Screens.Fonts;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;
import uitests.Screens.HomePageExtended;

public class FontPage extends HomePageExtended {

    public FontPage(String example, MobileContext context) {
        super(example, context);
        this.basePageLoaded();
    }

    public void basePageLoaded() {
        UIElement element = this.find.byText("fontbtn", 3);
        if (element == null) {
            Assert.assertTrue(false, "FontPage is not loaded");
        }
    }

    private UIElement btnReset() {
        return this.find.byText("RESET");
    }

    public void tapResetBtn() {
        this.btnReset().click();
        this.log.info("Tap on 'RESET' button.");
    }

    public void loaded() {
        if (this.btnReset() != null) {
            this.log.info("Font page loaded.");
        } else {
            Assert.fail("Font page NOT loaded.");
        }
    }
}
