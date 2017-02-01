package uitests.Tests.Css;

import functional.tests.core.enums.PlatformType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.DecorationPage;

public class DecorationTests extends CssBaseTest {
    private DecorationPage decorationPage;

    @BeforeClass(alwaysRun = true)
    public void beforeDecorationTestsClass() {
        this.decorationPage = new DecorationPage(this.cssBasePage);
    }

    @Test(groups = {"android", "ios"})
    public void decoration_01_none() throws Exception {
        if (this.settings.platform == PlatformType.Andorid) {
            this.compareScreens(2, 0.2);
        } else {
            this.compareScreens(2, 0.1);
        }

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void decoration_02_underline() throws Exception {
        this.decorationPage.tapChangeBtn();

        if (this.settings.platform == PlatformType.Andorid) {
            this.compareScreens(2, 0.2);
        } else {
            this.compareScreens(2, 0.1);
        }

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void decoration_03_lineThrough() throws Exception {
        this.decorationPage.tapChangeBtn();

        if (this.settings.platform == PlatformType.Andorid) {
            this.compareScreens(2, 0.2);
        } else {
            this.compareScreens(2, 0.1);
        }

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void decoration_04_lineThroughUnderline() throws Exception {
        this.decorationPage.tapChangeBtn();
        if (this.settings.platform == PlatformType.Andorid) {
            this.compareScreens(2, 0.2);
        } else {
            this.compareScreens(2, 0.1);
        }

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void decoration_05_lineThroughUnderlineNone() throws Exception {
        this.decorationPage.tapChangeBtn();
        if (this.settings.platform == PlatformType.Andorid) {
            this.compareScreens("decoration_01_none",2, 0.2);
        } else {
            this.compareScreens("decoration_01_none",2, 0.1);
        }

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void decoration_06_changeText() throws Exception {
        for (int i = 0; i < 3; i++) {
            this.decorationPage.tapChangeBtn();
        }

        if (this.settings.platform == PlatformType.Andorid) {
            this.compareScreens(2, 1.0);
        } else {
            this.compareScreens(2, 0.1);
        }

        this.assertImagesResults();
    }
}
