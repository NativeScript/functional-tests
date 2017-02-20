package pods.Tests;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pods.Screens.GoogleMapsPage;

public class GoogleMapsTests extends MobileTest {

	@Test(groups = {"android", "ios"})
	public void homePage() throws Exception {
		GoogleMapsPage googleMapsPage = new GoogleMapsPage();
		googleMapsPage.loaded();
		String actualTapsLeft = googleMapsPage.tapsLeftText().getText();
		Assert.assertEquals(actualTapsLeft, "42 taps left", "Default number of taps left is not 42");

		googleMapsPage.button().tap();
		actualTapsLeft = googleMapsPage.tapsLeftText().getText();
		Assert.assertEquals(actualTapsLeft, "41 taps left", "Tap does not change number of taps left");
		this.log.info("Tap TAP button reduces the tap left count.");

		googleMapsPage.button().tap();
		actualTapsLeft = googleMapsPage.tapsLeftText().getText();
		Assert.assertEquals(actualTapsLeft, "40 taps left", "Tap does not change number of taps left");
		this.log.info("Tap TAP button reduces the tap left count.");
	}
}