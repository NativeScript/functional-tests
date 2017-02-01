package groceries.StartTests;

import functional.tests.core.basetest.UIBaseTest;
import functional.tests.core.element.UIElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Smoke tests for start and angular-start branches of Groceries app.
 */
public class StartSmokeTests extends UIBaseTest {

    @Test(groups = {"android", "ios"})
    public void groceries_01_start() throws Exception {
        UIElement helloText = this.find.byText("hello world");
        this.log.logScreen("groceries-start");
        Assert.assertNotNull(helloText, "Groceries home page not loaded.");
    }
}
