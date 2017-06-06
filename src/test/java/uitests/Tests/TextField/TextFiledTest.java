package uitests.Tests.TextField;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;
import uitests.Tests.UIBaseTests;

public class TextFiledTest extends UIBaseTests {

    public HomePageExtended homePageExtended;

    @BeforeClass(alwaysRun = true)
    public void beforeTextFiledTestClass() {
        this.homePageExtended = new HomePageExtended("text-field", this.context);
    }

    @Test(groups = {"android", "ios"})
    public void secured_text_field_4135() throws Exception {
        this.homePageExtended.navigateTo("secured-text-field");
        this.assertScreen();
    }

    @Test(groups = {"android", "ios"})
    public void max_length() throws Exception {
        this.homePageExtended.navigateTo("smax-length");
        this.assertScreen();
    }

    @Test(groups = {"android", "ios"})
    public void text_field_border() throws Exception {
        this.homePageExtended.navigateTo("text-field-border");
        this.assertScreen();
    }
}
