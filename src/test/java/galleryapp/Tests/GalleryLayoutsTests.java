package galleryapp.Tests;

import galleryapp.GalleryBaseTest;
import org.testng.annotations.Test;

public class GalleryLayoutsTests extends GalleryBaseTest {

    @Test(groups = {"android", "ios"})
    public void layouts_01_stacklayout() throws Exception {
        this.homePage.navigateTo("StackLayout", this.getElementByText("button 3"));
        this.compareScreens(this.settings.shortTimeout, 0.01);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_02_gridlayout() throws Exception {
        this.homePage.navigateTo("GridLayout", this.getElementByText("5"));
        this.compareScreens(this.settings.shortTimeout, 0.01);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_03_wraplayout() throws Exception {
        this.homePage.navigateTo("WrapLayout", this.getElementByText("5"));
        this.compareScreens(this.settings.shortTimeout, 0.01);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_04_docklayout() throws Exception {
        this.homePage.navigateTo("DockLayout", this.getElementByText("right"));
        this.compareScreens(this.settings.shortTimeout, 0.01);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_05_absolutelayout() throws Exception {
        this.homePage.navigateTo("AbsoluteLayout", this.getElementByText("3"));
        this.compareScreens(this.settings.shortTimeout, 0.01);
        this.assertImagesResults();
    }
}
