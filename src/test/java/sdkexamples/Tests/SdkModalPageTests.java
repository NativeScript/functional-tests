package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkModalPageTests extends SdkBaseTest {

    private String page = "Modal view";
    private final String modalPageExample = "Modal view example";
    private final String modalPageNavigation = "Modal view navigation";
    private final String modalPageActionBar = "Modal view ActionBar";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {modalPageExample},
                {modalPageNavigation},
                {modalPageActionBar}
        };
    }

    @Test(dataProvider = "example")
    public void sdkModalPageTest(String example) {
        this.mainPage.navigateTo(example);
        if (example.equalsIgnoreCase(modalPageExample)) {
            // Set start date
            this.wait.waitForVisible(this.locators.byText("Enter Start Date")).tap();
            this.wait.waitForVisible(this.locators.byText("Submit")).tap();

            // Set end date
            this.wait.waitForVisible(this.locators.byText("Enter End Date")).tap();
            this.wait.waitForVisible(this.locators.byText("Submit")).tap();

            // Count Days
            this.wait.waitForVisible(this.locators.byText("Count Days")).tap();
            this.wait.waitForVisible(this.locators.byText("Days: 0"), true);
        }
        if (example.equalsIgnoreCase(modalPageNavigation)) {
            this.wait.waitForVisible(this.locators.byText("SHOW MODAL")).tap();
            this.wait.waitForVisible(this.locators.byText("First Modal View"), true);
            this.wait.waitForVisible(this.locators.byText("Next", true, false)).tap();
            this.wait.waitForVisible(this.locators.byText("Second Modal view"), true);
            this.wait.waitForVisible(this.locators.byText("Go Back")).tap();
            this.wait.waitForVisible(this.locators.byText("First Modal View"), true);
            this.wait.waitForVisible(this.locators.byText("CLOSE MODAL"), true).tap();
            this.wait.waitForVisible(this.locators.byText("SHOW MODAL"), true);
        }
    }
}
