package pods.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.basetest.Context;
import functional.tests.core.element.UIElement;

public class IndicatorPage extends BasePage {

    public IndicatorPage(Context context) {
        super(context);
    }

    public UIElement button() {
        return this.find.byText("TAP");
    }

    public UIElement tapsLeftText() {
        return this.find.byText("taps left", false, this.settings.defaultTimeout);
    }

    public void loaded() {
        this.button();
        this.tapsLeftText();
        this.log.info("Indicator page loaded.");
    }
}
