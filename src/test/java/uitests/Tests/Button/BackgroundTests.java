package uitests.Tests.Button;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BackgroundTests extends ButtonBaseTest {
    private BackgroundPage backgroundPage;

    @BeforeClass(alwaysRun = true)
    public void beforeBackgroundTestsClass() {
        this.backgroundPage = new BackgroundPage(this.homePageExtended);
    }

    // Background
    @Test(groups = {"android", "ios"})
    public void background_11() throws Exception {
        this.compareElements(this.context.getTestName() + "_clean", this.backgroundPage.testElement(), 2, 0.1);

        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void background_12() throws Exception {
        this.executeScenario("1");
    }

    @Test(groups = {"android", "ios"})
    public void background_13() throws Exception {
        this.backgroundPage.tapResetBtn();
        this.compareElements("background_11_clean", this.backgroundPage.testElement(), 2, 0.1);

        this.assertImagesResults();

        this.homePageExtended.navigateBack();
    }

    // Border
    @Test(groups = {"android", "ios"})
    public void background_21_border() throws Exception {
        this.backgroundPage.navToBackground();
        this.executeScenario("21");
    }

    @Test(groups = {"android", "ios"})
    public void background_22_border() throws Exception {
        this.executeScenario("22");
    }

    @Test(groups = {"android", "ios"})
    public void background_23_border() throws Exception {
        this.executeScenario("23");

        this.homePageExtended.navigateBack();
    }

    // Repeat
    @Test(groups = {"android", "ios"})
    public void background_31_repeat() throws Exception {
        this.backgroundPage.navToBackground();
        this.executeScenario("31");
    }

    @Test(groups = {"android", "ios"})
    public void background_32_repeat() throws Exception {
        this.executeScenario("32");
    }

    @Test(groups = {"android", "ios"})
    public void background_33_repeat() throws Exception {
        this.executeScenario("33");
    }

    // Position
    @Test(groups = {"android", "ios"})
    public void background_41_position() throws Exception {
        this.executeScenario("41");
    }

    @Test(groups = {"android", "ios"})
    public void background_42_position() throws Exception {
        this.executeScenario("42");
    }

    @Test(groups = {"android", "ios"})
    public void background_43_position() throws Exception {
        this.executeScenario("43");
    }

    @Test(groups = {"android", "ios"})
    public void background_44_position() throws Exception {
        this.executeScenario("44");

        this.homePageExtended.navigateBack();
    }

    @Test(groups = {"android", "ios"})
    public void background_45_position() throws Exception {
        this.backgroundPage.navToBackground();

        this.executeScenario("45");
    }

    @Test(groups = {"android", "ios"})
    public void background_46_position() throws Exception {
        this.executeScenario("46");
    }

    @Test(groups = {"android", "ios"})
    public void background_47_position() throws Exception {
        this.executeScenario("47");
    }

    @Test(groups = {"android", "ios"})
    public void background_48_position() throws Exception {
        this.executeScenario("48");
    }

    @Test(groups = {"android", "ios"})
    public void background_49_position() throws Exception {
        this.executeScenario("49");

        this.homePageExtended.navigateBack();
    }

    @Test(groups = {"android", "ios"})
    public void background_50_position() throws Exception {
        this.backgroundPage.navToBackground();

        this.executeScenario("50");
    }

    @Test(groups = {"android", "ios"})
    public void background_51_position() throws Exception {
        this.executeScenario("51");
    }

    @Test(groups = {"android", "ios"})
    public void background_52_position() throws Exception {
        this.executeScenario("52");

        this.homePageExtended.navigateBack();
    }

    // Size
    @Test(groups = {"android", "ios"})
    public void background_61_size() throws Exception {
        this.backgroundPage.navToBackground();

        this.executeScenario("61");
    }

    @Test(groups = {"android", "ios"})
    public void background_62_size() throws Exception {
        this.executeScenario("62");
    }

    @Test(groups = {"android", "ios"})
    public void background_63_size() throws Exception {
        this.executeScenario("63");
    }

    @Test(groups = {"android", "ios"})
    public void background_64_size() throws Exception {
        this.executeScenario("64");

        this.homePageExtended.navigateBack();
    }

    // All
    @Test(groups = {"android", "ios"})
    public void background_71_all() throws Exception {
        this.backgroundPage.navToBackground();
        this.executeScenario("71");
    }

    @Test(groups = {"android", "ios"})
    public void background_72_all() throws Exception {
        this.executeScenario("72");
    }

    // Antialiasing
    @Test(groups = {"android", "ios"})
    public void background_78_antialiasing() throws Exception {
        this.executeScenario("78");
    }

    public void executeScenario(String button) throws Exception {
        this.backgroundPage.tapBtn(button);
        this.compareElements(this.backgroundPage.testElement(), 2, 0.1);

        this.assertImagesResults();
    }
}
