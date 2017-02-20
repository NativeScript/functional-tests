package sdkexamples.Screens;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

public class SdkHomePage extends SdkPage {
    public SdkHomePage(MobileContext context) {
        super(context);
        loadedHomePage();
    }

    private UIElement title() {
        return this.find.byText("NativeScript Code Samples");
    }

    private void loadedHomePage() {
        if (title() != null) {
            this.log.info("SDK app home page loaded.");
        } else {
            Assert.fail("SDK app home page NOT loaded!");
        }
    }
}
