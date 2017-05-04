package uitests.Tests.Css;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.TransformPage;

public class TransformTests extends CssBaseTest {

    private static final int waitCount = 25;
    private TransformPage transformPage;

    @BeforeClass(alwaysRun = true)
    public void beforeTransformTestsClass() {
        this.transformPage = new TransformPage(this.cssBasePage);
    }

    @Test(groups = {"android", "ios"})
    public void transform_01() throws Exception {

        this.compareScreens("none", waitCount);

        this.transformPage.tapChangeBtn();
        this.compareScreens("capitalize", waitCount);

        this.transformPage.tapChangeBtn();
        this.compareScreens("uppercase", waitCount);

        this.transformPage.tapChangeBtn();
        this.compareScreens("lowercase", waitCount);
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
        this.compareScreens("upper_case", waitCount);
        this.assertImagesResults();
    }

    // TODO: Uncomment after fix
//    @Test(groups = {"android"})
//    public void transform_03_autoCorrect() throws Exception {
//        this.transformPage.navigateTo("transform");
//        this.wait.waitForVisible(this.locators.byText("textField textField")).tap();
//        this.wait.waitForVisible(this.locators.byText("text field")).tap();
//
//        this.compareScreens("auto_correct", 5);
//        this.assertImagesResults();
//    }
}
