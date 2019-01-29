package templates.blank;

import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.mobile.element.UIElement;
import org.springframework.util.Assert;
import org.testng.annotations.Test;

@SuppressWarnings("groupsTestNG")
public class SmokeTests extends MobileTest {

    @Test(groups = {"android", "ios"})
    public void test_01_smoke() {
        UIElement home = this.find.byText("Home");
        Assert.notNull(home, "Failed to load home page.");
    }
}