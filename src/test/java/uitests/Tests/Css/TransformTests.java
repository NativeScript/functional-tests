package uitests.Tests.Css;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.TransformPage;

public class TransformTests extends CssBaseTest {

    private TransformPage transformPage;

    @BeforeClass(alwaysRun = true)
    public void beforeTransformTestsClass() {
        this.transformPage = new TransformPage(this.cssBasePage);
    }

    @Test(groups = {"android", "ios"})
    public void transform_01_none() throws Exception {
        Assert.assertEquals(this.transformPage.label().getText(), "label Label");
        Assert.assertEquals(this.transformPage.button().getText().toLowerCase(), "button button");
        Assert.assertEquals(this.transformPage.textField().getText(), "textField textField");
        Assert.assertEquals(this.transformPage.textView().getText(), "textView textView");
    }

    @Test(groups = {"android", "ios"})
    public void transform_02_capitalize() throws Exception {
        this.transformPage.tapChangeBtn();
        Assert.assertEquals(this.transformPage.label().getText(), "Label Label");
        Assert.assertEquals(this.transformPage.button().getText(), "Button Button");
        Assert.assertEquals(this.transformPage.textField().getText(), "Textfield Textfield");
        Assert.assertEquals(this.transformPage.textView().getText(), "Textview Textview");
    }

    @Test(groups = {"android", "ios"})
    public void transform_03_uppercase() throws Exception {
        this.transformPage.tapChangeBtn();
        Assert.assertEquals(this.transformPage.label().getText(), "LABEL LABEL");
        Assert.assertEquals(this.transformPage.button().getText(), "BUTTON BUTTON");
        Assert.assertEquals(this.transformPage.textField().getText(), "TEXTFIELD TEXTFIELD");
        Assert.assertEquals(this.transformPage.textView().getText(), "TEXTVIEW TEXTVIEW");
    }

    @Test(groups = {"android", "ios"})
    public void transform_04_lowercase() throws Exception {
        this.transformPage.tapChangeBtn();
        Assert.assertEquals(this.transformPage.label().getText(), "label label");
        Assert.assertEquals(this.transformPage.button().getText(), "button button");
        Assert.assertEquals(this.transformPage.textField().getText(), "textfield textfield");
        Assert.assertEquals(this.transformPage.textView().getText(), "textview textview");
        this.transformPage.navigateBack();
    }

    @Test(groups = {"android", "ios"})
    public void transform_05_changeText() throws Exception {
        this.transformPage.navigateTo("transform");
        this.transformPage.loaded();

        // Change to UPPERCASE
        this.transformPage.tapChangeBtn();
        this.transformPage.tapChangeBtn();

        // Change text
        this.transformPage.tapChangeTextBtn();
        Assert.assertEquals(this.transformPage.label().getText(), "CHANGE TEXT");
        Assert.assertEquals(this.transformPage.button().getText(), "CHANGE TEXT");
        Assert.assertEquals(this.transformPage.textField().getText(), "CHANGE TEXT");
        Assert.assertEquals(this.transformPage.textView().getText(), "CHANGE TEXT");
    }
}
