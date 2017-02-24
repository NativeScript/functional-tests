package groceries.Screens;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIRectangle;
import functional.tests.core.mobile.find.Wait;
import org.openqa.selenium.Point;

import java.awt.*;

public class GroceriesItem extends UIRectangle {
    private UIRectangle check;
    private UIRectangle text;
    private UIRectangle deleteIcon;
    private org.openqa.selenium.Point center;
    private MobileContext context;

    public GroceriesItem(Rectangle rectangle, MobileContext context) {
        super(rectangle);
        this.context = context;
        this.center = new Point((this.getRectangle().x + this.getRectangle().width / 2), this.getRectangle().y + this.getRectangle().height / 2);
        this.initElements();
    }

    public void tapOnCheckBox() {
        this.check.tap();
        Wait.sleep(1000);
    }

    public void tapOnText() {
        this.text.tap();
    }

    public void tapOnDeleteIcon() {
        this.deleteIcon.tap();
        Wait.sleep(3000);
    }

    private void initElements() {
        this.elements();
    }

    private void elements() {
        this.check = new UIRectangle(UIRectangle.extendRectangle(this.rectangle, 30, this.getRectangle().height / 2, 0, 0));
        this.text = new UIRectangle(UIRectangle.extendRectangle(this.rectangle, this.getRectangle().width / 2, this.center.y, 0, 0));
        this.deleteIcon = new UIRectangle(UIRectangle.extendRectangle(this.rectangle, this.getRectangle().width - 50, this.getRectangle().height / 2, 0, 0));
    }


}
