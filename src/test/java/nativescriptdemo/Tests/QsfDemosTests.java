package nativescriptdemo.Tests;

import nativescriptdemo.Screens.Examples.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QsfDemosTests extends QsfBaseTest {

    private LayoutsPage layoutsPage;
    private UserProfilePage userProfilePage;
    private ConferenceAgendaPage conferenceAgendaPage;
    private BarSeriesPage barSeriesPage;
    private LineSeriesPage lineSeriesPage;
    private AreaSeriesPage areaSeriesPage;
    private PieSeriesPage pieSeriesPage;
    private ItemLayoutsPage itemLayoutsPage;
    private ItemReorderPage itemReorderPage;
    private SelectionPage selectionPage;

    @BeforeClass(groups = {"android", "ios"})
    public void beforeDemosTestsClass() {
        this.layoutsPage = new LayoutsPage(this.context);
        this.userProfilePage = new UserProfilePage(this.context);
        this.conferenceAgendaPage = new ConferenceAgendaPage(this.context);
        this.barSeriesPage = new BarSeriesPage(this.context);
        this.lineSeriesPage = new LineSeriesPage(this.context);
        this.areaSeriesPage = new AreaSeriesPage(this.context);
        this.pieSeriesPage = new PieSeriesPage(this.context);
        this.itemLayoutsPage = new ItemLayoutsPage(this.context);
        this.itemReorderPage = new ItemReorderPage(this.context);
        this.selectionPage = new SelectionPage(this.context);
    }

    @AfterMethod(groups = {"android", "ios"})
    public void afterQsfDemosTest() {
        this.homePage.navigateBack();
        if (this.homePage.loaded() == false) {
            Assert.fail("Home page NOT loaded");
        }
    }

    @Test(groups = {"android", "ios"})
    public void test_01_layouts() throws Exception {
        this.homePage.navigateTo("Layouts");
        this.layoutsPage.loaded();
        this.log.logScreen("Layouts", "Layouts");

    }

    @Test(groups = {"android", "ios"})
    public void test_02_userProfile() throws Exception {
        this.homePage.navigateTo("User profile");
        this.userProfilePage.loaded();
        this.log.logScreen("UserProfile", "UserProfile");
    }

    @Test(groups = {"android", "ios"})
    public void test_03_conferenceAgenda() throws Exception {
        this.homePage.navigateTo("Conference agenda");
        this.conferenceAgendaPage.loaded();
        this.log.logScreen("ConferenceAgenda", "ConferenceAgenda");
    }

    @Test(groups = {"android", "ios"})
    public void test_04_barSeries() throws Exception {
        this.homePage.navigateTo("Bar series");
        this.barSeriesPage.loaded();
        this.log.logScreen("BarSeries", "BarSeries");
    }

    @Test(groups = {"android", "ios"})
    public void test_05_lineSeries() throws Exception {
        this.homePage.navigateTo("Line series");
        this.lineSeriesPage.loaded();
        this.log.logScreen("LineSeries", "LineSeries");
    }

    @Test(groups = {"android", "ios"})
    public void test_06_areaSeries() throws Exception {
        this.homePage.navigateTo("Area series");
        this.areaSeriesPage.loaded();
        this.log.logScreen("AreaSeries", "AreaSeries");
    }

    @Test(groups = {"android", "ios"})
    public void test_07_PieSeries() throws Exception {
        this.homePage.navigateTo("Pie series");
        this.pieSeriesPage.loaded();
        this.log.logScreen("PieSeries", "PieSeries");
    }

    @Test(groups = {"android", "ios"})
    public void test_08_itemLayouts() throws Exception {
        this.homePage.navigateTo("Item layouts");
        this.itemLayoutsPage.loaded();
        this.log.logScreen("ItemLayouts", "ItemLayouts");
    }

    @Test(groups = {"android", "ios"})
    public void test_09_itemsReorder() throws Exception {
        this.homePage.navigateTo("Item reorder");
        this.itemReorderPage.loaded();
        this.log.logScreen("ItemReorder", "ItemReorder");
    }

    @Test(groups = {"android", "ios"})
    public void test_10_selection() throws Exception {
        this.homePage.navigateTo("Selection");
        this.selectionPage.loaded();
        this.log.logScreen("Selection", "Selection");
    }
}
