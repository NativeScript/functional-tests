package testsappng.Screens;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;


public class ListViewBasePage extends HomePage {
    public ListViewBasePage(String mainPage, MobileContext context) {
        super(mainPage, context);
        this.setMainPage(mainPage);
        this.context.navigationManager.setScrollToElementRetriesCount(0);
    }

    public UIElement mainElement() {
        return this.find.byTextContains("mainView");
    }

    public UIElement findElementByTextContent(String text) {
        return this.find.byText(text);
    }
}
