package uitests.Tests.ListPicker;

import functional.tests.core.enums.PlatformType;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

@SuppressWarnings("groupsTestNG")
public class ListPickerTest extends UIBaseTests {
    private HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeLayoutsTestsClass() {
        this.homePageExtended = new HomePageExtended("list-picker", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void listPicker_issue_2895() throws Exception {
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 10) {
            return;
        }
        this.homePageExtended.navigateTo("issue_2895");
        this.context.wait.waitForVisible(this.locators.byText("Toggle visibility")).click();
        this.device.rotate(ScreenOrientation.LANDSCAPE);
        this.compareScreens(15, 1);
        this.device.rotate(ScreenOrientation.PORTRAIT);
        this.compareScreens(15);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"}, dependsOnMethods = {"listPicker_issue_2895"})
    public void listPicker_css() throws Exception {
        this.homePageExtended.navigateToMainPage();
        this.homePageExtended.navigateTo(this.wait.waitForVisible(this.locators.byText("list-picker")), "list-picker ");
        this.compareScreens(10);

        this.assertImagesResults();
    }
}


