package uitests.Tests.Performance;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PropertiesPerfTest extends PerformanceBaseTest {

    private Map<String, ArrayList<String>> memoryValues;

    @BeforeClass(alwaysRun = true)
    public void beforePropertiesPerfTestClass() {
        this.performanceBasePage.navigateTo(PerformanceBaseTest.properties);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMPropertiesPerfTestMethod() {
        this.memoryValues = new HashMap<String, ArrayList<String>>();
    }

    @Test(groups = {"android"})
    public void properties_performance() throws Exception {
        if (this.settings.platform == PlatformType.Android) {
            this.wait.waitForVisible(this.locators.buttonLocator()).tap();
        } else {
            this.wait.forVisibleElements(this.locators.buttonLocator(), 2, true).get(2).tap();
        }

        By locator = this.locators.editTextLocator();
        if (this.settings.platform == PlatformType.iOS) {
            locator = this.locators.textViewLocator();
        }

        UIElement result = this.wait.waitForVisible(locator);
        while (result == null) {
            result = this.wait.waitForVisible(locator);
        }

        String text = result.getText().toLowerCase();
        while (!text.contains("complete")) {
            text = result.getText().toLowerCase();
        }

        this.parseResults(text);
        this.logResults();
    }

    private void logResults() {
        String logFullName = PerformanceBaseTest.getLogFullFileName(this.context);

        long dateTimeNow = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (String key : this.memoryValues.keySet()) {
            sb.append(String.format("%s,%s,%s%s", dateTimeNow, key, String.join(",", this.memoryValues.get(key)), System.lineSeparator()));
        }

        PerformanceBaseTest.logPerformanceToCsv(logFullName, sb.toString());
    }

    private void parseResults(String text) {
        ArrayList<String> lines = new ArrayList<String>(Arrays.asList(text.split(System.lineSeparator())));
        lines.remove(0);
        lines.remove(lines.size() - 1);
        for (String line : lines) {
            String[] values = line.split("\t");
            String key = values[0].toLowerCase().trim();
            ArrayList<String> intValues = new ArrayList<>();

            for (int i = 1; i < values.length; i++) {
                intValues.add(values[i].trim());
            }

            this.memoryValues.put(key, intValues);
        }
    }
}
