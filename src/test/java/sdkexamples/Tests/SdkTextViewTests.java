package sdkexamples.Tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
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
                {"Usage"}
        };
    }

    @Test(dataProvider = "example")
    public void sdkTextViewTest(String example) {
        this.mainPage.navigateTo(example);

        if (example.equals("Usage")) {
            String text = "This is very long text. This is very long text. This is very long text. " +
                    "This is very long text. This is very long text.";
            UIElement textField;
            if (this.settings.platform == PlatformType.Android) {
                textField = this.mainPage.wait.waitForVisible(this.locators.editTextLocator(), this.settings.shortTimeout, true);
            } else {
                textField = this.mainPage.find.byType("UIATextView");
            }
            textField.setText(text);
            if (this.settings.platform == PlatformType.Android) {
                this.mainPage.hideKeyboard();
            }
        }
    }
}
