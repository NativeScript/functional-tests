package uitests.Screens.Page;

import functional.tests.core.mobile.basetest.MobileContext;
import uitests.Screens.HomePageExtended;

public class PageBasePage extends HomePageExtended {

    public PageBasePage(MobileContext context) {
        super("page", context);
    }

    public PageBasePage(String page, MobileContext context) {
        this(context);
        this.navigateTo(page);
    }
}
