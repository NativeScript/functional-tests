package uitests.Screens.Css;

import functional.tests.core.basetest.Context;
import uitests.Screens.HomePageExtended;

public class CssBasePage extends HomePageExtended {

    public CssBasePage(Context context) {
        super("css", context);
    }

    public boolean navToPage(String page) {
        boolean result = this.navigateTo(page);
        this.wait.waitForNotVisible(this.locators.byText(page, true, false), 6, false);

        return result;
    }
}
