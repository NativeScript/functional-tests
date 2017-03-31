package galleryapp.Tests;

import functional.tests.core.enums.PlatformType;
import galleryapp.GalleryBaseTest;
import galleryapp.Screens.SegmentedBarPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GalleryViewsTests extends GalleryBaseTest {

    @Test(groups = {"android", "ios"})
    public void view_01_button() throws Exception {
        this.homePage.navigateTo(
                "Button",
                this.locators.findByTextLocator("button", false));
        this.compareScreens(2, 0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void view_02_label() throws Exception {
        this.homePage.navigateTo(
                "Label",
                this.locators.findByTextLocator("The quick brown fox jumps over the lazy dog", false));
        this.compareScreens(2, 0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void view_03_textfield() throws Exception {
        this.homePage.navigateTo(
                "TextField",
                this.locators.findByTextLocator("Enter text", false));
        this.compareScreens(this.settings.shortTimeout, 0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void view_04_textview() throws Exception {
        this.homePage.navigateTo(
                "TextView",
                this.locators.findByTextLocator("The quick", false));
        this.compareScreens(this.settings.shortTimeout, 0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void view_05_switch() throws Exception {
        this.homePage.navigateTo("Switch", this.locators.switchLocator());
        this.compareScreens(this.settings.shortTimeout, 0.5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void view_06_slider() throws Exception {
        this.homePage.navigateTo("Slider", this.locators.sliderLocator());
        this.compareScreens(this.settings.shortTimeout, 0.5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void view_07_progress() throws Exception {
        this.homePage.navigateTo("Progress", this.locators.progressLocator());
        this.compareScreens(this.settings.shortTimeout, 0.01);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void view_08_activityindicator() throws Exception {
        this.homePage.navigateTo("ActivityIndicator", this.locators.activityIndicatorLocator());
        this.compareScreens(this.settings.shortTimeout, 0.25);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void view_09_image() throws Exception {
        this.homePage.navigateTo("Image", this.locators.imageLocator());
        this.compareScreens(this.settings.shortTimeout, 0.01);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void view_10_searchbar() throws Exception {
        this.homePage.navigateTo("SearchBar", this.locators.searchBoxLocator());
        this.compareScreens(this.settings.shortTimeout, 0.25);
        if (this.settings.platform == PlatformType.Android) {
            this.homePage.hideKeyboard();
            this.homePage.wait.waitForVisible(this.locators.searchBoxLocator(), this.settings.shortTimeout, true);
        }
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void view_11_listview() throws Exception {
        this.homePage.navigateTo("ListView", this.locators.listViewLocator());
        this.compareScreens(this.settings.shortTimeout, 0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void view_12_repeater() throws Exception {
        this.homePage.navigateTo("Repeater", this.getElementByText("List item 3"));
        this.compareScreens(this.settings.shortTimeout, 0.5);
        this.assertImagesResults();
    }

    // TODO: Create a separate class with tests for the dialogs.
    @Test(groups = {"android", "ios"})
    public void view_12_dialogs() throws Exception {
        this.homePage.navigateTo("Dialogs", this.getElementByText("alert"));
        this.compareScreens(this.settings.shortTimeout, 0.2);
    }

    @Test(groups = {"android", "ios"})
    public void view_13_datepicker() throws Exception {
        this.homePage.navigateTo("DatePicker", this.locators.datePickerLocator());
        this.compareScreens(this.settings.shortTimeout, 0.1);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void view_14_timepicker() throws Exception {
        this.homePage.navigateTo("TimePicker", this.locators.timePickerLocator());
        this.compareScreens(this.settings.shortTimeout, 0.01);
    }

    @Test(groups = {"android", "ios"})
    public void view_15_listpicker() throws Exception {
        this.homePage.navigateTo("ListPicker", this.locators.listPicker());
        this.compareScreens(this.settings.shortTimeout, 0.01);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void view_16_segmentedbar() throws Exception {
        this.homePage.navigateTo("SegmentedBar", this.getElementByText("Item 3"));
        if (this.settings.platform == PlatformType.Android) {
            // Play with items and verify if tap change isSelected property
            SegmentedBarPage segmentedBarPage = new SegmentedBarPage(this.context);
            segmentedBarPage.item2().tap();
            Assert.assertTrue(segmentedBarPage.item2().isSelected(), "SegmentedBar Item 2 is not selected.");
            segmentedBarPage.item3().tap();
            Assert.assertTrue(segmentedBarPage.item3().isSelected(), "SegmentedBar Item 3 is not selected.");
            segmentedBarPage.item1().tap();
            Assert.assertTrue(segmentedBarPage.item1().isSelected(), "SegmentedBar Item 1 is not selected.");
        } else {
            // In iOS automation there is not isSelected property.
        }

        this.compareScreens(this.settings.shortTimeout, 0.25);
        this.assertImagesResults();
    }
}
