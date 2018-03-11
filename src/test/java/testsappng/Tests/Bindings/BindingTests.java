package testsappng.Tests.Bindings;

import functional.tests.core.enums.PlatformType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsappng.Screens.BindingPage;
import testsappng.TestsAppNgBase;

public class BindingTests extends TestsAppNgBase {
    protected BindingPage bindingPage;

    @BeforeClass(alwaysRun = true)
    public void beforeClassBindingTests() throws Exception {
        this.bindingPage = new BindingPage("Binding", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void binding_01() throws Exception {
        if (this.settings.platformVersion < 11.0
                && this.settings.platform == PlatformType.iOS) {
            this.log.warn("This test will be skipped on iOS 10, because of https://github.com/facebook/WebDriverAgent/issues/703");
        }

        this.bindingPage.insertNewValues();
        this.bindingPage.getResults();
        if (isIPhoneX()) {
            this.compareScreens(5);
        } else {
            Assert.assertTrue(this.bindingPage.compareResults("1", "0", "5"), "Binding is not working");
        }
        this.bindingPage.updateValuesFromCodeBehind();
        this.bindingPage.getResults();

        if (isIPhoneX()) {
            this.compareScreens(5);
        } else {
            Assert.assertTrue(this.bindingPage.compareResults("0", "0", "0"), "Binding is not working from code behind!");
            this.assertImagesResults();
        }
    }

    private boolean isIPhoneX() {
        return this.settings.platformVersion >= 11.0
                && this.settings.platform == PlatformType.iOS
                && this.settings.deviceName.toLowerCase().contains("x");
    }
}