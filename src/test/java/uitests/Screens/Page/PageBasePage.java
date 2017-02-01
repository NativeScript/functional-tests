package uitests.Screens.Page;

import functional.tests.core.basetest.Context;
import uitests.Screens.HomePageExtended;

public class PageBasePage extends HomePageExtended {

    public PageBasePage(Context context) {
        super("page", context);
    }

    public PageBasePage(String page, Context context) {
        this(context);
        this.navigateTo(page);
    }
}
