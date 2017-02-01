package uitests.Screens.Bindings;

import functional.tests.core.basepage.BasePageExtended;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;

public class BindingsBasePage extends BasePageExtended {

    public static final String BINDINGS = "bindings";
    public BindingBasicsPage bindingBasicsPage;
    public BindingXmlBasicsPage bindingXmlBasicsPage;

    public BindingsBasePage(Context context) {
        super(BINDINGS, context);
        this.navigateToBindings();
        this.bindingBasicsPage = new BindingBasicsPage();
        this.bindingXmlBasicsPage = new BindingXmlBasicsPage(this);
    }

    private void navigateToBindings() {
        UIElement btnBindings = this.wait.waitForVisible(this.locators.byText(BINDINGS));
        this.navigateTo(btnBindings, this.mainPage);
    }
}