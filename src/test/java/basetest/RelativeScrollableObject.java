package basetest;

import functional.tests.core.enums.Position;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;

import java.awt.*;

public abstract class RelativeScrollableObject {

    private Rectangle mainContainerRectangle;
    private MobileContext context;

    public RelativeScrollableObject(String page, MobileContext context) {
        this.context = context;
        this.context.navigationManager.setScrollMethod((p) -> this.scrollTo(p));
        this.context.navigationManager.setMainPage(page);
    }

    public UIElement scrollTo(String example) {
        //return this.scrollDownToElement(this.getMainContainer(), example, Position.FromCorner, 10, 100, this.getOffsetY());
        return null;
    }

    protected abstract String getMainContainerLocatorName();

    protected abstract String getMainContainerItemsName();

    protected UIElement getMainContainer() {
        return this.context.find.byLocator(By.className(this.getMainContainerLocatorName()));
    }


    protected By getMainContainerItemsLocator() {
        return By.xpath("//" + this.getMainContainerLocatorName() + "/" + this.getMainContainerItemsName());
    }

    protected java.util.List<UIElement> getMainContainerItems() {
        java.util.List<UIElement> uiElements = this.context.find.elementsByLocator(this.getMainContainerItemsLocator());
        uiElements.removeIf(e -> !e.isVisible());
        return uiElements;
    }

    protected int getOffsetY() {
        java.util.List<UIElement> elements = this.getMainContainerItems();
        int offset = (int) ((int) this.getMainContainerRectangle().getY() + this.getMainContainerRectangle().getHeight() - elements.get(elements.size() - 1).getUIRectangle().getY());

        return offset;
    }

    protected Rectangle getMainContainerRectangle() {
        if (this.mainContainerRectangle == null) {
            this.mainContainerRectangle = this.getMainContainer().getUIRectangle();
        }

        return this.mainContainerRectangle;
    }
}
