package uitests.Tests.Gestures;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.PanEventPage;

public class PanEventTests extends GesturesBaseTest {
    private PanEventPage panEventPage;

    @BeforeClass(alwaysRun = true)
    public void beforePanEventTestsClass() {
        this.panEventPage = new PanEventPage(this.homePageExtended);
        this.panEventPage.loaded();
    }

    @Test(groups = {"android", "ios"})
    public void pan_01() throws Exception {
        if (this.settings.platformVersion !=4.2) {
            this.panEventPage.testElement().dragAndDrop(100, 100, 500);

            Assert.assertTrue(this.panEventPage.assertPoints(this.panEventPage.output()), "Pan points are not correct when pan down!");
            this.panEventPage.navigateBack();
        }
    }

    @Test(groups = {"android", "ios"})
    public void pan_02() throws Exception {
        if (this.settings.platformVersion !=4.2) {
            this.panEventPage.loaded();
            this.panEventPage.testElement().dragAndDrop(100, 100, 500);

            Assert.assertTrue(this.panEventPage.assertPoints(this.panEventPage.output()), "Pan points are not correct when you pan up!");
        }
    }
}

