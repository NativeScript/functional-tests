package uitests.Tests.ListPicker;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.enums.Position;
import io.appium.java_client.SwipeElementDirection;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.Css.CssCommonTests;
import uitests.Tests.UIBaseTests;

public class ListPickerTest extends UIBaseTests {
    private HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeLayoutsTestsClass() {
        this.homePageExtended = new HomePageExtended("list-picker", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void listPicker_issue_2895() throws Exception {
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion <10){
            return;
        }
        this.homePageExtended.navigateTo("issue_2895");
        this.context.wait.waitForVisible(this.locators.byText("Toggle visibility")).tap();
        this.device.rotate(ScreenOrientation.LANDSCAPE);
        this.compareScreens(5);
        this.device.rotate(ScreenOrientation.PORTRAIT);
        this.compareScreens(5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void cssListPicker() throws Exception {
        this.homePageExtended.navigateTo(this.find.byText("list-picker"),"list-picker ");
        this.compareScreens(10);
        if (this.settings.platform == PlatformType.Android) {
            this.wait.waitForVisible(this.locators.byText("name1", false, false), 2, false)
                    .dragAndDrop(20, -200, 0);
        } else {
            this.wait.waitForVisible(this.locators.byText("name0", false, false), 2, false)
                    .scrollInElementToElement(SwipeElementDirection.DOWN, Position.FromCenter, this.locators.byText("name3"), 10, 5);
        }

        this.compareScreens(10);
        this.assertImagesResults();
    }
}


