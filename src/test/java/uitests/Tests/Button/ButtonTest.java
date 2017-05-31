package uitests.Tests.Button;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

public class ButtonTest extends UIBaseTests {

    public HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeButtonTestClass() {
        this.homePageExtended = new HomePageExtended("button", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void btn_wrap_text_alignment_4266() throws Exception {
        this.homePageExtended.navigateTo("btn-wrap-text-alignment-4266");
        this.assertScreen();
    }
}
