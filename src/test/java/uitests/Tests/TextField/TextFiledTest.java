package uitests.Tests.TextField;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

public class TextFiledTest extends UIBaseTests {

    public HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeTextFiledTestClass() {
        this.homePageExtended = new HomePageExtended("text-field", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void secured_text_field_4135() throws Exception {
        this.homePageExtended.navigateTo("secured-text-field");
        this.assertScreen(5);
    }

    @Test(groups = {"android", "ios"})
    public void max_length() throws Exception {
        final int waitTime = 15;
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 10) {
            this.log.error("This test is not executed for iOS 9");
            return;
        }

        this.homePageExtended.navigateTo("max-length");
        this.compareScreens(waitTime);

        this.setText(0, "test");
        this.setText(1, "test");
        this.setText(2, "test");
        this.setText(3, "test");
        if (this.settings.platform == PlatformType.Android) {
            this.setText(4, "test");
        }
        this.compareScreens(waitTime);

        this.homePageExtended.find.byText("Revert to initial state").tap();
        this.compareScreens(waitTime);

        this.homePageExtended.hideKeyboard();
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void blur_focus_textView_TextField() throws Exception {
        this.homePageExtended.navigateTo("focus-blur-events");
        UIElement textFieldLocator;// = this.locators.textFieldLocator();
        UIElement textViewLocator;// = this.locators.textViewLocator();
        if (this.settings.platform == PlatformType.Android) {
            textFieldLocator = this.find.elementsByLocator(this.locators.editTextLocator()).get(0);
            textViewLocator = this.find.elementsByLocator(this.locators.editTextLocator()).get(1);
        } else {
            textFieldLocator = this.wait.waitForVisible(this.locators.textFieldLocator());
            textViewLocator = this.wait.waitForVisible(this.locators.textViewLocator());
        }

        textFieldLocator.tap();
        textViewLocator.tap();

        this.compareScreens(5, 0.1);

        textFieldLocator.tap();
        this.compareScreens(5, 0.1);
        this.app.hideKeyboard();

        this.assertImagesResults();
    }

    private void setText(int index, String text) {
        UIElement textField = this.getTextField(index);
        textField.sendKeys(text);
    }

    private UIElement getTextField(int index) {
        return this.wait.forVisibleElements(this.locators.editTextLocator(), 2, true).get(index);
    }

    @Test(groups = {"android", "ios"})
    public void text_field_border() throws Exception {
        this.homePageExtended.navigateTo("text-field-border");
        this.assertScreen(5);
    }
}
