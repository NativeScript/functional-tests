package uitests.Tests.TextField;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;
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
        this.homePageExtended.navigateTo("max-length");
        this.compareScreens(5);
        this.setText(0, "test");
        this.setText(1, "test");
        this.setText(2, "test");
        this.setText(3, "test");
        if (this.settings.platform == PlatformType.Android) {
            this.setText(4, "test");
        } else {
            this.homePageExtended.find.byLocator(By.className(this.uiElements.secureTextField()));
        }
        this.compareScreens(5);
        this.homePageExtended.find.byText("Revert to initial state").tap();
        this.compareScreens(5);

        this.homePageExtended.hideKeyboard();
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
