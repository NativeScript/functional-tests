package perfapp;

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

public class PropertiesTest extends PerformanceBaseTest {

    private Map<String, ArrayList<String>> perfValues;
    private final String additionalHeader = "0,100,1000,10000,1000000";

    @BeforeClass(alwaysRun = true)
    public void beforePropertiesPerfTestClass() {
        this.performanceBasePage = new PerformanceBasePage(PerformanceBaseTest.properties, this.context);
        this.performanceBasePage.navigateTo(PerformanceBaseTest.properties);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMPropertiesPerfTestMethod() {
        this.perfValues = new HashMap<String, ArrayList<String>>();
    }

    @Test()
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
        StringBuilder sb = new StringBuilder();
        for (String key : this.perfValues.keySet()) {
            PerformanceBaseTest.writeLine(sb, this.context, key, String.join(",", this.perfValues.get(key)));
        }

        perfapp.PerformanceBaseTest.logPerformanceToCsv(this.context, sb.toString(), PerformanceBaseTest.writeHeader(this.additionalHeader));
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

            this.perfValues.put(key, intValues);
        }
    }
}
