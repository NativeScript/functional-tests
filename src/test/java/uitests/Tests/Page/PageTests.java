package uitests.Tests.Page;

import functional.tests.core.enums.PlatformType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uitests.Screens.Page.StatusBarPage;

public class PageTests extends PageBaseTest {
    private StatusBarPage statusBarPage;

    @BeforeClass(alwaysRun = true)
    @Override
    public void beforePageBaseTest() {
        this.statusBarPage = new StatusBarPage(this.context);
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"11", "light;"},
                {"12", "dark;"},
                {"21", "light-abb-ruby"},
                {"22", "dark-abb-ruby"},
                {"31", "light-ab-hidden"},
                {"32", "ark-ab-hidden"},
                {"41", "asbb-ruby"},
                {"51", "light-bckg-ruby"},
                {"52", "dark-bckg-ruby"},
                {"61", "light-bckg-yellow-abbckg-ruby"},
                {"62", "dark-bckg-yellow-abbckg-ruby"},
                {"71", "dark-bckg-yellow-bckgsusb-true"},
                {"72", "light-bckg-yellow-abbck-ruby-bckgsusb-true"},
                {"74", "dark-ab-hidden-bckgsusb-true"},
                {"73", "light-ab-hidden-bckgsusb-true"},
        };
    }

    @Test(groups = {"android", "ios"}, dataProvider = "example")
    public void statusBarTest_feature_2736(String btn, String scenario) throws Exception {
        if (this.settings.platform == PlatformType.iOS && (btn == "31" || btn == "32" || btn == "41")) {
            return;
        }

        this.statusBarPage.find.byText(scenario).tap();
        this.log.info(String.format("Tapped on button %s and loaded scenario: %s ", btn, scenario));
        String imageName = String.format("%s_%s_%s", this.context.getTestName(), btn, scenario);
        this.assertScreen(imageName, 5);
    }
}
