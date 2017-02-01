package uitests.Tests.Flexbox;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UIFlexboxRepeaterTests extends UIFlexboxBaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeFlexboxTests() {
        this.pageFlexbox.navigateTo("flexrepeat");
    }

    @Test(groups = {"android", "ios"})
    public void flexbox_01_repeater() throws Exception {
        this.waitForScreen();
        this.assertImagesResults();
    }
}
