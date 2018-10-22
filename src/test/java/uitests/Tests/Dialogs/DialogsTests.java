package uitests.Tests.Dialogs;

import functional.tests.core.mobile.basetest.MobileTest;
import functional.tests.core.mobile.element.UIElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitests.Screens.Dialogs.DialogsPage;

@SuppressWarnings("groupsTestNG")
public class DialogsTests extends MobileTest {

    private DialogsPage dialogsPage;

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
    public void dialogs_54_promptPassOk() {
        this.dialogsPage.tapPromptPassBtn();

        this.dialogsPage.tapOkBtn();
        Assert.assertNotNull(this.find.byText(DialogsPage.name1, false, 2));
    }

    // Prompt Email
    @Test(groups = {"android", "ios"})
    public void dialogs_55_promptEmailOk() {
        this.dialogsPage.tapPromptEmailBtn();

        this.dialogsPage.tapOkBtn();
        Assert.assertNotNull(this.find.byText(DialogsPage.name1, false, 2));
    }

    @Test(groups = {"ios"})
    public void dialogs_promptCapitalizationNone() {
        UIElement btnShowDialog = this.find.byText("promptCapitalizationNone");
        btnShowDialog.click();
        Assert.assertFalse(this.isKeyboardUpperCase(), "Initial state of keyboard should be lower case.");
        String text = "caP";
        this.setText(text);
        Assert.assertFalse(this.isKeyboardUpperCase(), "After capital letter state of keyboard should be reset to lower case.");
        this.dialogsPage.tapOkBtn();
        Assert.assertEquals(this.dialogsPage.getLabelText(), text);
    }


    @Test(groups = {"ios"})
    public void dialogs_promptCapitalizationAll() {
        UIElement btnShowDialog = this.find.byText("promptCapitalizationAll");
        btnShowDialog.click();
        Assert.assertTrue(this.isKeyboardUpperCase(), "Initial state of keyboard should be upper case.");
        String text = "CAp";
        this.setText(text);
        Assert.assertTrue(this.isKeyboardUpperCase(), "After small letter state of keyboard should be reset to upper case.");
        this.dialogsPage.tapOkBtn();
        Assert.assertEquals(this.dialogsPage.getLabelText(), text);
    }


    @Test(groups = {"ios"})
    public void dialogs_promptCapitalizationSentences() {
        UIElement btnShowDialog = this.find.byText("promptCapitalizationSentences");
        btnShowDialog.click();
        Assert.assertTrue(this.isKeyboardUpperCase(), "Initial state of keyboard should be upper case.");
        String text1 = "Sen";
        this.setText(text1);
        Assert.assertFalse(this.isKeyboardUpperCase(), "Keyboard should not change state until dot and space.");
        String text2 = "t. ";
        this.setText(text2);
        Assert.assertTrue(this.isKeyboardUpperCase(), "Keyboard should be upper case for new sentence.");
        this.dialogsPage.tapOkBtn();
        Assert.assertEquals(this.dialogsPage.getLabelText(), text1 + text2);
    }

    @Test(groups = {"ios"})
    public void dialogs_promptCapitalizationWords() {
        UIElement btnShowDialog = this.find.byText("promptCapitalizationWords");
        btnShowDialog.click();
        Assert.assertTrue(this.isKeyboardUpperCase(), "Initial state of keyboard should be upper case.");
        String text1 = "Wo";
        this.setText(text1);
        Assert.assertFalse(this.isKeyboardUpperCase(), "Keyboard should not change state until space.");
        String text2 = "rd ";
        this.setText(text2);
        Assert.assertTrue(this.isKeyboardUpperCase(), "Keyboard should be upper case for new word.");
        this.dialogsPage.tapOkBtn();
        Assert.assertEquals(this.dialogsPage.getLabelText(), text1 + text2);
    }

    private Boolean isKeyboardUpperCase() {
        UIElement shiftKey = this.wait.waitForVisible(By.id("shift"), this.settings.shortTimeout, true);
        String value = shiftKey.getAttribute("value");
        return value != null;
    }

    private void setText(String text) {
        UIElement textField = this.find.byLocator(By.xpath("//XCUIElementTypeTextField"));
        textField.tap();
        for (char ch : text.toCharArray()) {
            // Handle keyboard state
            Boolean isCharUpperCase = Character.isUpperCase(ch);
            UIElement shiftKey = this.wait.waitForVisible(By.id("shift"), this.settings.shortTimeout, true);
            Boolean isKeyboardUpperCase = this.isKeyboardUpperCase();
            if ((isCharUpperCase && isKeyboardUpperCase) || (!isCharUpperCase && !isKeyboardUpperCase)) {
                this.log.info("Keyboard state is ok.");
            } else {
                this.log.info("Switch upper/lower case state.");
                shiftKey.tap();
            }

            // Locate key button and tap it (with some hacks for space and dot).
            String key = Character.toString(ch);
            if (key.equals(" ")) {
                key = "space";
            }
            if (key.equals(".")) {
                UIElement b123 = this.wait.waitForVisible(By.id("more"), this.settings.shortTimeout, false);
                b123.tap();
            }
            UIElement button = this.wait.waitForVisible(By.id(key), this.settings.shortTimeout, false);
            button.tap();
            if (key.equals(".")) {
                UIElement b123 = this.wait.waitForVisible(By.id("more"), this.settings.shortTimeout, false);
                b123.tap();
            }
        }
    }
}