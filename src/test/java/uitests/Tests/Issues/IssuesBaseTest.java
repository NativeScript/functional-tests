package uitests.Tests.Issues;

import org.testng.annotations.BeforeClass;
import uitests.Screens.Issues.IssuesBasePage;
import uitests.Tests.UIBaseTests;

public class IssuesBaseTest extends UIBaseTests {

    public IssuesBasePage issuesBasePage;

    @BeforeClass(alwaysRun = true)
    public void beforeCssBaseTestClass() {
        this.issuesBasePage = new IssuesBasePage(this.context);
    }
}

