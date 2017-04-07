package galleryapp;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.extensions.ScrollableListObject;
import functional.tests.core.mobile.basepage.BasePageExtended;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.function.Predicate;

public class GalleryHomePage extends BasePageExtended {

    public GalleryHomePage(String homePage, MobileContext context) {
        super(homePage, context);
        this.init(homePage, context);
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
            scrollableListObject.setExcludeElementsFilter(new Predicate<UIElement>() {
                @Override
                public boolean test(UIElement uiElement) {
                    return !uiElement.isVisible();
                }
            });
            this.context.navigationManager.setScrollToRectangleMethod((p) -> scrollableListObject.scrollTo(p));

            if (page != null && !page.isEmpty()) {
                this.context.navigationManager.navigateTo(page);
                this.context.navigationManager.setMainPage(page);
                this.context.navigationManager.setHomePageLocator(context.locators.byText(page));
            }
        } else if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion >= 10) {
            this.context.navigationManager.setNavigation((p) -> {
                UIElement el = this.find.byLocator(By.xpath("//" + this.getMainContainerItemsNameAsString() + "[@label='" + p + "']"));
                if (el != null) {
                    el.tap();
                    this.navigationManager.setCurrentPage(p);
                }
            });

        } else {
            this.context.navigationManager.setNavigation((p) -> {
                UIElement el = this.find.byLocator(By.id(p));
                if (el != null) {
                    el.click();
                    this.navigationManager.setCurrentPage(p);
                }
            });
        }
    }

    public String getMainContainerLocatorNameAsString() {
        return this.context.uiElementClass.scrollViewLocator();
    }

    public String getMainContainerItemsNameAsString() {
        return this.context.uiElementClass.buttonLocator();
    }

    public void navigateTo(String example, By locator) {
        this.navigateToHomePage();
        super.navigateTo(example);

        if (locator != null) {
            this.wait.waitForVisible(locator, 5, true);
        }
    }

    private void loaded() {
        UIElement element = null;
        if (this.settings.platform == PlatformType.Android) {
            element = this.find.byText("TestApp");
        } else {
            element = this.find.byLocator(this.locators.scrollViewLocator());
        }
        if (element != null) {
            this.log.info("Gallery app loaded.");
        } else {
            this.log.info("Gallery app NOT loaded!");
            Assert.fail("Gallery app NOT loaded!");
        }
    }
}
