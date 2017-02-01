package galleryapp;

import functional.tests.core.basetest.UIBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;

public class GalleryBaseTest extends UIBaseTest {

    protected GalleryHomePage homePage;

    @BeforeClass
    public void beforeLayoutsTests() {
        this.homePage = new GalleryHomePage("", this.context);
    }

    protected By getElementByText(String button) {
        return this.locators.byText(button, false, false);
    }
}
