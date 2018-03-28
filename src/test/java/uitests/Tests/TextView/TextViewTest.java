package uitests.Tests.TextView;

import functional.tests.core.enums.PlatformType;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

import java.util.List;

public class TextViewTest extends UIBaseTests {

    public HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeTextViewTestClass() {
        this.homePageExtended = new HomePageExtended("text-view", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void hint_text_color() throws Exception {
        this.homePageExtended.navigateTo("hint-text-color");
        this.wait.waitForVisible(this.locators.byText("set text")).tap();
        this.compareScreens(3);
        this.wait.waitForVisible(this.locators.byText("reset text")).tap();
        this.compareScreens(3);
        this.wait.waitForVisible(this.locators.byText("reset style")).tap();
        this.compareScreens(3);
        this.wait.waitForVisible(this.locators.byText("set text")).tap();
        this.compareScreens(3);

        this.assertImagesResults();
    }


    @Test(groups = {"android", "ios"})
    public void text_view_border_10() throws Exception {
        this.homePageExtended.navigateTo("text-view-border");
        this.compareScreens(5, 0.8);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void textView_hint_text_color() throws Exception {
        this.homePageExtended.navigateTo("text-view-hint-color");
        this.compareScreens(3);
        this.homePageExtended.find.byLocator(this.locators.byText("Change text and color")).tap();
        this.compareScreens(3);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void textView_scrolling_4733() throws Exception {
        this.homePageExtended.navigateTo("scrolling-and-sizing");
        this.compareScreens(5);

        By locator = this.locators.textViewLocator();
        if (this.settings.platform == PlatformType.Android) {
            locator = this.locators.editTextLocator();
        }
        List<functional.tests.core.mobile.element.UIElement> elements = this.find.elementsByLocator(locator);

        this.typeText(elements, 4);
        this.typeText(elements, 3);
        this.typeText(elements, 2);
        this.typeText(elements, 1);
        this.typeText(elements, 0);


        this.app.hideKeyboard();

        this.compareScreens(15);

        this.assertImagesResults();
    }

    private void typeText(List<functional.tests.core.mobile.element.UIElement> elements, int index) {
        String text = "testestesttestestestestestestesttestestestesteste\n" +
                "testestesttestestestestestestesttestestestesteste\n" +
                "testestesttestestestestestestesttestestestesteste\n" +
                "testestesttestestestestestestesttestestestesteste";

        //change text for ios 10
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 11) {
            text = "1111111111111111111111111111111111111111\n" +
                    "1111111111111111111111111111111111111111\n" +
                    "1111111111111111111111111111111111111111\n" +
                    "1111111111111111111111111111111111111111";
            }

            elements.get(index).setText(text);

        if (this.settings.platform == PlatformType.Android) {
            try {
                this.app.hideKeyboard();
                this.compareScreens(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
