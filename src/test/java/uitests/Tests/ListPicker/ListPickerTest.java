package uitests.Tests.ListPicker;

import functional.tests.core.enums.PlatformType;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
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
}


