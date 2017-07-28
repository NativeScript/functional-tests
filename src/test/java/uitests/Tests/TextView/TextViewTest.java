package uitests.Tests.TextView;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

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
}
