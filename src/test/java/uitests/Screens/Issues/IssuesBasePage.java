package uitests.Screens.Issues;

import functional.tests.core.basetest.Context;
import uitests.Screens.HomePageExtended;

public class IssuesBasePage extends HomePageExtended {

    public IssuesBasePage(Context context) {
        super("issues", context);
    }

    public boolean navToPage(String page) {
        this.navigateToMainPage();
        this.wait.waitForNotVisible(this.locators.byText(page, true, false), 6, false);
        boolean result = this.navigateTo(page);

        return result;
    }
}
