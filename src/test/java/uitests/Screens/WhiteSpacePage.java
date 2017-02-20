package uitests.Screens;

import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.find.Find;
import functional.tests.core.mobile.find.Locators;
import org.testng.Assert;
import uitests.Screens.Css.CssBasePage;

public class WhiteSpacePage {
    private CssBasePage cssBasePage;
    private Find find;

    public WhiteSpacePage(CssBasePage cssBasePage) {
        this.cssBasePage = cssBasePage;
        this.find = this.cssBasePage.find;
        this.cssBasePage.navigateTo("whitespace");
    }

    private UIElement btnChange() {
        return this.find.byText("Change");
    }

    public UIElement stackLayout() {
        if (this.cssBasePage.settings.platform == PlatformType.Android) {
            return this.find.getParent(this.btnChange());
        } else {
            return this.find.byLocator(this.cssBasePage.locators.scrollViewLocator());
        }
    }

    public void tapChangeBtn() {
        this.btnChange().click();
        cssBasePage.log.info("Tap on 'Change' button.");
    }

    public void loaded() {
        if (this.btnChange() != null) {
            cssBasePage.log.info("WhiteSpace page loaded.");
        } else {
            Assert.fail("WhiteSpace page NOT loaded.");
        }
    }
}
