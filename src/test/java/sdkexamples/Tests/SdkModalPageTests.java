package sdkexamples.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sdkexamples.SdkBaseTest;

public class SdkModalPageTests extends SdkBaseTest {

    private String page = "Modal page";
    private final String modalPageExample = "Modal page example";
    private final String modalPageNavigation = "Modal page navigation";

    @Override
    protected String subMainPage() {
        return this.page;
    }

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {modalPageExample},
                {modalPageNavigation},
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
            this.wait.waitForVisible(this.locators.byText("First Modal Page"), true);
            this.wait.waitForVisible(this.locators.byText("Next page")).tap();
            this.wait.waitForVisible(this.locators.byText("Second Modal Page"), true);
            this.wait.waitForVisible(this.locators.byText("Go Back")).tap();
            this.wait.waitForVisible(this.locators.byText("First Modal Page"), true);
            this.wait.waitForVisible(this.locators.byText("CLOSE MODAL"), true).tap();
            this.wait.waitForVisible(this.locators.byText("SHOW MODAL"), true);
        }
    }
}
