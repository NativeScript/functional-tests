package uitests.Tests.Component;

import functional.tests.core.basetest.UIBaseTest;
import functional.tests.core.element.UIElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitests.Screens.HomePageExtended;

public class HtmlViewTests extends UIBaseTest {

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
