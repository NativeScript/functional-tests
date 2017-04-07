package animations.Tests.Animations;

import animations.Screens.DemoPage;
import animations.Tests.AnimationsBaseTest;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.find.Wait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AnimationsTests extends AnimationsBaseTest {

    @BeforeClass(alwaysRun = true)
    public void beforeSlideInEffectTestsClass() {
        this.demoPage = new DemoPage("", this.context);
    }

    @DataProvider(name = "demo")
    public Object[][] data() {
        return new Object[][]{
                {"opacity"},
                {"background-color"},
                {"translate"},
                {"scale"},
                {"rotate"},
                {"multiple-properties"},
                {"chaining-with-promises"},
                {"chaining-with-animation-set"},
                {"multiple-views"},
                {"reusing"},
                {"infinite"}
        };
    }

    @Test(groups = {"android", "ios"}, dataProvider = "demo")
    public void animations(String demo) throws Exception {
        // Just to reset  the view because opacity demo is not visible
        if (demo == "opacity" && this.settings.platform == PlatformType.Android) {
            this.app.restart();
        }

        this.demoPage.navigateTo(demo);

        this.demoPage.loaded();
        this.log.logScreen(demo, demo, 320, 240);

        this.demoPage.tapAnimateBtn();
        Wait.sleep(5);
        this.demoPage.btnAnimate();
        this.compareScreens(demo + "_animate", this.settings.shortTimeout, 5.5);

        this.demoPage.tapResetBtn();
        Wait.sleep(1);
        this.log.logScreen(demo + "_reset", demo + "_reset", 320, 240);
        this.assertImagesResults();
    }
}
