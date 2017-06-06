package uitests.Tests.TextView;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

public class TextViewTest extends UIBaseTests {

    public HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeTextViewTestClass() {
        this.homePageExtended = new HomePageExtended("text-view", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void text_view_border_10() throws Exception {
        this.homePageExtended.navigateTo("text-view-border");
        this.compareScreens(5, 0.8);

        this.assertImagesResults();
    }

}
