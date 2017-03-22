package uitests.Tests.Css;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.TransformPage;

public class TransformTests extends CssBaseTest {

    private TransformPage transformPage;

    @BeforeClass(alwaysRun = true)
    public void beforeTransformTestsClass() {
        this.transformPage = new TransformPage(this.cssBasePage);
    }

    @Test(groups = {"android", "ios"})
    public void transform_01() throws Exception {
        this.compareScreens("none", 5);

        this.transformPage.tapChangeBtn();
        this.compareScreens("capitalize", 5);

        this.transformPage.tapChangeBtn();
        this.compareScreens("uppercase", 5);

        this.transformPage.tapChangeBtn();
        this.compareScreens("lowercase", 5);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void transform_02_changeText() throws Exception {
        this.transformPage.navigateTo("transform");
        this.transformPage.loaded();

        // Change to UPPERCASE
        this.transformPage.tapChangeBtn();
        this.transformPage.tapChangeBtn();

        // Change text
        this.transformPage.tapChangeTextBtn();
        this.compareScreens("upper_case", 5);
        this.assertImagesResults();
    }
}
