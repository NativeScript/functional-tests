package uitests.Screens;

import functional.tests.core.element.UIElement;
import functional.tests.core.enums.PlatformType;
import functional.tests.core.find.Find;
import org.testng.Assert;
import uitests.Screens.Css.CssBasePage;

public class TransformPage {
    private CssBasePage cssBasePage;
    private Find find;

    public TransformPage(CssBasePage cssBasePage) {
        this.cssBasePage = cssBasePage;
        this.cssBasePage.navigateTo("transform");
        this.find = cssBasePage.find;
        loaded();
    }

    private UIElement btnChangeText() {
        return this.cssBasePage.find.byText("Change text");
    }

    private UIElement btnChange() {
        return this.cssBasePage.find.byText("Change");
    }

    public UIElement label() {
        if (this.cssBasePage.settings.platform == PlatformType.Andorid) {
            return this.find.elementsByLocator((this.cssBasePage.locators.textViewLocator())).get(1);
        } else if (this.cssBasePage.settings.platform == PlatformType.iOS) {
            return this.find.byLocator(this.cssBasePage.locators.labelLocator());
        } else {
            return null;
        }
    }

    public UIElement button() {
        int indexOfBtn = 2;

        if (this.cssBasePage.settings.platform == PlatformType.iOS) {
            indexOfBtn = 4;
        }

        return this.find.elementsByLocator(this.cssBasePage.locators.buttonLocator()).get(indexOfBtn);
    }

    public UIElement textField() {
        if (this.cssBasePage.settings.platform == PlatformType.Andorid) {
            return this.find.elementsByLocator(this.cssBasePage.locators.editTextLocator()).get(0);
        } else if (this.cssBasePage.settings.platform == PlatformType.iOS) {
            return this.find.byLocator(this.cssBasePage.locators.editTextLocator());
        } else {
            return null;
        }
    }

    public UIElement textView() {
        if (this.cssBasePage.settings.platform == PlatformType.Andorid) {
            return this.find.elementsByLocator(this.cssBasePage.locators.editTextLocator()).get(1);
        } else if (this.cssBasePage.settings.platform == PlatformType.iOS) {
            return this.find.byLocator(this.cssBasePage.locators.textViewLocator());
        } else {
            return null;
        }
    }

    public void tapChangeBtn() {
        this.btnChange().click();
        cssBasePage.log.info("Tap on 'Change' button.");
    }

    public void tapChangeTextBtn() {
        this.btnChangeText().click();
        cssBasePage.log.info("Tap on 'Change text' button.");
    }

    public void loaded() {
        if (this.btnChange() != null) {
            cssBasePage.log.info("Transform page loaded.");
        } else {
            Assert.fail("Transform page NOT loaded.");
        }
    }

    public void navigateTo(String transform) {
        this.cssBasePage.navigateTo(transform);
    }

    public void navigateBack() {
        this.cssBasePage.navigateBack();
    }
}
