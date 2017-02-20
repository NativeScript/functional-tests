package plugins.geolocation.Tests.android;

import functional.tests.core.mobile.device.android.Adb;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.basetest.MobileTest;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import plugins.geolocation.Screens.GeolocationPage;

import java.util.List;

public class GeolocationTests extends MobileTest {

    // TODO: Uncomment geolocations Adb.isAppRunning
    // latitude, longitude, altitude
    private final Location LOCATION_BOS = new Location(42.360082, -71.058881, 25); // Boston
    private final Location LOCATION_LA = new Location(34.052234, -118.243685, 25); // Los Angeles
    private final Location LOCATION_LND = new Location(51.507351, -0.127758, 25); // London
    private final Location LOCATION_NYC = new Location(40.712784, -74.005941, 25); // New York
    private final String LOCATION_BOS_TEXT = "42.360082, -71.058881";
    private final String LOCATION_LA_TEXT = "34.052234, -118.243685";
    private final String LOCATION_LND_TEXT = "51.507351, -0.127758";
    private final String LOCATION_NYC_TEXT = "40.712784, -74.005941";
    private GeolocationPage page;

    @BeforeClass
    public void beforeGeolocationTestsClass() {
        this.page = new GeolocationPage(this.context);
        if (this.settings.platformVersion.toString().startsWith("4")) {
            Adb.changeLocationMode(this.device.getId(), this.settings.deviceBootTimeout);
            this.page.tapAgreeBtn();
            this.page.tapYesBtn();
            this.page.tapEnableLocation();
        } else if (this.settings.platformVersion.toString().startsWith("6")) {
            this.page.tapEnableLocation();
            this.page.tapAllowLocation();
            Adb.startDeveloperOptions(this.settings.deviceId, this.settings.deviceBootTimeout);
            UIElement mockLocationMap = this.page.scrollTo("Select mock location app", 5);
            mockLocationMap.click();
            this.page.find.byText("appium Settings").click();
            this.device.startApplication(this.settings.packageId);
            this.device.startApplication(this.settings.packageId);
            this.device.setLocation(LOCATION_NYC);
            this.page.tapGetLocation();
            this.page.find.byText("Mode").click();
            this.page.find.byText("High accuracy").click();
            this.page.tapAgreeBtn();
            this.page.tapYesBtn();
            this.page.navigateBack();
            this.page.navigateBack();
        }
    }

    @BeforeMethod
    public void beforeGeolocationTest() {
        this.page.loaded();
    }

    @Test(groups = {"android"})
    public void geolocation_01_getLocation() throws Exception {
        this.log.info("Bear with me:");
        for (int i = 0; i < 5; i++) {
            this.log.info(Integer.toString(i));
            this.device.setLocation(LOCATION_NYC);
            this.page.tapGetLocation();
        }

        List<UIElement> items = this.page.coordinates();
        this.log.info("items.size() = " + this.page.coordinates().size());
        for (UIElement item : items) {
            this.log.info(item.getText());
        }

        UIElement item = items.get(1);
        String itemText = item.getText();
        this.log.info("item.getText() = " + itemText);

        Assert.assertTrue(itemText.contains(LOCATION_NYC_TEXT), "Expected: " + LOCATION_NYC_TEXT + "; Actual: " + itemText);
        this.page.tapClear();
    }

    @Test(groups = {"android"})
    public void geolocation_02_startMonitoring() throws Exception {
        this.page.tapStartMonitoring();
        this.device.setLocation(LOCATION_LND);
        String itemText = this.page.coordinates().get(2).getText();
        Assert.assertTrue(itemText.contains(LOCATION_LND_TEXT), "Expected: " + LOCATION_LND_TEXT + "; Actual: " + itemText);

        this.device.setLocation(LOCATION_LA);
        itemText = this.page.coordinates().get(3).getText();
        Assert.assertTrue(itemText.contains(LOCATION_LA_TEXT), "Expected: " + LOCATION_LA_TEXT + "; Actual: " + itemText);

        this.device.setLocation(LOCATION_BOS);
        itemText = this.page.coordinates().get(4).getText();
        Assert.assertTrue(itemText.contains(LOCATION_BOS_TEXT), "Expected: " + LOCATION_BOS_TEXT + "; Actual: " + itemText);
        this.log.logScreen(this.context.getTestName());
        this.page.tapStopMonitoring();
    }

    @Test(groups = {"android"})
    public void geolocation_03_showMap() throws Exception {
        this.page.tapShowMap();
        // this.page.lblMapCoordinates();
        this.log.logScreen(this.context.getTestName());
        this.page.navigateBack();
    }
}
