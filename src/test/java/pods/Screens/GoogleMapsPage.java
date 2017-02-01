package pods.Screens;

import functional.tests.core.basepage.BasePage;
import functional.tests.core.element.UIElement;
import org.openqa.selenium.By;

public class GoogleMapsPage extends BasePage {

    public GoogleMapsPage() {
        super();
    }

    public UIElement button() {
        return this.find.byText("TAP");
    }

    public UIElement tapsLeftText() {
        return this.find.byText("taps left", false, this.settings.defaultTimeout);
    }

    public UIElement google() {
        return this.find.byLocator(By.id("Google Maps"));
    }

    public void loaded() {
        this.button();
        this.tapsLeftText();
        this.google();
        this.log.info("GoogleMaps page loaded.");
    }
}