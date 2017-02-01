package animations.Tests.AnimationCurves;

import functional.tests.core.find.Wait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AnimationCurvesTests extends AnimationCurvesBaseTest {

    @DataProvider(name = "demo")
    public Object[][] data() {
        return new Object[][]{
                {"Linear"},
                {"EaseIn"},
                {"EaseOut"},
                {"EaseInEaseOut"},
                {"Spring"},
                {"Custom"}
        };
    }

    @Test(groups = {"android", "ios"}, dataProvider = "demo")
    public void animation_curves(String demo) throws Exception {
        this.animationCurvesPage.tapBtn(demo);
        Wait.sleep(5);
        this.animationCurvesPage.btn(demo);
        this.assertCurveScreen();
        this.animationCurvesPage.tapResetBtn();
    }
}
