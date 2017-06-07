package uitests.Tests.Button;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

public class ButtonTest extends UIBaseTests {

    private final int compareScreens = 5;
    public HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeButtonTestClass() {
        this.homePageExtended = new HomePageExtended("button", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void btn_wrap_text_alignment_4266() throws Exception {
        this.homePageExtended.navigateTo("btn-wrap-text-alignment-4266");
        this.assertScreen(this.compareScreens);
    }

    @Test(groups = {"android", "ios"})
    public void styles_01() throws Exception {
        this.homePageExtended.navigateTo("styles");
        this.compareScreens(this.compareScreens, 0.01);
        this.assertImagesResults();
    }


    @Test(groups = {"android", "ios"})
    public void button_border_08() throws Exception {
        this.homePageExtended.navigateTo("button-border");
        this.compareScreens(this.compareScreens, 0.3);

        this.assertImagesResults();
    }
}
