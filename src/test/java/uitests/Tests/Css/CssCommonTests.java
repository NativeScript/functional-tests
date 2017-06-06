package uitests.Tests.Css;

import functional.tests.core.enums.DeviceType;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.enums.Position;
import functional.tests.core.mobile.element.UIElement;
import io.appium.java_client.SwipeElementDirection;
import org.testng.annotations.Test;

public class CssCommonTests extends CssBaseTest {

    private int compareScreens = 10;

    @Test(groups = {"android", "ios"})
    public void zindex_01() throws Exception {
        this.cssBasePage.navToPage("zindex");

        this.compareScreens(compareScreens, 0.55);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void padding_01() throws Exception {
        this.cssBasePage.navToPage("padding");
        this.compareScreens(compareScreens, 0.18);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void formattedText_01() throws Exception {
        this.cssBasePage.navToPage("formatted");
        this.compareScreens(compareScreens, 0.5);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void clipPath_01() throws Exception {
        this.cssBasePage.navToPage("clipPath");
        UIElement mainElement = this.cssBasePage.find.byText("clipPath", false, 3);

        if ((this.settings.platformVersion.toString().startsWith("4")) && (this.settings.deviceType == DeviceType.Emulator)) {
            this.compareElements(mainElement, 10, 20d);
        } else {
            this.compareElements(mainElement, 5, 1d);
        }

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void transform_decoration_color_05() throws Exception {
        this.cssBasePage.navToPage("transform-decoration-color");
        this.compareScreens(10, 0.85);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layout_border_06() throws Exception {
        this.cssBasePage.navToPage("layout-border");
        this.compareScreens(compareScreens, 0.3);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void label_border_07() throws Exception {
        this.cssBasePage.navToPage("label-border");
        this.compareScreens(compareScreens, 0.3);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void image_border_11() throws Exception {
        this.cssBasePage.navToPage("image-border");
        this.compareScreens(compareScreens, 0.3);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void layouts_border_overlap_12() throws Exception {
        this.cssBasePage.navToPage("layouts-border-overlap");
        this.compareScreens(compareScreens, 0.3);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void measures_13() throws Exception {
        this.cssBasePage.navToPage("layouts-border-overlap");
        this.compareScreens(compareScreens, 0.3);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void all_uniform_border_14() throws Exception {
        this.cssBasePage.navToPage("all-uniform-border");
        this.compareScreens(compareScreens, 0.67);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void all_non_uniform_border_14() throws Exception {
        this.cssBasePage.navToPage("all-non-uniform-border");
        this.cssBasePage.wait.waitForVisible(this.locators.byText("Button", true, false), 6, true);
        this.compareScreens(compareScreens, 0.67);
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void margins_paddings_with_percentage_15() throws Exception {
        this.cssBasePage.navToPage("margins-paddings-with-percentage");
        UIElement btn = this.cssBasePage.wait.waitForVisible(this.locators.byText("css", false, false), 6, true);
        this.compareScreens(compareScreens, 5);
        btn.tap();
        this.compareScreens(compareScreens, 5);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void pixels_perfect() throws Exception {
        this.cssBasePage.navToPage("pixels");
        this.cssBasePage.wait.waitForVisible(this.locators.byText("Button", true, false), 6, true);
        this.assertScreen();
    }

    @Test(groups = {"android", "ios"})
    public void hint_text_color() throws Exception {
        this.cssBasePage.navToPage("hint-text-color");
        this.wait.waitForVisible(this.locators.byText("set text")).tap();
        this.compareScreens(3);
        this.wait.waitForVisible(this.locators.byText("reset text")).tap();
        this.compareScreens(3);
        this.wait.waitForVisible(this.locators.byText("reset style")).tap();
        this.compareScreens(3);
        this.wait.waitForVisible(this.locators.byText("set text")).tap();
        this.compareScreens(3);

        this.assertImagesResults();
    }
}
