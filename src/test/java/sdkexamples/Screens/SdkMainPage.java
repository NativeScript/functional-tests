package sdkexamples.Screens;

import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.enums.Position;
import io.appium.java_client.SwipeElementDirection;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SdkMainPage extends SdkHomePage {

    public SdkMainPage(String page, Context context) {
        super(context);
        UIElement mainPage = null;
        if (this.settings.platformVersion <= 4.4) {
            mainPage = this.gestures.swipeInWindowToElement(SwipeElementDirection.DOWN, this.locators.byText(page), 2, 250, 50);
        } else if (this.settings.platformVersion < 10 && this.settings.platform == PlatformType.iOS) {
            mainPage = this.gestures.swipeInWindowToElement(SwipeElementDirection.DOWN, this.locators.byText(page), 2, 1250, 50);
        } else {

            UIElement commonListView = this.wait.waitForVisible(this.locators.listViewLocator());
            mainPage = commonListView.scrollInElementToElement(SwipeElementDirection.DOWN, Position.FromQuarter, this.locators.byText(page), 0, 2);
        }

        this.navigateTo(mainPage);
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
        if (this.settings.platform == PlatformType.Andorid) {
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
