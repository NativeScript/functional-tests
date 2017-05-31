package uitests.Screens;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Find;
import org.openqa.selenium.By;
import org.testng.Assert;
import uitests.Screens.Css.CssBasePage;

import java.util.List;

public class BackgroundPage {

    private String background = "background";
    private CssBasePage cssBasePage;
    private Find find;

    public BackgroundPage(CssBasePage cssBasePage) {
        this.cssBasePage = cssBasePage;
        this.navToBackground();
        this.find = cssBasePage.find;
        this.loaded();
    }

    public void navToBackground() {
        UIElement element = this.cssBasePage.wait.waitForVisible(this.cssBasePage.locators.byText(background));
        this.cssBasePage.navigateTo(element, background);
    }

    public UIElement testElement() {
        if (this.cssBasePage.settings.platform == PlatformType.Android) {
            List<UIElement> elements = this.find.elementsByLocator(this.cssBasePage.locators.viewGroupLocator());
            int index = 4;
            if (this.cssBasePage.settings.platformVersion >= 7) {
                index = 1;
            }
            return elements.get(index);

        } else if (this.cssBasePage.settings.platform == PlatformType.iOS) {
            return this.find.byLocator(By.id("test-element"));
        } else {
            return null;
        }
    }

    private UIElement btnReset() {
        return this.cssBasePage.wait.waitForVisible(this.cssBasePage.locators.byText("r", true, false), 6, true);
    }

    public void tapResetBtn() {
        this.btnReset().click();
        this.cssBasePage.log.info("Tap on 'Reset' button.");
    }

    public void tapBtn(String button) {
        this.cssBasePage.wait.waitForVisible(this.cssBasePage.locators.byText(button)).click();
        this.cssBasePage.log.info("Tap on \'" + button + "\' button.");
    }

    public void loaded() {
        if (this.btnReset() != null) {
            this.cssBasePage.log.info("Background page loaded.");
        } else {
            Assert.fail("Background page NOT loaded.");
        }
    }
}
