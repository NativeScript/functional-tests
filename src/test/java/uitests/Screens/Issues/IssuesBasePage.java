package uitests.Screens.Issues;

import functional.tests.core.mobile.basetest.MobileContext;
import org.testng.Assert;
import uitests.Screens.HomePageExtended;

public class IssuesBasePage extends HomePageExtended {

    public IssuesBasePage(MobileContext context) {
        super("issues", context);
    }

    public void navToPage(String page) {
        this.navigateToMainPage();
        boolean result = this.navigateTo(page);
        Assert.assertTrue(result, "Failed to navigate to " + page);
    }
}
