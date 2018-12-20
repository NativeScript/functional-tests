package unittests.Tests;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import unittests.Screens.HomePage;

@SuppressWarnings("groupsTestNG")
public class SmokeTests extends MobileTest {

    @Test(groups = {"android", "ios"})
    public void runTests() {
        HomePage homePage = new HomePage();
        boolean result = homePage.waitForTestsToComplete();
        Assert.assertTrue(result, "There are failing unit tests!");
    }
}
