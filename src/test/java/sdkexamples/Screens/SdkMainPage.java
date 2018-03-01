package sdkexamples.Screens;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.extensions.ScrollableListObject;
import functional.tests.core.mobile.basepage.BasePageExtended;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SdkMainPage extends BasePageExtended {

    public SdkMainPage(String page, MobileContext context) {
        super(page, context);
        this.init(page, context);
    }

    private void init(String page, MobileContext context) {
        if (this.settings.platform == PlatformType.Android) {
            ScrollableListObject scrollableListObject = new ScrollableListObject(context) {
                @Override
                public String getMainContainerLocatorName() {
                    return context.uiElementClass.listViewLocator();
                }

                @Override
                public String getMainContainerItemsName() {
                    return context.uiElementClass.textViewLocator();
                }
            };

            this.context.navigationManager.setScrollToRectangleMethod((p) -> scrollableListObject.scrollTo(p));
        } else {
            this.scrollTo(page, 25);
        }

        if (page != null && !page.isEmpty()) {
            this.context.navigationManager.navigateTo(page);
            this.context.navigationManager.setMainPage(page);
            this.context.navigationManager.setHomePageLocator(context.locators.byText(page));
        }
    }

    public By btnOkLocator() {
        return this.locators.byText("OK");
    }

    public UIElement btnBack() {
        if (this.settings.platform == PlatformType.Android) {
            return this.find.byLocator(this.locators.imageButtonLocator(), 3);
        } else if (this.settings.platform == PlatformType.iOS) {
            if (this.settings.platformVersion < 11.0) {
                return this.find.byLocator(By.id("Back"), this.settings.shortTimeout);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void pageLoaded(String page) {
        if (this.context.wait.waitForVisible(this.context.locators.byText(page), this.context.settings.shortTimeout / 3, false) != null) {
            this.context.log.info(page + " page loaded.");
        } else {
            Assert.fail(page + " page NOT loaded!");
        }
    }
}
