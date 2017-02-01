package plugins.geolocation.Tests.ios;

import functional.tests.core.basetest.UIBaseTest;
import functional.tests.core.element.UIElement;
import functional.tests.core.find.Wait;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import plugins.geolocation.Screens.GeolocationPage;

public class GeolocationTests extends UIBaseTest {

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
        this.page.loaded();
        this.page.tapEnableLocation();
        this.page.tapAllowLocation();
    }

    @BeforeMethod
    public void beforeGeolocationTest() {
        this.page.loaded();
    }

    @Test(groups = {"ios"})
    public void geolocation_01_getLocation() throws Exception {
        this.device.setLocation(LOCATION_NYC);
        Wait.sleep(2000);
        this.page.tapGetLocation();

        UIElement item = this.page.coordinates().get(0);
        String itemText = item.getText();
        Assert.assertTrue(itemText.contains(LOCATION_NYC_TEXT), "Expected: " + LOCATION_NYC_TEXT + "; Actual: " + itemText);
        this.page.tapClear();
    }

    @Test(groups = {"ios"})
    public void geolocation_02_startMonitoring() throws Exception {
        this.page.tapStartMonitoring();
        Wait.sleep(2000);
        String itemText = this.page.coordinates().get(1).getText();
        Assert.assertTrue(itemText.contains(LOCATION_NYC_TEXT), "Expected: " + LOCATION_NYC_TEXT + "; Actual: " + itemText);

        this.device.setLocation(LOCATION_LND);
        Wait.sleep(2000);
        itemText = this.page.coordinates().get(2).getText();
        Assert.assertTrue(itemText.contains(LOCATION_LND_TEXT), "Expected: " + LOCATION_LND_TEXT + "; Actual: " + itemText);

        this.device.setLocation(LOCATION_LA);
        Wait.sleep(2000);
        itemText = this.page.coordinates().get(3).getText();
        Assert.assertTrue(itemText.contains(LOCATION_LA_TEXT), "Expected: " + LOCATION_LA_TEXT + "; Actual: " + itemText);

        this.device.setLocation(LOCATION_BOS);
        Wait.sleep(2000);
        itemText = this.page.coordinates().get(4).getText();
        Assert.assertTrue(itemText.contains(LOCATION_BOS_TEXT), "Expected: " + LOCATION_BOS_TEXT + "; Actual: " + itemText);
        this.log.logScreen(this.context.getTestName());
        this.page.tapStopMonitoring();
    }

    @Test(groups = {"ios"})
    public void geolocation_03_showMap() throws Exception {
        this.page.tapShowMap();
        // this.page.lblMapCoordinates();
        this.log.logScreen(this.context.getTestName());
        this.page.navigateBack();
    }
}
