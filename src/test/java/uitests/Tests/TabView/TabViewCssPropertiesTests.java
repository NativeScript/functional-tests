package uitests.Tests.TabView;

import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uitests.Screens.TabView.TabViewCssPropertiesPage;

public class TabViewCssPropertiesTests extends TabViewBaseTest {

    private TabViewCssPropertiesPage tabViewCssPropertiesPage;

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {TabViewCssPropertiesPage.TabTextColorGreen},
                {TabViewCssPropertiesPage.TabBackgroundColorYellow},
                {TabViewCssPropertiesPage.SelectedTabTextColorRed},
                {TabViewCssPropertiesPage.AndroidSelectedTabHighlightColorOrange},
                {TabViewCssPropertiesPage.TextTransformUppercase},
                {TabViewCssPropertiesPage.TextTransformLowercase},
                {TabViewCssPropertiesPage.TextTransformCapitalizecase},
                {TabViewCssPropertiesPage.TextTransformNone},
                {TabViewCssPropertiesPage.Reset},
                {TabViewCssPropertiesPage.All},
        };
    }

    @BeforeClass(alwaysRun = true)
    public void TabViewCssPropertiesTestsClass() {
        String tabView = "tabViewCss";
        if (this.settings.platform == PlatformType.Android && this.settings.platformVersion >= 7) {
            tabView = "TABVIEWCSS";
        }

        this.tabViewCssPropertiesPage = new TabViewCssPropertiesPage(tabView, this.context);
    }

    @Test(dataProvider = "example")
    public void tabViewCss(String example) throws Exception {
        this.tabViewCssPropertiesPage.loadScenario(example);
        this.compareScreens("tabViewCss_" + example, 5);
        if (example == TabViewCssPropertiesPage.All) {
            UIElement tabTwo = this.find.byLocator(this.locators.byText("twO", false, false));
            this.compareElements("tabViewCss_" + example + "_" + 1, tabTwo, 2, 0.01);
        }
        this.assertImagesResults();
    }
}
