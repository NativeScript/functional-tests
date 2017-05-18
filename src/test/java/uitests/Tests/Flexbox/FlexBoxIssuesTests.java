package uitests.Tests.Flexbox;

import org.testng.annotations.Test;

public class FlexBoxIssuesTests extends UIFlexboxBaseTest {

    @Test(groups = {"android", "ios"})
    public void flexbox_4143() throws Exception {
        this.pageFlexbox.navigateTo("flexbox-4143");
        this.assertScreen(5);
    }
}
