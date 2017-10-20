package uitests.Screens.Bindings;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.basetest.MobileSetupManager;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class BindingXmlBasicsPage {

    private MobileContext context;

    public BindingXmlBasicsPage() {
        this.context = MobileSetupManager.getTestSetupManager().getContext();
    }

    public UIElement btnText() {
        int buttonIndex = 0;
        if (this.context.settings.platform == PlatformType.iOS && this.context.settings.platformVersion <= 10) {
            buttonIndex = 2;
        } else {
            buttonIndex = 1;
        }
        return this.context.find.elementsByLocator(this.context.locators.buttonLocator()).get(buttonIndex);
    }

    public UIElement editTextField() {
        return this.context.find.byLocator(this.context.locators.editTextLocator());
    }

    public UIElement label() {
        return this.context.wait.waitForVisible(this.context.locators.byText("label", true, false), 6, true);
    }

    public UIElement button() {
        return this.context.find.byTextContains("button");
    }

    public UIElement label1() {
        //return this.find.byText("Label1");
        return this.context.find.byLocator(this.context.locators.byText("Label1", true, false));
    }

    public UIElement label2() {
        //return this.find.byText("Label2");
        return this.context.find.byLocator(this.context.locators.byText("Label2", true, false));
    }

    public void tapTextBtn() {
        this.btnText().click();
        this.context.log.info("Tap on 'Text' button.");
    }

    public void tapBtn() {
        this.button().click();
        this.context.log.info("Tap on 'Button' button.");
    }

    public void loaded() {
        if (this.label() != null) {
            Assert.assertNotNull(this.label1());
            Assert.assertNotNull(this.label2());
            this.context.log.info("BindingXmlBasics page loaded.");
        } else {
            Assert.fail("BindingXmlBasics page NOT loaded.");
        }
    }
}
