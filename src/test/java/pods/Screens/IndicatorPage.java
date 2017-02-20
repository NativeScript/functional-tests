package pods.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;

public class IndicatorPage extends BasePage {

    public IndicatorPage(MobileContext context) {
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
