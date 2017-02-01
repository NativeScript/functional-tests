package galleryapp.Tests;

import galleryapp.GalleryBaseTest;
import galleryapp.Screens.TabViewPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GalleryContentTests extends GalleryBaseTest {
    private TabViewPage tabViewPage;

    @BeforeClass
    public void beforeGalleryContentTestsClass() {
        this.tabViewPage = new TabViewPage();
    }

    @Test(groups = {"android", "ios"})
    public void content_01_tabview() throws Exception {
        this.homePage.navigateTo("TabView", this.getElementByText("First"));
        this.tabViewPage.tapSecondTab();
        this.tabViewPage.tapFirstTab();
        this.tabViewPage.tapSecondTab();
        this.tabViewPage.loaded();

        this.compareScreens(this.settings.shortTimeout, 0.01);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void content_02_webview() throws Exception {
        double tolerance = 35.0;
        this.homePage.navigateTo("WebView", null);
        if (this.settings.platformVersion >= 4.3) {
            this.compareScreens(this.settings.defaultTimeout, tolerance);
        }
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void content_03_htmlview() throws Exception {
        this.homePage.navigateTo("HtmlView", null);
        this.compareScreens(this.settings.shortTimeout);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void content_04_scrollview() throws Exception {
        this.homePage.navigateTo("ScrollView", this.locators.scrollViewLocator());
        this.compareScreens(this.settings.shortTimeout, 0.25);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void content_05_border() throws Exception {
        this.homePage.navigateTo("Border", this.getElementByText("Content"));
        this.compareScreens(this.settings.shortTimeout, 0.02);
        this.assertImagesResults();
    }
}
