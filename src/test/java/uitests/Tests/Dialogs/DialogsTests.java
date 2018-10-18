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
        this.assertScreen(5);
        this.device.assertLogContains("### Result: undefined");
    }

    // Action
    @Test(groups = {"android", "ios"})
    public void dialogs_21_actionClose() throws Exception {
        this.dialogsPage.tapActionBtn();
        this.dialogsPage.tapCloseBtn();
        this.assertScreen(5);
        this.device.assertLogContains("### Result: Close");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_22_actionNo() throws Exception {
        this.dialogsPage.tapActionBtn();
        this.dialogsPage.tapNoBtn();
        this.assertScreen(5);
        this.device.assertLogContains("### Result: No");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_23_actionYes() throws Exception {
        this.dialogsPage.tapActionBtn();
        this.dialogsPage.tapYesBtn();
        this.assertScreen(5);
        this.device.assertLogContains("### Result: Yes");
    }

    // Confirm
    @Test(groups = {"android", "ios"})
    public void dialogs_31_confirmIgnore() throws Exception {
        this.dialogsPage.tapConfirmBtn();
        this.dialogsPage.tapIgnoreBtn();
        this.assertScreen(5);
        this.device.assertLogContains("### Result: undefined");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_32_confirmNo() throws Exception {
        this.dialogsPage.tapConfirmBtn();
        this.dialogsPage.tapNoBtn();
        this.assertScreen(5);
        this.device.assertLogContains("### Result: false");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_33_confirmYes() throws Exception {
        this.dialogsPage.tapConfirmBtn();
        this.dialogsPage.tapYesBtn();
        this.assertScreen(5);
        this.device.assertLogContains("### Result: true");
    }

    // Login
    @Test(groups = {"android", "ios"})
    public void dialogs_41_loginIgnore() throws Exception {
        this.dialogsPage.tapLoginBtn();
        this.dialogsPage.tapIgnoreBtn();
        this.assertScreen(5);
        this.device.assertLogContains("### Result: undefined, UserName: John, Password: Reese");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_42_loginCancel() throws Exception {
        this.dialogsPage.tapLoginBtn();
        this.dialogsPage.tapCancelBtn();
        this.assertScreen(5);
        this.device.assertLogContains("### Result: false, UserName: John, Password: Reese");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_43_loginOk() throws Exception {
        this.dialogsPage.tapLoginBtn();
        this.dialogsPage.tapOkBtn();
        this.assertScreen(5);
        this.device.assertLogContains("### Result: true, UserName: John, Password: Reese");
    }

    // Prompt Text
    @Test(groups = {"android", "ios"})
    public void dialogs_51_promptTextIgnore() throws Exception {
        this.dialogsPage.tapPromptTextBtn();
        this.dialogsPage.tapIgnoreBtn();
        this.assertScreen(5);
        this.device.assertLogContains("### Result: undefined, Text: John Reese");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_52_promptTextCancel() throws Exception {
        this.dialogsPage.tapPromptTextBtn();
        this.dialogsPage.tapCancelBtn();
        this.assertScreen(5);
        this.device.assertLogContains("### Result: false, Text: John Reese");
    }

    @Test(groups = {"android", "ios"})
    public void dialogs_53_promptTextOk() throws Exception {
        this.dialogsPage.tapPromptTextBtn();
        this.dialogsPage.tapOkBtn();
        this.assertScreen(5);
        this.device.assertLogContains("### Result: true, Text: John Reese");
    }


    @Test(groups = {"android", "ios"})
    public void dialogs_54_promptPassOk() throws Exception {
        this.dialogsPage.tapPromptPassBtn();

        this.dialogsPage.tapOkBtn();
        Assert.assertTrue(this.find.byText(DialogsPage.name1,false, 2) != null);
    }

    // Prompt Email
    @Test(groups = {"android", "ios"})
    public void dialogs_55_promptEmailOk() throws Exception {
        this.dialogsPage.tapPromptEmailBtn();

        this.dialogsPage.tapOkBtn();
        Assert.assertTrue(this.find.byText(DialogsPage.name1,false, 2) != null);
    }

//    Cannot simulate user input
//    @Test(groups = {"ios"})
//    public void dialogs_promptCapitalizationNone() {
//        UIElement btnShowDialog = this.find.byText("promptCapitalizationNone");
//        btnShowDialog.click();
//        String text = "prompt Capitalization None";
//        this.setText(text);
//        this.dialogsPage.tapOkBtn();
//
//        Assert.assertEquals(this.dialogsPage.label().getText(), text.toLowerCase());
//    }
//
//
//    @Test(groups = {"ios"})
//    public void dialogs_promptCapitalizationAll() {
//        UIElement btnShowDialog = this.find.byText("promptCapitalizationAll");
//        btnShowDialog.click();
//        String text = "prompt Capitalization all";
//        this.setText(text);
//        this.dialogsPage.tapOkBtn();
//
//        Assert.assertEquals(this.dialogsPage.label().getText(), text.toUpperCase());
//    }
//
//
//    @Test(groups = {"ios"})
//    public void dialogs_promptCapitalizationSentences() throws Exception {
//        UIElement btnShowDialog = this.find.byText("prompt CapitalizationAll");
//        btnShowDialog.click();
//        String text = "prompt. capitalization. sentences";
//        this.setText(text);
//        this.dialogsPage.tapOkBtn();
//
//        Assert.assertEquals(this.dialogsPage.label().getText(), "Prompt. Capitalization. Sentences");
//    }
//
//    @Test(groups = {"ios"})
//    public void dialogs_promptCapitalizationWords() throws Exception {
//        UIElement btnShowDialog = this.find.byText("promptCapitalizationWords");
//        btnShowDialog.click();
//        String text = "prompt Capitalization words";
//        this.setText(text);
//        this.dialogsPage.tapOkBtn();
//
//        Assert.assertEquals(this.dialogsPage.label().getText(), "Prompt Capitalization Words");
//    }
//
//    private void setText(String text) {
//        UIElement textField = this.find.byLocator(By.xpath("//XCUIElementTypeAlert[@name=\"Name\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther"));
//        textField.setText(text);
//    }
}
