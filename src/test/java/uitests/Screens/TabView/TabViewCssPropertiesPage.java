package uitests.Screens.TabView;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import uitests.Screens.HomePageExtended;

public class TabViewCssPropertiesPage extends HomePageExtended {
    public static final String TabTextColorGreen = "tab-text-color: green;";
    public static final String TabBackgroundColorYellow = "tab-background-color: yellow;";
    public static final String SelectedTabTextColorRed = "selected-tab-text-color: red;";
    public static final String AndroidSelectedTabHighlightColorOrange = "android-selected-tab-highlight-color: orange;";
    public static final String TextTransformUppercase = "text-transform: uppercase;";
    public static final String TextTransformLowercase = "text-transform: lowercase;";
    public static final String TextTransformCapitalizecase = "text-transform: capitalize;";
    public static final String TextTransformNone = "text-transform: none;";
    public static final String All = "All";
    public static final String Reset = "Reset";

    public TabViewCssPropertiesPage(String tabView, MobileContext context) {
        super(tabView, context);
    }

    public void loadScenario(String example) {
        UIElement element = this.scrollTo(example, 5);
        element.tap();
    }
}
