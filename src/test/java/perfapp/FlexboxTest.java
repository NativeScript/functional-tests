package perfapp;

import functional.tests.core.mobile.element.UIRectangle;
import functional.tests.core.mobile.find.Wait;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

public class FlexboxTest extends PerformanceBaseTest {

    final String header = "date,scenario,executing-time";

    private StringBuilder sb = new StringBuilder();
    private UIRectangle play;

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"flex-grid", "1"},
                {"grid", "2"},
                {"flex-stack", "3"},
                {"stack", "4"},
        };
    }

    @BeforeClass(alwaysRun = true)
    public void beforeFlexboxTestlass() {
        this.performanceBasePage = new PerformanceBasePage(PerformanceBaseTest.flexbox, this.context);
        this.performanceBasePage.navigateTo(PerformanceBaseTest.flexbox);
        this.play = new UIRectangle(this.context.find.byText("Play").getUIRectangle(), this.context);
    }

    @Test(dataProvider = "example")
    public void properties_performance(String example, String number) throws Exception {
        this.tapOnExample(example, Integer.parseInt(number));
        this.play.tap();
        Wait.sleep(1000);
        this.context.wait.waitForVisible(this.locators.scrollViewLocator(), 5, false);

        String value = this.context.find.byLocator(By.xpath("//" + this.uiElements.navigationBarLocator() + "/" + this.uiElements.staticTextLocator())).getText();

        this.logResults(example, value);
    }

    private void logResults(String example, String value) {
        long dateTimeNow = System.currentTimeMillis();
        this.sb.append(String.format("%s,%s,%s", dateTimeNow, example, value));
        PerformanceBaseTest.logPerformanceToCsv(this.context, this.sb.toString(), this.header);
    }

    private void tapOnExample(String example, int number) {
        int width = this.device.getWindowSize().width / 4 * number - 10;
        UIRectangle rect = new UIRectangle(new Rectangle(width, this.device.getWindowSize().height, (int) (this.device.getWindowSize().width / 4), 50), this.context);
        rect.tap();
    }
}
