package uitests.Screens.Issues;

import functional.tests.core.mobile.basetest.MobileContext;
import uitests.Screens.HomePageExtended;

public class IssuesBasePage extends HomePageExtended {

    public IssuesBasePage(MobileContext context) {
        super("issues", context);
    }

    public boolean navToPage(String page) {
        this.navigateToMainPage();
        this.wait.waitForNotVisible(this.locators.byText(page, true, false), 6, false);
        boolean result = this.navigateTo(page);

        return result;
    }
}
