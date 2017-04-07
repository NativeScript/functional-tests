package animations.Tests.Animations;

import animations.Screens.DemoPage;
import animations.Tests.AnimationsBaseTest;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Wait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SlideInEffectTests extends AnimationsBaseTest {

    private static final String slideInEffects = "slide-in-effect";

    @BeforeClass(alwaysRun = true)
    public void beforeSlideInEffectTestsClass() {
        this.demoPage = new DemoPage(slideInEffects, this.context);
    }

    @Test(groups = {"android", "ios"})
    public void slide_in_effect_01() throws Exception {
        this.demoPage.loadedSlideInEffect();
        //  this.log.logScreen(this.context.getTestName(), this.context.getTestName(), 320, 240);
    }

    @Test(groups = {"android", "ios"})
    public void slide_in_effect_02_animate() throws Exception {
        UIElement btnAddItem = this.demoPage.context.find.byText("Add Item");
        for (int i = 0; i < 3; i++) {
            btnAddItem.click();
            Wait.sleep(1);
        }
        Wait.sleep(2);
        this.compareScreens(this.settings.shortTimeout, 0.5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void slide_in_effect_03_reset() throws Exception {
        this.demoPage.context.find.byText("Clear").click();
        Wait.sleep(1);
        String testName = "slide_in_effect_03_reset";
        this.log.logScreen(testName, testName, 320, 240);
    }
}
