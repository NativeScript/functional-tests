package templates.masterdetailkinvey.tests;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.basetest.MobileTest;
import templates.masterdetailkinvey.pages.DetailsPage;
import templates.masterdetailkinvey.pages.EditPage;
import templates.masterdetailkinvey.pages.HomePage;
import org.testng.annotations.Test;


public class SmokeTests extends MobileTest {

    @Test(description = "Verify home page looks OK.", groups = {"android", "ios"})
    public void test_01_home_page_looks_ok() throws Exception {
        HomePage homePage = new HomePage();
        this.assertScreen("template-master-detail-home", this.settings.defaultTimeout, 0.5);
    }

    @Test(description = "Verify details page looks OK.", groups = {"android", "ios"})
    public void test_02_details_page_looks_ok() throws Exception {
        HomePage homePage = new HomePage();
        if (this.settings.platform == PlatformType.Android) {
            homePage.navigate("BMW 5 Series");
        } else {
            homePage.navigate("Kia Sorento");
        }
        DetailsPage detailsPage = new DetailsPage();
        this.assertScreen("template-master-detail-details", this.settings.defaultTimeout, 0.25);
    }

    @Test(description = "Verify Edit page looks OK.", groups = {"android", "ios"})
    public void test_03_edit_page_looks_ok() throws Exception {
        DetailsPage detailsPage = new DetailsPage();
        detailsPage.navigate("Edit");
        EditPage editPage = new EditPage();
        this.assertScreen("template-master-detail-edit", this.settings.defaultTimeout, 0.25);
    }

    @Test(description = "Verify Editing not allowed", groups = {"android", "ios"})
    public void test_04_editing_item_readonly() throws Exception {
        EditPage editPage = new EditPage();
        editPage.tabButton("Done");
        this.assertScreen("template-master-detail-readOnlyPopup", this.settings.defaultTimeout, 0.25);
        editPage.tabButton("Ok");
        this.assertScreen("template-master-detail-home", this.settings.defaultTimeout, 0.25);
    }
}
