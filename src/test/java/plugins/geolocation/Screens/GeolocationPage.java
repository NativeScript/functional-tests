package plugins.geolocation.Screens;

import functional.tests.core.mobile.basepage.BasePage;
import functional.tests.core.mobile.basetest.MobileContext;
import functional.tests.core.mobile.element.UIElement;
import org.testng.Assert;

import java.util.List;

public class GeolocationPage extends BasePage {

    public GeolocationPage(MobileContext context) {
        super(context);
        this.loaded();
    }

    private UIElement btnYes() {
        return this.find.byText("Yes");
    }

    private UIElement btnAgree() {
        return this.find.byText("Agree");
    }

    private UIElement btnAllow() {
        return this.find.byText("Allow");
    }

    private UIElement btnDontAllow() {
        return this.find.byText("Don't Allow");
    }

    private UIElement btnEnable() {
        return this.find.byText("Enable Location");
    }

    private UIElement btnGetLocation() {
        return this.find.byText("Get Current Location");
    }

    private UIElement btnStartMonitoring() {
        return this.find.byText("Start Monitoring");
    }

    private UIElement btnStopMonitoring() {
        return this.find.byText("Stop Monitoring");
    }

    private UIElement btnShowMap() {
        return this.find.byText("Show on Google Map");
    }

    private UIElement btnClear() {
        return this.find.byText("Clear");
    }

    public void loaded() {
        if (this.btnEnable() != null) {
            this.log.info("Geolocation app loaded.");
        } else {
            Assert.fail("Geolocation app NOT loaded.");
        }
    }

    public List<UIElement> coordinates() {
        return this.find.elementsByLocator(this.locators.labelLocator());
    }

    public UIElement lblMapCoordinates() {
        return this.find.byText("lat: 42.360082, long: -71.058881, alt: 0");
    }

    public void tapYesBtn() {
        this.btnYes().tap();
    }

    public void tapAgreeBtn() {
        this.btnAgree().tap();
    }

    public void tapEnableLocation() {
        this.btnEnable().tap();
    }

    public void tapAllowLocation() {
        this.btnAllow().tap();
    }

    public void tapGetLocation() {
        this.btnGetLocation().tap();
    }

    public void tapStartMonitoring() {
        this.btnStartMonitoring().tap();
    }

    public void tapStopMonitoring() {
        this.btnStopMonitoring().tap();
    }

    public void tapShowMap() {
        this.btnShowMap().tap();
    }

    public void tapClear() {
        this.btnClear().tap();
    }
}