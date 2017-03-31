package animations.Screens;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.exceptions.AppiumException;
import functional.tests.core.extensions.ScrollableListObject;
import functional.tests.core.mobile.basepage.BasePageExtended;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Find;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CssAnimationsPage extends BasePageExtended {
    private Find find;

    public CssAnimationsPage(String page, MobileContext context) {
        super(page, context);
        this.find = this.context.find;
        this.init(page, context);
    }

    private void init(String page, MobileContext context) {
        if (this.settings.platform == PlatformType.Android) {
            ScrollableListObject scrollableListObject = new ScrollableListObject(context) {
                @Override
                public String getMainContainerLocatorName() {
                    return getMainContainerLocatorNameAsString();
                }

                @Override
                public String getMainContainerItemsName() {
                    return getMainContainerItemsNameAsString();
                }
            };

            scrollableListObject.setRetriesCount(3);

            this.context.navigationManager.setScrollToRectangleMethod((p) -> scrollableListObject.scrollTo(p));
            if (page != null && !page.isEmpty()) {
                this.context.navigationManager.navigateTo(page);
                this.context.navigationManager.setMainPage(page);
                this.context.navigationManager.setHomePageLocator(context.locators.byText(page));
            }
        } else {
            this.context.navigationManager.setNavigation((p) -> {
                UIElement el = this.find.byLocator(By.xpath("//" + this.getMainContainerItemsNameAsString() + "[@label='" + p + "']"));
                if (el != null) {
                    el.tap();
                    this.navigationManager.setCurrentPage(p);
                }
            });
        }
    }

    public String getMainContainerLocatorNameAsString() {
        String el = "/";
        if (this.settings.platform == PlatformType.iOS) {
            el = "XCUIElementTypeOther";
        } else {
            el = this.context.uiElementClass.viewGroupLocator();
        }
        return this.context.uiElementClass.scrollViewLocator() + "/" + el;
    }

    public String getMainContainerItemsNameAsString() {
        return this.context.uiElementClass.buttonLocator();
    }

    public UIElement btnInitialAnimation() {
        return this.find.byText("Initial Animation");
    }

    public Boolean loaded() throws AppiumException {
        if (this.btnBounce() != null) {
            this.log.info("Css Animations SdkPage loaded.");
            return true;
        } else {
            this.log.error("Css Animations SdkPage NOT loaded.");
            return false;
        }
    }

    public UIElement btnAnimate() {
        try {
            return this.find.byText("Animate");
        } catch (Exception e) {
            Assert.fail("Failed to find 'Animate' button.");
            return null;
        }
    }

    public UIElement btnReset() {
        try {
            return this.find.byText("Reset");
        } catch (Exception e) {
            Assert.fail("Failed to find 'Reset' button.");
            return null;
        }
    }

    public UIElement btnAddItem() {
        try {
            return this.find.byText("Add Item");
        } catch (Exception e) {
            Assert.fail("Failed to find 'Animate' button.");
            return null;
        }
    }

    public UIElement btn(String text) {
        try {
            return this.find.byText(text);
        } catch (Exception e) {
            Assert.fail("Failed to find '" + text + "' button.");
            return null;
        }
    }

    public void tapAnimateBtn() {
        this.btnAnimate().click();
        this.log.info("Tap on 'Animate' button.");
    }

    public void tapResetBtn() {
        this.btnReset().click();
        this.log.info("Tap on 'Reset' button.");
    }

    public void tapBtn(String text) {
        this.btn(text).click();
        this.log.info("Tap on '" + text + "' button.");
    }

    public void longPressBtn(String text) {
        this.btn(text).longPress(3000);
        this.log.info("Tap on '" + text + "' button.");
    }

    private UIElement btnBounce() {
        return this.find.byText("bounce");
    }
}