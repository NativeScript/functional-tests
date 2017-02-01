package animations.Screens;

import functional.tests.core.basepage.BasePageExtended;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import functional.tests.core.exceptions.AppiumException;
import functional.tests.core.find.Find;

public class CssAnimationsPage extends BasePageExtended {

    private Find find;

    // NOTE: This is a workaround.
    // There is an issue that navigating by HomePage.navigateTo()
    // does not work on API24 due to the navigateToMainPage() call,
    // which misteriously does not cause problems on the rest API levels.
    // TODO: Think about restructuring of the app and/or a better abstraction.
    public CssAnimationsPage(HomePage homePage, Context context) {
        super(context);
        this.find = homePage.find;

    }

    private UIElement btnBounce() {
        return this.find.byText("bounce");
    }

    public UIElement btnInitialAnimation() {
        return this.find.byText("Initial Animation");
    }

    public Boolean loaded() throws AppiumException {
        if (this.btnBounce() != null) {
            this.log.info("Css Animations SdkPage loaded.");
            return true;
        } else {
            this.log.error("Css Animations SdkPage NOT loaded.");
            return false;
        }
    }
}