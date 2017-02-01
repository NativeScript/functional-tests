package animations.Screens;

import functional.tests.core.element.UIElement;
import functional.tests.core.exceptions.AppiumException;
import functional.tests.core.find.Find;
import functional.tests.core.log.Log;
import org.testng.Assert;

public class DemoPage {
    private Find find;
    public Log log;

    public DemoPage(HomePage homePage) {
        this.find = homePage.find;
        this.log = homePage.log;
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

    public Boolean loaded() throws AppiumException {
        if (this.btnReset() != null) {
            this.log.info("Demo page loaded.");
            return true;
        } else {
            this.log.error("Demo page NOT loaded.");
            return false;
        }
    }

    public void loadedSlideInEffect() throws AppiumException {
        if (this.btnAddItem() != null) {
            this.log.info("Demo page loaded.");
        } else {
            Assert.fail("Demo page NOT loaded.");
        }
    }
}