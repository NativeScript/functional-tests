package uitests.Screens.Bindings;

import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.find.Find;
import functional.tests.core.find.Locators;
import functional.tests.core.find.Wait;
import functional.tests.core.log.Log;
import functional.tests.core.settings.Settings;
import org.testng.Assert;

public class BindingXmlBasicsPage {

    private Find find;
    private Wait wait;
    private Settings settings;
    private Locators locators;
    private Log log;

    public BindingXmlBasicsPage(BindingsBasePage bindingsBasePage) {
        this.find = bindingsBasePage.find;
        this.wait = bindingsBasePage.wait;
        this.settings = bindingsBasePage.settings;
        this.locators = bindingsBasePage.locators;
        this.log = bindingsBasePage.log;
    }

    public UIElement btnText() {
        int buttonIndex = 0;
        if (this.settings.platform == PlatformType.iOS) {
            buttonIndex = 2;
        }
        return this.find.elementsByLocator(this.locators.buttonLocator()).get(buttonIndex);
    }

    public UIElement editTextField() {
        return this.find.byLocator(this.locators.editTextLocator());
    }

    public UIElement label() {
        return this.wait.waitForVisible(this.locators.byText("label", true, false), 6, true);
    }

    public UIElement button() {
        return this.find.byTextContains("button");
    }

    public UIElement label1() {
        //return this.find.byText("Label1");
        return this.find.byLocator(this.locators.byText("Label1", true, false));
    }

    public UIElement label2() {
        //return this.find.byText("Label2");
        return this.find.byLocator(this.locators.byText("Label2", true, false));
    }

    public void tapTextBtn() {
        this.btnText().click();
        this.log.info("Tap on 'Text' button.");
    }

    public void tapBtn() {
        this.button().click();
        this.log.info("Tap on 'Button' button.");
    }

    public void loaded() {
        if (this.label() != null) {
            Assert.assertNotNull(this.label1());
            Assert.assertNotNull(this.label2());
            this.log.info("BindingXmlBasics page loaded.");
        } else {
            Assert.fail("BindingXmlBasics page NOT loaded.");
        }
    }
}
