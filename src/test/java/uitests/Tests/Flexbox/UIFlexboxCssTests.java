package uitests.Tests.Flexbox;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UIFlexboxCssTests extends UIFlexboxBaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeFlexboxTests() {
        this.pageFlexbox.navigateTo("flexboxcss");
    }

    // FlexFlow
    @Test(groups = {"android", "ios"})
    public void flexbox_01_cssFlexFlow() throws Exception {
        this.pageFlexbox.btnCssFlexFlow().tap();
        this.waitForElement();
        this.assertImagesResults();
    }

    // Order
    @Test(groups = {"android", "ios"})
    public void flexbox_02_cssOrder() throws Exception {
        this.pageFlexbox.btnCssOrder().tap();
        this.waitForElement();
        this.assertImagesResults();
    }

    // FlexGrow
    @Test(groups = {"android", "ios"})
    public void flexbox_03_cssFlexGrow() throws Exception {
        this.pageFlexbox.btnCssFlexGrow().tap();
        this.waitForElement();
        this.assertImagesResults();
    }

    // FlexShrink
    @Test(groups = {"android", "ios"})
    public void flexbox_04_cssFlexShrink() throws Exception {
        this.pageFlexbox.btnCssFlexShrink().tap();
        this.waitForElement();
        this.assertImagesResults();
    }

    // AlgnSelf
    @Test(groups = {"android", "ios"})
    public void flexbox_05_cssAlignSelf() throws Exception {
        this.pageFlexbox.btnCssAlignSelf().tap();
        this.waitForElement();
        this.assertImagesResults();
    }

    // Flex
    @Test(groups = {"android", "ios"})
    public void flexbox_06_cssFlexZero() throws Exception {
        this.pageFlexbox.btnCssFlexZero().tap();
        this.waitForElement();
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void flexbox_07_cssFlexOne() throws Exception {
        this.pageFlexbox.btnCssFlexOne().tap();
        this.waitForElement();
        this.assertImagesResults();
    }

    @Test(groups = {"android", "ios"})
    public void flexbox_08_cssFlexTwo() throws Exception {
        this.pageFlexbox.btnCssFlexTwo().tap();
        this.waitForElement();
        this.assertImagesResults();
    }
}
