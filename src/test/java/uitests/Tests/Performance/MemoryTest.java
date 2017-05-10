package uitests.Tests.Performance;

import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.find.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import perfapp.PerformanceBaseTest;

import java.util.ArrayList;
import java.util.Collections;

public class MemoryTest extends MobileTest {

    private static final int tollerance = 6000000;
    private final ArrayList<Double> memoryInfos = new ArrayList<>();
    private final String memoryLeaks = "memory-leaks";
    private PerformanceBasePage performanceBasePage;

    @BeforeClass(alwaysRun = true)
    public void beforeMemoryTestsBaseClass() {
        this.performanceBasePage = new PerformanceBasePage(memoryLeaks, this.context);
        this.performanceBasePage.navigateTo(memoryLeaks);
        this.performanceBasePage.context.navigationManager.setMainPage(memoryLeaks);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMemoryTestsBase() {
        memoryInfos.clear();
    }

    @Test(groups = {"android"})
    public void memory_leak_background_image_3538() throws Exception {
        this.performanceBasePage.navigateTo(PerformanceBaseTest.backgroundImage);
        this.navigateForward();
        this.navigateBack();
        this.navigateForward();
        this.navigateBack();
        this.navigateForward();
        this.navigateBack();
        this.navigateForward();
        this.navigateBack();
        this.navigateForward();
        this.navigateBack();
        this.navigateForward();
        this.navigateBack();
        this.navigateForward();
        this.navigateBack();

        this.assertMemoryResult();
    }

    private void assertMemoryResult() {
        Collections.sort(memoryInfos);
        double initialValue = this.memoryInfos.get(0);
        double finalValue = this.memoryInfos.get(this.memoryInfos.size() - 1);

        this.log.info(String.format("Init value %s", initialValue));
        this.log.info(String.format("Final value value %s", finalValue));

        if (finalValue > initialValue + tollerance) {
            Assert.assertTrue(false, String.format("There is a memory leak!!! The memory has increased with %s", finalValue - initialValue));
        }
    }

    private void addMemoryInfo() {
        Wait.sleep(1000);
        UIElement memoryInfoLabel = this.performanceBasePage.context.wait.forVisibleElements(this.locators.labelLocator(), 2, true).get(5);
        String valueAsString = memoryInfoLabel.getText().trim();
        double value = Double.parseDouble(valueAsString);
        if (valueAsString.length() < 8) {

        }
        memoryInfos.add(value);
    }

    private void navigateForward() {
        UIElement btnForward = this.performanceBasePage.context.find.byText("forward");
        this.performanceBasePage.navigateTo(btnForward);
        this.addMemoryInfo();
    }

    private void navigateBack() {
        UIElement btnBack = this.performanceBasePage.context.find.byText("back");
        this.performanceBasePage.navigateTo(btnBack);
        this.addMemoryInfo();
    }
}
