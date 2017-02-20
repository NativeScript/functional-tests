package plugins.dialogs.Tests;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.Test;
import plugins.dialogs.Screens.HomePage;

public class SmokeTests extends MobileTest {

    @Test(groups = {"android", "ios"})
    public void smoke() throws Exception {
        new HomePage(this.context).loaded();
    }
}