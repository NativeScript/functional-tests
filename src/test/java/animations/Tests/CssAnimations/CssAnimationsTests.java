package animations.Tests.CssAnimations;

import functional.tests.core.find.Wait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CssAnimationsTests extends CssAnimationsBaseTest {

    private static String backgroundColor = "background-color";
    private static String initialAnimation = "initial-animation";
    private static String visualStates = "visual-states";
    private static String btnTouchMe = "Touch me";
    private static String btnAnimate = "Animate";

    @DataProvider(name = "demo")
    public Object[][] demo() {
        return new Object[][]{
                {"background-color"},
                {"visual-states"}
        };
    }

    @DataProvider(name = "animate")
    public Object[][] animate() {
        return new Object[][]{
                {"opacity"},
                {"transform"},
                {"bounce"},
                {"animate-css"},
                {"from-code"},
                {"settings"},
                // { "initial-animation" }
        };
    }

    public void compareScreens(String animate) throws Exception {
        this.compareScreens("css_" + animate + "_animate", this.settings.shortTimeout, 0.5);
    }

    @Test(groups = {"android", "ios"}, dataProvider = "demo")
    public void css_01_animations(String demo) throws Exception {
        this.cssAnimationsPage.navigateTo(demo);
        this.log.logScreen(demo, demo, 320, 240);

        if (demo == backgroundColor) {
            this.demoPage.tapBtn(btnTouchMe);
        } else if (demo == visualStates) {
            this.demoPage.longPressBtn(btnTouchMe);
        }

        this.compareScreens(demo);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"}, dataProvider = "animate")
    public void css_02_animations(String animate) throws Exception {
        this.cssAnimationsPage.navigateTo(animate);
        this.demoPage.btn(btnAnimate);
        this.log.logScreen(animate, animate, 320, 240);

        this.demoPage.tapAnimateBtn();
        Wait.sleep(5);
        this.demoPage.btnAnimate();

        this.compareScreens(animate);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void css_03_animations() throws Exception {
        this.cssAnimationsPage.navigateTo(initialAnimation);
        Wait.sleep(5);
        this.cssAnimationsPage.btnInitialAnimation();
        this.compareScreens(initialAnimation);
        String testName = "css_03_animations()";
        this.log.logScreen(testName, testName, 320, 240);
        this.assertImagesResults();
    }
}
