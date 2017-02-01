package uitests.Tests.Fonts;

import functional.tests.core.basetest.UIBaseTest;
import functional.tests.core.enums.PlatformType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.Fonts.NordicPage;

public class NordicTests extends UIBaseTest {
    private NordicPage nordicPage;

    @BeforeClass(alwaysRun = true)
    public void beforeNordicTestsClass() {
        this.nordicPage = new NordicPage("fonts", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void nordic_01() throws Exception {
        this.nordicPage.navigateTo("nordic");
        this.nordicPage.wait.waitForVisible(this.nordicPage.labelLocator());

        if (this.settings.platform == PlatformType.Andorid) {
            Assert.assertEquals(this.nordicPage.label().getText(), "æøå");
            Assert.assertEquals(this.nordicPage.button().getText().toLowerCase(), "æøå");
        } else {
            //Assert.assertEquals(this.nordicPage.label().getText(), "æøå");
            //Assert.assertEquals(this.nordicPage.button().getText(), "æøå");
            this.compareScreens(3);
            this.assertImagesResults();
        }
    }
}
