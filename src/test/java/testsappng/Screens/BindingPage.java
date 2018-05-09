package testsappng.Screens;

import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.enums.PlatformType;
import org.openqa.selenium.By;

public class BindingPage extends HomePage {

    public BindingPage(String mainPage, MobileContext context) {
        super(mainPage, context);
    }

    public UIElement tfOneWayBinding() {
        return this.find.elementsByLocator(this.locators.editTextLocator()).get(0);
    }

    public UIElement tfTwoWayBinding() {
        return this.find.elementsByLocator(this.locators.editTextLocator()).get(1);
    }

    public UIElement tfCurlyBracket() {
        return this.find.elementsByLocator(this.locators.editTextLocator()).get(2);
    }

    public UIElement lbCurlyBracketBinding() {
        int index = 0;
        if (this.settings.platform == PlatformType.Android) {
            index = 1;
        }
        return this.find.elementsByLocator(this.locators.labelLocator()).get(index);
    }

    public UIElement btnGetValues() {
        if (this.settings.platform == PlatformType.iOS && this.settings.platformVersion < 10) {
            return this.find.byLocator(By.id("get"));
        }

        return this.find.byTextContains("get");
    }

    public UIElement btnUpdateValues() {
        return this.find.byText("update from code");
    }

    public UIElement tvResults() {
        try {
            hideKeyboard();
        } catch (Exception e) {
            this.log.error("Failed to hide keyboard");
        }
        if (this.settings.platform == PlatformType.iOS) {
            return this.find.byLocator(this.locators.textViewLocator());
        } else {
            if (this.find.elementsByLocator(this.locators.editTextLocator()).size() < 4) {
                try {
                    client.getDriver().navigate().back();
                } catch (Exception ex) {
                    this.log.error("Failed to hide keyBoard");
                }
            }

            return this.find.elementsByLocator(this.locators.editTextLocator()).get(3);
        }
    }

    public UIElement lbDate() {
        int index = 1;
        if (this.settings.platform == PlatformType.Android) {
            index = 2;
        }
        return this.find.elementsByLocator(this.locators.labelLocator()).get(index);
    }

    public void loaded() {
        loaded(tvResults());
    }

    public void insertNewValues() {
        this.tfOneWayBinding().sendKeys("1");
        this.tfTwoWayBinding().sendKeys("0");
        this.tfCurlyBracket().sendKeys("3");
        try {
            this.hideKeyboard();
        } catch (Exception e) {
            this.log.info("Failed to hide keyboard");
            this.log.error(e.getMessage());
        }
    }

    public void getResults() {
        btnGetValues().tap();
    }

    public void updateValuesFromCodeBehind() {
        btnUpdateValues().tap();
    }

    public boolean compareResults(String oneWayValue, String twoWayValue, String curlyBracket) {
        boolean result = true;
        String[] results = tvResults().getText().trim().split(";");

        if (!lbCurlyBracketBinding().getText().contains(tfTwoWayBinding().getText())) {
            result = false;
        }

        if (!compareValues(results[0], oneWayValue)) {
            result = false;
        }

        if (!compareValues(results[1], twoWayValue)) {
            result = false;
        }

        if (!compareValues(results[2], curlyBracket)) {
            result = false;
        }

        if (!lbDate().getText().equals("Friday, June 3, 2016")) {
            this.log.error(String.format("Date filtering is not working! Expected value %s is not as actual value %s", "Friday, June 3, 2016", lbDate().getText()));

            result = false;
        }

        return result;
    }

    private boolean compareValues(String value, String expectedValue) {
        String bindingResultText = value.split("is ")[1];
        if (!expectedValue.equals(bindingResultText)) {
            this.log.error(String.format("Expected value %s is not as actual value %s", expectedValue, bindingResultText));
            return false;
        }

        return true;
    }

    private static void sendKeys(UIElement element, String text) {
        element.setText(text);
    }
}
