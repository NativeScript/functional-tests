package uitests.Tests.Button;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Find;
import org.openqa.selenium.By;
import org.testng.Assert;
import uitests.Screens.HomePageExtended;

import java.util.List;

public class BackgroundPage {

    private String background = "background";
    private HomePageExtended homePageExtended;
    private Find find;

    public BackgroundPage(HomePageExtended homePageExtended) {
        this.homePageExtended = homePageExtended;
        this.navToBackground();
        this.find = homePageExtended.find;
        this.loaded();
    }

    public void navToBackground() {
        UIElement element = this.homePageExtended.wait.waitForVisible(this.homePageExtended.locators.byText(background));
        this.homePageExtended.navigateTo(element, background);
    }

    public UIElement testElement() {
        if (this.homePageExtended.settings.platform == PlatformType.Android) {
            List<UIElement> elements = this.find.elementsByLocator(this.homePageExtended.locators.viewGroupLocator());
            int index = 4;
            if (this.homePageExtended.settings.platformVersion >= 7) {
                index = 1;
            }
            return elements.get(index);

        } else if (this.homePageExtended.settings.platform == PlatformType.iOS) {
            return this.find.byLocator(By.id("test-element"));
        } else {
            return null;
        }
    }

    private UIElement btnReset() {
        return this.homePageExtended.wait.waitForVisible(this.homePageExtended.locators.byText("r", true, false), 6, true);
    }

    public void tapResetBtn() {
        this.btnReset().click();
        this.homePageExtended.log.info("Tap on 'Reset' button.");
    }

    public void tapBtn(String button) {
        this.homePageExtended.wait.waitForVisible(this.homePageExtended.locators.byText(button)).click();
        this.homePageExtended.log.info("Tap on \'" + button + "\' button.");
    }

    public void loaded() {
        if (this.btnReset() != null) {
            this.homePageExtended.log.info("Background page loaded.");
        } else {
            Assert.fail("Background page NOT loaded.");
        }
    }
}
