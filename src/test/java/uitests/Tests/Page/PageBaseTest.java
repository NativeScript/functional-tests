package uitests.Tests.Page;

import org.testng.annotations.BeforeClass;
import uitests.Tests.UIBaseTests;

public abstract class PageBaseTest extends UIBaseTests {

    @BeforeClass(alwaysRun = true)
    public abstract void beforePageBaseTest();
}

