package sdkexamples.Screens;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.enums.Position;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SdkMainPage extends SdkHomePage {

    public SdkMainPage(String page, MobileContext context) {
        super(context);
        UIElement containerListView = this.wait.waitForVisible(this.locators.listViewLocator());
        this.scrollDownToElement(containerListView, page, Position.FromCorner);
        this.navigationManager.setMainPage(page);
        loadedMainPage(page);
    }

    private UIElement btnOk() {
        return this.find.byText("OK", this.settings.defaultTimeout);
    }

    public By btnOkLocator() {
        return this.locators.byText("OK");
    }

    public UIElement btnBack() {
        if (this.settings.platform == PlatformType.Android) {
            return this.find.byLocator(this.locators.imageButtonLocator(), 3);
        } else if (this.settings.platform == PlatformType.iOS) {
            return this.find.byLocator(By.id("Back"));
        } else {
            return null;
        }
    }

    public void tapOkBtn() {
        this.btnOk().tap();
    }

    public void loadedMainPage(String page) {
        if (this.wait.waitForVisible(this.locators.byText(page), this.settings.shortTimeout / 3, false) != null) {
            this.log.info(page + " page loaded.");
        } else {
            Assert.fail(page + " page NOT loaded!");
        }
    }
}
