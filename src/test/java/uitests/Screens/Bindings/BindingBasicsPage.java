package uitests.Screens.Bindings;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.basetest.MobileSetupManager;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import org.testng.Assert;

public class BindingBasicsPage {
    private MobileContext context;

    public BindingBasicsPage() {
        this.context = MobileSetupManager.getTestSetupManager().getContext();
    }

    public UIElement btnSetText() {
        int buttonIndex = 0;
        if (this.context.settings.platform == PlatformType.iOS) {
            buttonIndex = 2;
        }
        return this.context.find.elementsByLocator(this.context.locators.buttonLocator()).get(buttonIndex);
    }

    public UIElement editTextFieldOneWay() {
        int buttonIndex = 0;
        return this.context.find.elementsByLocator(this.context.locators.editTextLocator()).get(buttonIndex);
    }

    public UIElement btnOneWay() {
        int buttonIndex = 1;
        if (this.context.settings.platform == PlatformType.iOS) {
            buttonIndex = 3;
            if (this.context.settings.platformVersion>=11){
                buttonIndex =2;
            }
        }
        return this.context.find.elementsByLocator(this.context.locators.buttonLocator()).get(buttonIndex);
    }

    public UIElement editTextFieldTwoWay() {
        int buttonIndex = 1;
        return this.context.find.elementsByLocator(this.context.locators.editTextLocator()).get(buttonIndex);
    }

    public UIElement btnTwoWay() {
        int buttonIndex = 2;
        if (this.context.settings.platform == PlatformType.iOS) {
            buttonIndex = 4;
            if (this.context.settings.platformVersion>=11){
                buttonIndex =3;
            }
        }
        return this.context.find.elementsByLocator(this.context.locators.buttonLocator()).get(buttonIndex);
    }

    public void tapSetTextBtn() {
        this.btnSetText().click();
    }

    public void tapOneWayBtn() {
        this.btnOneWay().click();
    }

    public void tapTwoWayBtn() {
        this.btnTwoWay().click();
    }

    public void loaded() {
        if (btnSetText() != null) {
           this.context.log.info("BindingBasics page loaded.");
        } else {
            Assert.fail("BindingBasics page NOT loaded.");
        }
        Assert.assertEquals(this.editTextFieldOneWay().getText(), "OneWay");
        Assert.assertEquals(this.btnOneWay().getText().toLowerCase(), "oneway");
        Assert.assertEquals(this.editTextFieldTwoWay().getText(), "TwoWay");
        Assert.assertEquals(this.btnTwoWay().getText().toLowerCase(), "twoway");
    }
}
