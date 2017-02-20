package uitests.Tests.Component;

import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.Bindings.BindingsBasePage;

public class BindingTests extends MobileTest {

    private BindingsBasePage bindingsBasePage;

    @BeforeClass(alwaysRun = true)
    public void beforeTransformTestsClass() {
        this.bindingsBasePage = new BindingsBasePage(this.context);
    }

    @Test(groups = {"android", "ios"})
    public void binding_01_basics() throws Exception {
        UIElement btnBasics = this.bindingsBasePage.wait.waitForVisible(this.locators.byText("basics"));
        this.bindingsBasePage.navigateTo(btnBasics, "basics");
        this.bindingsBasePage.bindingBasicsPage.loaded();
        this.bindingsBasePage.bindingBasicsPage.tapSetTextBtn();

        this.bindingsBasePage.bindingBasicsPage.tapOneWayBtn();
        Assert.assertEquals(this.bindingsBasePage.bindingBasicsPage.editTextFieldOneWay().getText(), "Test");
        Assert.assertEquals(this.bindingsBasePage.bindingBasicsPage.btnOneWay().getText().toLowerCase(), "oneway");

        this.bindingsBasePage.bindingBasicsPage.tapTwoWayBtn();
        Assert.assertEquals(this.bindingsBasePage.bindingBasicsPage.editTextFieldTwoWay().getText(), "Test");
        Assert.assertEquals(this.bindingsBasePage.bindingBasicsPage.btnTwoWay().getText().toLowerCase(), "test");
    }

    @Test(groups = {"android", "ios"})
    public void binding_02_xmlBasics() throws Exception {
        this.bindingsBasePage.navigateToMainPage();
        UIElement element = this.find.byTextContains("xmlbasics");
        this.bindingsBasePage.navigateTo(element);
        this.bindingsBasePage.bindingXmlBasicsPage.loaded();

        Assert.assertEquals(this.bindingsBasePage.bindingXmlBasicsPage.editTextField().getText(), "Text");
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion >= 10) {
            Assert.assertEquals(this.bindingsBasePage.bindingXmlBasicsPage.btnText().getText(), null);
        } else {
            Assert.assertEquals(this.bindingsBasePage.bindingXmlBasicsPage.btnText().getText(), "");
        }
        this.bindingsBasePage.bindingXmlBasicsPage.tapTextBtn();
        Assert.assertEquals(this.bindingsBasePage.bindingXmlBasicsPage.btnText().getText().toLowerCase(), "text");

        this.bindingsBasePage.bindingXmlBasicsPage.tapBtn();
        this.device.assertLogContains("### onTap event ###");
    }
}
