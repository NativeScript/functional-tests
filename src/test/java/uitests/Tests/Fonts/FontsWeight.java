package uitests.Tests.Fonts;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uitests.Screens.Fonts.FontPage;

public class FontsWeight extends MobileTest {
    protected FontPage fontPage;

    @BeforeClass(alwaysRun = true)
    public void beforeFontsWeight() {
        this.fontPage = new FontPage("fonts", this.context);
        this.fontPage.navigateTo("fonts-weight");
        this.fontPage.context.navigationManager.setMainPage("fonts-weight");
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"system"},
                {"sans-serif"},
                {"serif"},
                {"courier-new"},
                {"helvetica"},
                {"custom-fontawesome"},
                {"custom-muli"},
                {"custom-sofia"},
                {"font-fallback"},
        };
    }

    @Test(dataProvider = "example", groups = {"android", "ios"})
    public void fontsWeight(String example) throws Exception {
        this.fontPage.navigateTo(example);
        this.assertScreen("fontsWeight_" + example, 5);
    }
}
