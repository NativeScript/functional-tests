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
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 11) {
            return;
        }
        UIElement btnBasics = this.bindingsBasePage.wait.waitForVisible(this.locators.byText("basics"));
        this.bindingsBasePage.navigateTo(btnBasics, "basics");
        this.bindingsBasePage.bindingBasicsPage.tapSetTextBtn();

        this.bindingsBasePage.bindingBasicsPage.tapOneWayBtn();
        if (this.settings.platform == PlatformType.iOS) {
            this.compareScreens(5);
        } else {
            Assert.assertEquals(this.bindingsBasePage.bindingBasicsPage.editTextFieldOneWay().getText(), "Test");
            Assert.assertEquals(this.bindingsBasePage.bindingBasicsPage.btnOneWay().getText().toLowerCase(), "oneway");
        }
        this.bindingsBasePage.bindingBasicsPage.tapTwoWayBtn();
        if (this.settings.platform == PlatformType.iOS) {
            this.compareScreens(5);
        } else {
            Assert.assertEquals(this.bindingsBasePage.bindingBasicsPage.editTextFieldTwoWay().getText(), "Test");
            Assert.assertEquals(this.bindingsBasePage.bindingBasicsPage.btnTwoWay().getText().toLowerCase(), "test");
        }

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void binding_02_xmlBasics() throws Exception {
        this.bindingsBasePage.navigateToMainPage();
        UIElement element = this.find.byTextContains("xmlbasics");
        this.bindingsBasePage.navigateTo(element);

        if (this.settings.platform == PlatformType.iOS) {
            this.compareScreens(5);
        } else {
            Assert.assertEquals(this.bindingsBasePage.bindingXmlBasicsPage.editTextField().getText(), "Text");
            Assert.assertEquals(this.bindingsBasePage.bindingXmlBasicsPage.btnText().getText(), "");
        }

        this.bindingsBasePage.bindingXmlBasicsPage.tapTextBtn();
        if (this.settings.platform == PlatformType.iOS) {
            this.compareScreens(5);
        } else {
            Assert.assertEquals(this.bindingsBasePage.bindingXmlBasicsPage.btnText().getText().toLowerCase(), "text");
        }

        this.bindingsBasePage.bindingXmlBasicsPage.tapBtn();
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion <= 10) {
            this.compareScreens(5);
        } else {
            this.device.assertLogContains("### onTap event ###");
        }

        this.assertImagesResults();
    }
}