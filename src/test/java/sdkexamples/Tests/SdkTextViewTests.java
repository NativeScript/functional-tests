package sdkexamples.Tests;

import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkTextViewTests extends SdkBaseTest {

    protected String page = "TextView";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"Basic TextView"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkTextViewTest(String example) throws Exception {
        this.mainPage.navigateTo(example);

        // Additional screenshot for TextView with very long text
        if (example == "Basic TextView") {
            String text = "This is very long text. This is very long text. This is very long text. " +
                    "This is very long text. This is very long text.";
            UIElement textField = null;
            if (this.settings.platform == PlatformType.Andorid) {
                textField = this.mainPage.find.byLocator(this.locators.editTextLocator());
            } else {
                textField = this.mainPage.find.byType("UIATextView");
            }
            textField.setText(text);
            if (this.settings.platform == PlatformType.Andorid) {
                this.mainPage.hideKeyboard();
            }
            this.mainPage.logScreenshot("Basic TextView with very long text.");
        }
    }
}
