package perfapp;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class FlexboxTest extends PerformanceBaseTest {

    private final String additionalHeader = "Executing Time";
    private final Map<String, UIElement> tabs = new HashMap<>();

    private StringBuilder sb = new StringBuilder();
    private UIElement play;
    private UIElement result;
    private By listElementLocator;

    @DataProvider(name = "example")
    public Object[][] data() {
        return new Object[][]{
                {"flex-grid"},
                {"grid"},
                {"flex-stack"},
                {"stack"},
        };
    }

    @BeforeClass(alwaysRun = true)
    public void beforeFlexboxTestClass() {
        this.performanceBasePage = new PerformanceBasePage(PerformanceBaseTest.flexbox, this.context);
        this.performanceBasePage.navigateTo(PerformanceBaseTest.flexbox);

        By playLocator = this.locators.byText("Play");
        By resultLocator = By.xpath("//" + this.uiElements.navigationBarLocator() + "/" + this.uiElements.staticTextLocator());
        this.listElementLocator = this.locators.scrollViewLocator();
        if (this.settings.platform == PlatformType.Android) {
            playLocator = By.className(this.uiElements.linearLayoutCompatLocator());
            resultLocator = this.locators.textViewLocator();
            this.listElementLocator = By.xpath(this.uiElements.scrollViewLocator() + "//" + this.uiElements.imageLocator());
        }

        this.play = this.context.find.byLocator(playLocator);
        this.result = this.context.find.byLocator(resultLocator);

        this.tabs.put("flex-grid", this.find.byText("flex-grid"));
        this.tabs.put("grid", this.find.byText("grid"));
        this.tabs.put("flex-stack", this.find.byText("flex-stack"));
        this.tabs.put("stack", this.find.byText("stack"));
    }

    @Test(dataProvider = "example")
    public void flex_grid_stack_performance(String example) {
        this.tabs.get(example).tap();
        this.play.tap();
        this.context.wait.waitForVisible(this.listElementLocator, 5, false);

        String value = this.result.getText();

        this.logResults(example, value);
    }

    private void logResults(String example, String value) {
        PerformanceBaseTest.writeLine(this.sb, this.context, example, value);
        PerformanceBaseTest.logPerformanceToCsv(this.context, this.sb.toString(), PerformanceBaseTest.writeHeader(this.additionalHeader));
        sb.delete(0, sb.length());
        sb.setLength(1);
    }
}
