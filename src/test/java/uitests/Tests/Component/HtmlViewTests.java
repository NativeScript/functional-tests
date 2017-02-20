package uitests.Tests.Component;

import functional.tests.core.mobile.element.UIElement;
import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;

public class HtmlViewTests extends MobileTest {

    HomePageExtended homePage;

    @Test(groups = {"android", "ios"})
    public void htmlView_01() throws Exception {
        this.homePage = new HomePageExtended("htmlview", this.context);
        UIElement el = this.find.byTextContains("one");
        String htmlContent = el.getText();
        Assert.assertTrue(htmlContent.contains("one"));
        Assert.assertTrue(htmlContent.contains("two"));
    }
}
