package uitests.Tests.Button;

import org.testng.annotations.Test;

public class ButtonTest extends ButtonBaseTest {

    @Test(groups = {"android", "ios"})
    public void btn_wrap_text_alignment_4266() throws Exception {
        this.homePageExtended.navigateTo("btn-wrap-text-alignment-4266");
        this.assertScreen(this.compareScreens);
    }

    @Test(groups = {"android", "ios"})
    public void btn_wrap_text_alignment_4287() throws Exception {
        this.homePageExtended.navigateTo("issue-4287");
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
