package plugins.dialogs.Tests;

import functional.tests.core.basetest.UIBaseTest;
import org.testng.annotations.Test;
import plugins.dialogs.Screens.HomePage;

public class SmokeTests extends UIBaseTest {

    @Test(groups = {"android", "ios"})
    public void smoke() throws Exception {
        new HomePage(this.context).loaded();
    }
}