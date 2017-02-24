package tnsvscextension;

import functional.tests.core.web.basetest.WebTest;
import functional.tests.core.web.element.UIElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * TNSVSCExtension
 */
public class TNSVSCExtension extends WebTest {

    @Test
    public void smokeTest() {
        UIElement element = this.webContext.find.byLocator(By.tagName("li"));
        element.click();
        element.click();
        element.click();
        element.click();
        element.click();
    }
}
