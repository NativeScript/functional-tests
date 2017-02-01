package sdkexamples.Screens;

import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import org.testng.Assert;

public class SdkHomePage extends SdkPage {
    public SdkHomePage(Context context) {
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
