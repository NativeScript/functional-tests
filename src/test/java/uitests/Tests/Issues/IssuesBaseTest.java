package uitests.Tests.Issues;

import functional.tests.core.enums.PlatformType;
import functional.tests.core.mobile.element.UIElement;
import io.appium.java_client.MobileBy;
import org.testng.annotations.BeforeClass;
import uitests.Screens.Issues.IssuesBasePage;
import uitests.Tests.UIBaseTests;

public class IssuesBaseTest extends UIBaseTests {

    IssuesBasePage issuesBasePage;

    @BeforeClass(alwaysRun = true)
    public void beforeCssBaseTestClass() {
        this.issuesBasePage = new IssuesBasePage(this.context);
    }
}

