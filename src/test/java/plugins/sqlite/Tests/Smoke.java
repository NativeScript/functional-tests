package plugins.sqlite.Tests;

import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.annotations.Test;
import plugins.sqlite.Screens.HomePage;

public class Smoke extends MobileTest {

    @Test(groups = {"android", "ios"})
    public void addItems() throws Exception {
        HomePage homePage = new HomePage();
        homePage.loaded();
        homePage.addItem("Bai Milan");
        homePage.verifyItemInList("Bai Milan");
        homePage.addItem("NathanaelA");
        homePage.verifyItemInList("NathanaelA");
        this.log.logScreen("sqlite", "Sqlite home screen.");
    }
}
