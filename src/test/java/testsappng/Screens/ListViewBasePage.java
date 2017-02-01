package testsappng.Screens;

import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;


public class ListViewBasePage extends HomePage {
    public ListViewBasePage(String mainPage, Context context) {
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
