package uitests.Tests.Dialogs;


import functional.tests.core.mobile.basetest.MobileTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.Dialogs.DialogsPage;

public class DialogsTests extends MobileTest {

    protected DialogsPage dialogsPage;

    @BeforeClass(alwaysRun = true)
    public void beforeDialogsTestsSuit() {
        this.dialogsPage = new DialogsPage("dialogs", this.context);
    }

    // Alert
    @Test(groups = {"android", "ios"})
    public void dialogs_11_alert() throws Exception {
        this.dialogsPage.tapAlertBtn();
        this.dialogsPage.tapOkBtn();
        String name = this.dialogsPage.label().getText();

        Assert.assertEquals(name, DialogsPage.name1);
        this.device.assertLogContains("### Result: undefined");
    }

    // Action
    @Test(groups = {"android", "ios"})
    public void dialogs_21_actionClose() throws Exception {
        this.dialogsPage.tapActionBtn();
        this.dialogsPage.tapCloseBtn();
        Assert.assertEquals(this.dialogsPage.label().getText(), DialogsPage.name0);
        this.device.assertLogContains("### Result: Close");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_22_actionNo() throws Exception {
        this.dialogsPage.tapActionBtn();
        this.dialogsPage.tapNoBtn();
        Assert.assertEquals(this.dialogsPage.label().getText(), DialogsPage.name0);
        this.device.assertLogContains("### Result: No");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_23_actionYes() throws Exception {
        this.dialogsPage.tapActionBtn();
        this.dialogsPage.tapYesBtn();
        Assert.assertEquals(this.dialogsPage.label().getText(), DialogsPage.name1);
        this.device.assertLogContains("### Result: Yes");
    }

    // Confirm
    @Test(groups = {"android", "ios"})
    public void dialogs_31_confirmIgnore() throws Exception {
        this.dialogsPage.tapConfirmBtn();
        this.dialogsPage.tapIgnoreBtn();
        Assert.assertEquals(this.dialogsPage.label().getText(), DialogsPage.name0);
        this.device.assertLogContains("### Result: undefined");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_32_confirmNo() throws Exception {
        this.dialogsPage.tapConfirmBtn();
        this.dialogsPage.tapNoBtn();
        Assert.assertEquals(this.dialogsPage.label().getText(), DialogsPage.name0);
        this.device.assertLogContains("### Result: false");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_33_confirmYes() throws Exception {
        this.dialogsPage.tapConfirmBtn();
        this.dialogsPage.tapYesBtn();
        Assert.assertEquals(this.dialogsPage.label().getText(), DialogsPage.name1);
        this.device.assertLogContains("### Result: true");
    }

    //this.log.n
    @Test(groups = {"android", "ios"})
    public void dialogs_41_loginIgnore() throws Exception {
        this.dialogsPage.tapLoginBtn();
        this.dialogsPage.tapIgnoreBtn();
        Assert.assertEquals(this.dialogsPage.label().getText(), DialogsPage.name0);
        this.device.assertLogContains("### Result: undefined, UserName: John, Password: Reese");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_42_loginCancel() throws Exception {
        this.dialogsPage.tapLoginBtn();
        this.dialogsPage.tapCancelBtn();
        Assert.assertEquals(this.dialogsPage.label().getText(), DialogsPage.name0);
        this.device.assertLogContains("### Result: false, UserName: John, Password: Reese");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_43_loginOk() throws Exception {
        this.dialogsPage.tapLoginBtn();
        this.dialogsPage.tapOkBtn();
        Assert.assertEquals(this.dialogsPage.label().getText(), DialogsPage.name1);
        this.device.assertLogContains("### Result: true, UserName: John, Password: Reese");
    }

    // Prompt
    @Test(groups = {"android", "ios"})
    public void dialogs_51_promptIgnore() throws Exception {
        this.dialogsPage.tapPromptBtn();
        this.dialogsPage.tapIgnoreBtn();
        Assert.assertEquals(this.dialogsPage.label().getText(), DialogsPage.name0);
        this.device.assertLogContains("### Result: undefined, Text: John Reese");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_52_promptCancel() throws Exception {
        this.dialogsPage.tapLoginBtn();
        this.dialogsPage.tapCancelBtn();
        Assert.assertEquals(this.dialogsPage.label().getText(), DialogsPage.name0);
        this.device.assertLogContains("### Result: false, UserName: John, Password: Reese");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_53_promptOk() throws Exception {
        this.dialogsPage.tapLoginBtn();
        this.dialogsPage.tapOkBtn();
        Assert.assertEquals(this.dialogsPage.label().getText(), DialogsPage.name1);
        this.device.assertLogContains("### Result: true, UserName: John, Password: Reese");
    }
}
