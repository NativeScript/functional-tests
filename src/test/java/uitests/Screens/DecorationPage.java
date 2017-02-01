package uitests.Screens;

import functional.tests.core.element.UIElement;
import functional.tests.core.find.Find;
import org.testng.Assert;
import uitests.Screens.Css.CssBasePage;

public class DecorationPage {
    public CssBasePage cssBasePage;
    private Find find;

    public DecorationPage(CssBasePage cssBasePage) {
        this.cssBasePage = cssBasePage;
        this.cssBasePage.navigateTo("decoration");
        this.find = cssBasePage.find;
        this.loaded();
    }

    private UIElement btnChange() {
        return this.find.byText("Change");
    }

    public void tapChangeBtn() {
        this.btnChange().click();
        this.cssBasePage.log.info("Tap on 'Change' button.");
    }

    public void loaded() {
        if (this.btnChange() != null) {
            this.cssBasePage.log.info("Decoration page loaded.");
        } else {
            Assert.fail("Decoration page NOT loaded.");
        }
    }
}
