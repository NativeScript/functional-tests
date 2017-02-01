package groceries.Screens;

import functional.tests.core.basetest.Context;
import org.openqa.selenium.By;

public class ErrorDialog {
    private Context context;

    public ErrorDialog(Context context) {
        this.context = context;
    }

    private By btnOk() {
        return this.context.locators.byText("OK");
    }

    public void ok() {
        this.context.find.byLocator(btnOk()).click();
    }
}
