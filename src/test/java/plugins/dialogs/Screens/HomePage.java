package plugins.dialogs.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;

public class HomePage extends BasePage {

    public HomePage(Context context) {
        super(context);
    }

    private UIElement showLoadingDialogButton() {
        return this.find.byText("Show loading dialog");
    }

    private UIElement closeLoadingDialogButton() {
        return this.find.byText("Close loading dialog");
    }

    private UIElement showCustomDialogWithSwitchButton() {
        return this.find.byText("Show custom dialog with Switch");
    }

    public void showLoadingDialog() {
        this.showLoadingDialogButton().click();
        this.log.info("Tap on 'Show loading dialog'.");
    }

    public void closeLoadingDialog() {
        this.closeLoadingDialogButton().click();
        this.log.info("Tap on 'Show custom dialog with Switch'.");
    }

    public void showCustomDialogWithSwitch() {
        this.showCustomDialogWithSwitchButton().click();
        this.log.info("Tap on 'item 15'.");
    }

    public void loaded() {
        this.showCustomDialogWithSwitchButton();
        this.log.info("Dialogs demo home page loaded.");
    }
}