package animations.Tests.AnimationCurves;

import animations.Screens.AnimationCurvesPage;
import animations.Screens.HomePage;
import animations.Tests.AnimationsBaseTest;
import org.testng.annotations.BeforeClass;

public class AnimationCurvesBaseTest extends AnimationsBaseTest {

    private static final String animationCurves = "animation-curves";
    private static final String curves_image = "animation_curves";

    protected AnimationCurvesPage animationCurvesPage;

    @BeforeClass
    public void beforeAnimationCurvesBaseTestClass() throws Exception {
        this.animationCurvesPage = new AnimationCurvesPage(animationCurves, this.context);
    }

    public void assertCurveScreen() throws Exception {
        this.compareScreens(curves_image, this.settings.shortTimeout, 0.5);
        this.assertImagesResults();
    }
}
