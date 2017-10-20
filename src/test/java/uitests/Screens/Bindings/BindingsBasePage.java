package uitests.Screens.Bindings;

import functional.tests.core.mobile.basepage.BasePageExtended;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;

public class BindingsBasePage extends BasePageExtended {

    public static final String BINDINGS = "bindings";
    public BindingBasicsPage bindingBasicsPage;
    public BindingXmlBasicsPage bindingXmlBasicsPage;

    public BindingsBasePage(MobileContext context) {
        super(BINDINGS, context);
        this.navigateToBindings();
        this.bindingBasicsPage = new BindingBasicsPage();
        this.bindingXmlBasicsPage = new BindingXmlBasicsPage();
    }

    private void navigateToBindings() {
        UIElement btnBindings = this.wait.waitForVisible(this.locators.byText(BINDINGS));
        this.navigateTo(btnBindings, this.mainPage);
    }
}